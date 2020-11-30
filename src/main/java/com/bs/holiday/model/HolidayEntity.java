package com.bs.holiday.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HolidayEntity {
    private LocalDate date;
    private String name;
    private CountryCode countryCode;
}
