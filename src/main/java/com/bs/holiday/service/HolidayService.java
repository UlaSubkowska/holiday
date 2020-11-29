package com.bs.holiday.service;

import com.bs.holiday.dao.HolidayDao;
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
    HolidayDao holidayDao;

    //TODO remove: temporary for bootstrap
    public List<HolidayEntity> passing() {
        return holidayDao.getHolidayEntities(2019, CountryCode.AL);
    }

    public CommonHolidayDto getTheNextCommonHoliday(CountryCode code1, CountryCode code2, LocalDate date) {
        int year = date.getYear();
        List<HolidayEntity> holidays1 = holidayDao.getHolidayEntities(year, code1);
        List<HolidayEntity> holidays2 = holidayDao.getHolidayEntities(year, code2);

        List<LocalDate> dates1 = holidays1.stream()
                .filter(h -> h.getDate().isAfter(date))
                .map(HolidayEntity::getDate)
                .collect(Collectors.toList());
        List<LocalDate> dates2 = holidays2.stream()
                .filter(h -> h.getDate().isAfter(date))
                .map(HolidayEntity::getDate)
                .collect(Collectors.toList());
        List<LocalDate> commonDates = dates1.stream().filter(dates2::contains).collect(Collectors.toList());

        if (commonDates.size() == 0) {
            return getTheNextCommonHoliday(code1, code2, LocalDate.of(year+1, 1, 1));
        }

        LocalDate smallestDate = commonDates.stream().min(LocalDate::compareTo).get();
        String name1 = holidays1.stream().filter(h-> h.getDate().equals(smallestDate)).findFirst().get().getName();
        String name2 = holidays2.stream().filter(h -> h.getDate().equals(smallestDate)).findFirst().get().getName();

        return new CommonHolidayDto(smallestDate, name1, name2);
    }
}
