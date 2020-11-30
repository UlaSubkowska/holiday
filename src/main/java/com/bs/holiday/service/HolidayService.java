package com.bs.holiday.service;

import com.bs.holiday.dao.HolidayDao;
import com.bs.holiday.errorHandling.BadRequestException;
import com.bs.holiday.model.CommonHolidayDto;
import com.bs.holiday.model.CountryCode;
import com.bs.holiday.model.HolidayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    @Autowired
    private HolidayDao holidayDao;

    private static final int MAX_NUMBER_OF_YEARS_TO_CHECK = 50;

    public CommonHolidayDto getTheNextCommonHoliday(CountryCode code1, CountryCode code2, LocalDate date) {
        CommonHolidayDto commonHoliday = null;
        LocalDate tempDate = date.plusDays(1);
        int repeat = 0;
        while (commonHoliday == null) {
            commonHoliday = findCommonHolidayInYear(code1, code2, tempDate);
            tempDate = LocalDate.of(tempDate.getYear()+1,1,1);
            if(repeat == MAX_NUMBER_OF_YEARS_TO_CHECK) {
                throw new BadRequestException("Given countries don't have common holiday in the next "
                        + MAX_NUMBER_OF_YEARS_TO_CHECK
                        +" years in the future, so please choose different country codes");
            }
            repeat++;
        }
        return commonHoliday;
    }

    private CommonHolidayDto findCommonHolidayInYear(CountryCode code1, CountryCode code2, LocalDate date) {
        int year = date.getYear();
        List<HolidayEntity> holidays1 = holidayDao.getHolidayEntities(year, code1);
        List<HolidayEntity> holidays2 = holidayDao.getHolidayEntities(year, code2);

        List<LocalDate> dates1 = holidays1.stream()
                .filter(h -> h.getDate().isAfter(date.minusDays(1)))
                .map(HolidayEntity::getDate)
                .collect(Collectors.toList());
        List<LocalDate> dates2 = holidays2.stream()
                .filter(h -> h.getDate().isAfter(date.minusDays(1)))
                .map(HolidayEntity::getDate)
                .collect(Collectors.toList());
        List<LocalDate> commonDates = dates1.stream().filter(dates2::contains).collect(Collectors.toList());

        if (commonDates.size() > 0) {
            LocalDate smallestDate = commonDates.stream().min(LocalDate::compareTo).get();
            String name1 = holidays1.stream().filter(h -> h.getDate().equals(smallestDate)).findFirst().get().getName();
            String name2 = holidays2.stream().filter(h -> h.getDate().equals(smallestDate)).findFirst().get().getName();

            return new CommonHolidayDto(smallestDate, name1, name2);
        }
        return null;
    }
}
