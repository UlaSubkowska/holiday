package com.bs.holiday.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonHolidayDto {
    // TODO consider conversion to some kind of date object
    private String date;
    private String name1;
    private String name2;
}

