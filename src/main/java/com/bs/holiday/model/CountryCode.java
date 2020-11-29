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
    AT("Austria");

    private final String countryName;
}
