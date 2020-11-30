# Introduction

Holidays api, returns the next common holiday in the 2 countries considered.
Support 100 countries (the exact list of supported country codes according to ISO 3166-1 alpha-2 : src/main/java/com.bs.holiday/model/CountryCode).
Base on the external third part api Public Holiday (theapiguy) from rapidAPI.

# Getting Started

Project is base on Java 11, Maven 3.6, Spring Boot 2.4

Requirements to run locally:
Apache Maven installed :  https://maven.apache.org/install.html
X-RapidAPI-Key to rapidAPI:
    1. sign up to get key on : https://rapidapi.com/theapiguy/api/public-holiday/endpoints,
    2. move to https://rapidapi.com/theapiguy/api/public-holiday/endpoints
    3. cope X-RapidAPI-Key from header parameters

Run locally:
1. add env variable BS_HOLIDAY_API_KEY with value of X-RapidAPI-Key
    export BS_HOLIDAY_API_KEY={value_of_X-RapidAPI-Key}
2. run command ./mvnw spring-boot:run in the root directory

The holiday api would be available on the default port: localhost:8080
Available endpoints:
    GET: localhost:8080/nextCommonHoliday
    the request params are required: countryCode1, countryCode2, date (format: YYYY-MM-DD)
    example: localhost:8080/nextCommonHoliday?countryCode1=PL&countryCode2=AR&date=2020-04-26

Currently there is no deployed version of api