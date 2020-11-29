package com.bs.holiday.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommonHolidayDto {
    private LocalDate date;
    private String name1;
    private String name2;
}

