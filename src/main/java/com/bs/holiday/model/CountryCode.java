package com.bs.holiday.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryCode {
    AL("Albania"),
    AD("Andorra"),
    AR("Argentina"),
    AU("Australia"),
    AT("Austria"),

    PL("Poland"),
    US("United States");

    private final String countryName;
}
