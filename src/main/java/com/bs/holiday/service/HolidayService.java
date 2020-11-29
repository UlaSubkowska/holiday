package com.bs.holiday.service;

import com.bs.holiday.dao.HolidayDao;
import com.bs.holiday.model.CommonHolidayDto;
import com.bs.holiday.model.CountryCode;
import com.bs.holiday.model.HolidayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HolidayService {

    @Autowired
    HolidayDao holidayDao;

    //TODO remove: temporary for bootstrap
    public HolidayEntity[] passing() {
        return holidayDao.getHolidayEntities(2019, CountryCode.AL);
    }

    //TODO add implementation
    public CommonHolidayDto getTheNextCommonHoliday(CountryCode code1, CountryCode code2, LocalDate date) {
        return null;
    }
}
