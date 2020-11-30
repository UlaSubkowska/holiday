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

    BB("Barbados"),
    BE("Belgium"),
    BG("Bulgaria"),
    BJ("Benin"),
    BO("Bolivia"),
    BR("Brazil"),
    BS("Bahamas"),
    BW("Botswana"),
    BY("Belarus"),
    BZ("Belize"),

    CA("Canada"),
    CH("Switzerland"),
    CL("Chile"),
    CN("China"),
    CO("Colombia"),
    CR("Costa Rica"),
    CU("Cuba"),
    CY("Cyprus"),
    CZ("Czechia"),

    DE("Germany"),
    DK("Denmark"),
    DO("Dominican Republic"),

    EC("Ecuador"),
    EE("Estonia"),
    EG("Egypt"),
    ES("Spain"),

    FI("Finland"),
    FO("Faroe Islands"),
    FR("France"),

    GA("Gabon"),
    GB("United Kingdom"),
    GD("Grenada"),
    GL("Greenland"),
    GM("Gambia"),
    GR("Greece"),
    GT("Guatemala"),
    GY("Guyana"),

    HN("Honduras"),
    HR("Croatia"),
    HT("Haiti"),
    HU("Hungary"),

    ID("Indonesia"),
    IE("Ireland"),
    IM("Isle of Man"),
    IS("Iceland"),
    IT("Italy"),

    JE("Jersey"),
    JM("Jamaica"),
    JP("Japan"),

    LI("Liechtenstein"),
    LS("Lesotho"),
    LT("Lithuania"),
    LU("Luxembourg"),
    LV("Latvia"),


    PL("Poland"),
    US("United States");

    private final String countryName;
}
