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

    MA("Morocco"),
    MC("Monaco"),
    MD("Moldova"),
    MG("Madagascar"),
    MK("North Macedonia"),
    MN("Mongolia"),
    MT("Malta"),
    MX("Mexico"),
    MZ("Mozambique"),

    NA("Namibia"),
    NE("Nigeria"),
    NI("Nicaragua"),
    NL("Netherlands"),
    NO("Norway"),
    NZ("New Zealand"),

    PA("Panama"),
    PE("Peru"),
    PL("Poland"),
    PR("Puerto Rico"),
    PT("Portugal"),
    PY("Paraguay"),

    RO("Romania"),
    RS("Serbia"),
    RU("Russian Federation"),

    SE("Sweden"),
    SI("Slovenia"),
    SJ("Svalbard and Jan Mayen"),
    SK("Slovakia"),
    SM("San Marino"),
    SR("Suriname"),
    SV("El Salvador"),

    TN("Tunisia"),
    TR("Turkey"),

    UA("Ukraine"),
    US("United States"),
    UY("Uruguay"),

    VA("Holy See"),
    VE("Venezuela"),
    VN("Viet Nam"),

    ZA("South Africa"),
    ZW("Zimbabwe");

    private final String countryName;
}
