package com.bs.holiday.controller;

import com.bs.holiday.errorHandling.BadRequestException;
import com.bs.holiday.model.CommonHolidayDto;
import com.bs.holiday.model.CountryCode;
import com.bs.holiday.model.HolidayEntity;
import com.bs.holiday.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("/")
    public String index() {
        return "Hey, it's start page for holiday service. Please use /nextCommonHoliday endpoint.";
    }

    //TODO consider some better error handling solution
    @GetMapping("/nextCommonHoliday")
    public ResponseEntity<?> getTheNextCommonHoliday(
            @RequestParam("countryCode1") String countryCode1,
            @RequestParam("countryCode2") String countryCode2,
            @RequestParam("date") String date) {
        try {
            CountryCode code1 = validateCountryCode(countryCode1);
            CountryCode code2 = validateCountryCode(countryCode2);
            LocalDate localDate = validateDate(date);
            CommonHolidayDto commonHoliday = holidayService.getTheNextCommonHoliday(code1, code2, localDate);
            return ResponseEntity.ok(commonHoliday);
        } catch (Exception exception) {
            if(exception instanceof BadRequestException) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
            }
            throw exception;
        }
    }

    private CountryCode validateCountryCode(String code) {
        try {
            return CountryCode.valueOf(code);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Country code: " + code + " is not supported");
        }
    }

    private LocalDate validateDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new BadRequestException(e.getMessage());
        }
    }


    //TODO remove: temporary for bootstrap
    @GetMapping("/passing")
    public HolidayEntity[] passing() {
        return holidayService.passing();
    }
}
