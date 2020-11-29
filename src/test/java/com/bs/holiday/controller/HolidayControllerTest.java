package com.bs.holiday.controller;

import com.bs.holiday.model.CommonHolidayDto;
import com.bs.holiday.model.CountryCode;
import com.bs.holiday.service.HolidayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class HolidayControllerTest {

    @InjectMocks
    private final HolidayController holidayController = new HolidayController();

    @Mock
    private HolidayService holidayService;

    @Test
    public void getTheNextCommonHoliday_success() {
        CommonHolidayDto commonHolidayDto = new CommonHolidayDto(LocalDate.of(2019, 3, 5), "Carnaval", "Huge carnaval");
        when(holidayService.getTheNextCommonHoliday(any(CountryCode.class), any(CountryCode.class), any(LocalDate.class)))
                .thenReturn(commonHolidayDto);

        ResponseEntity<?> response = holidayController.getTheNextCommonHoliday("AR", "AR", "2019-02-14");

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), commonHolidayDto);
    }

    @Test
    public void getTheNextCommonHoliday_badRequest_unsupportedCountryCode() {
        ResponseEntity<?> response = holidayController.getTheNextCommonHoliday("AQ", "AR", "2019-02-14");

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getBody(), "Country code: AQ is not supported");
    }

    @Test
    public void getTheNextCommonHoliday_badRequest_incorrectDateFormat() {
        ResponseEntity<?> response = holidayController.getTheNextCommonHoliday("AR", "AR", "2019-02-89");

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getBody(), "Text '2019-02-89' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): 89");
    }
}
