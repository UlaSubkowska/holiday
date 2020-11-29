package com.bs.holiday.service;

import com.bs.holiday.dao.HolidayDao;
import com.bs.holiday.model.HolidayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {

    @Autowired
    HolidayDao holidayDao;

    //TODO remove: temporary for bootstrap
    public HolidayEntity[] passing() {
        return holidayDao.getHolidayEntities();
    }
}
