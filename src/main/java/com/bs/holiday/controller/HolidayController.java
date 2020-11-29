package com.bs.holiday.controller;

import com.bs.holiday.model.HolidayEntity;
import com.bs.holiday.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("/")
    public String index() {
        return "Hey, it's start page for holiday service. Please use /nextCommonHoliday endpoint.";
    }

    //TODO implement this method
    @GetMapping("/nextCommonHoliday")
    public void getTheNextCommonHoliday() {

    }

    //TODO remove: temporary for bootstrap
    @GetMapping("/passing")
    public HolidayEntity[] passing() {
        return holidayService.passing();
    }
}
