package com.bs.holiday.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class HolidayEntity {
    //TODO consider conversion to some kind of date object
    private String date;
    private String localName;
    private String name;
    //TODO consider conversion to enum
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private ArrayList<String> counties;
    //TODO consider conversion to some kind of date object
    private String launchYear;
    //TODO consider conversion to enum
    private String type;
}
