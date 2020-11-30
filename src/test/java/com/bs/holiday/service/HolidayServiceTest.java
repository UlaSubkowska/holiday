package com.bs.holiday.service;

import com.bs.holiday.dao.HolidayDao;
import com.bs.holiday.errorHandling.BadRequestException;
import com.bs.holiday.model.CommonHolidayDto;
import com.bs.holiday.model.CountryCode;
import com.bs.holiday.model.HolidayEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class HolidayServiceTest {

    @InjectMocks
    private final HolidayService holidayService = new HolidayService();

    @Mock
    private HolidayDao holidayDao;

    @Test
    public void getTheNextCommonHoliday_success_inGivenYear() {
        when(holidayDao.getHolidayEntities(2020, CountryCode.AR)).thenReturn(getArgentinianHolidays2020());
        when(holidayDao.getHolidayEntities(2020, CountryCode.PL)).thenReturn(getPolishHolidays2020());

        CommonHolidayDto commonHoliday = holidayService.getTheNextCommonHoliday(CountryCode.AR, CountryCode.PL, LocalDate.of(2020, 12, 20));

        assertEquals(commonHoliday.getDate(), LocalDate.of(2020, 12, 25));
        assertEquals(commonHoliday.getName1(), "Christmas Day");
        assertEquals(commonHoliday.getName2(), "Christmas Day");
    }

    @Test
    public void getTheNextCommonHoliday_success_inGivenYear_skipUncommonHoliday() {
        when(holidayDao.getHolidayEntities(2020, CountryCode.AR)).thenReturn(getArgentinianHolidays2020());
        when(holidayDao.getHolidayEntities(2020, CountryCode.PL)).thenReturn(getPolishHolidays2020());

        CommonHolidayDto commonHoliday = holidayService.getTheNextCommonHoliday(CountryCode.AR, CountryCode.PL, LocalDate.of(2020, 3, 10));

        assertEquals(commonHoliday.getDate(), LocalDate.of(2020, 5, 1));
        assertEquals(commonHoliday.getName1(), "Labour Day");
        assertEquals(commonHoliday.getName2(), "May Day");
    }

    @Test
    public void getTheNextCommonHoliday_success_inGivenYear_exactHolidayDate_thenReturnTheNextHoliday() {
        when(holidayDao.getHolidayEntities(2020, CountryCode.AR)).thenReturn(getArgentinianHolidays2020());
        when(holidayDao.getHolidayEntities(2020, CountryCode.PL)).thenReturn(getPolishHolidays2020());

        CommonHolidayDto commonHoliday = holidayService.getTheNextCommonHoliday(CountryCode.AR, CountryCode.PL, LocalDate.of(2020, 1, 1));

        assertEquals(commonHoliday.getDate(), LocalDate.of(2020, 5, 1));
        assertEquals(commonHoliday.getName1(), "Labour Day");
        assertEquals(commonHoliday.getName2(), "May Day");
    }

    @Test
    public void getTheNextCommonHoliday_success_inNextYear() {
        when(holidayDao.getHolidayEntities(2020, CountryCode.AR)).thenReturn(getArgentinianHolidays2020());
        when(holidayDao.getHolidayEntities(2020, CountryCode.PL)).thenReturn(getPolishHolidays2020());
        when(holidayDao.getHolidayEntities(2021, CountryCode.AR)).thenReturn(getArgentinianHolidays2021());
        when(holidayDao.getHolidayEntities(2021, CountryCode.PL)).thenReturn(getPolishHolidays2021());

        CommonHolidayDto commonHoliday = holidayService.getTheNextCommonHoliday(CountryCode.AR, CountryCode.PL, LocalDate.of(2020, 12, 26));

        assertEquals(commonHoliday.getDate(), LocalDate.of(2021, 1, 1));
        assertEquals(commonHoliday.getName1(), "New Year's Day");
        assertEquals(commonHoliday.getName2(), "New Year's Day");
    }

    @Test(expected = BadRequestException.class)
    public void getTheNextCommonHoliday_failed_noCommonHolidayInTheNext50Years() {
        int year = 1970;
        for (int i = 0; i < 2; i++) {
            when(holidayDao.getHolidayEntities(year, CountryCode.AR)).thenReturn(new ArrayList<>());
            when(holidayDao.getHolidayEntities(year, CountryCode.PL)).thenReturn(new ArrayList<>());
            year++;
        }

        holidayService.getTheNextCommonHoliday(CountryCode.AR, CountryCode.PL, LocalDate.of(1970, 12, 26));
    }

    private List<HolidayEntity> getArgentinianHolidays2020() {
        List<HolidayEntity> holidays = new ArrayList<>();

        holidays.add(createHolidayEntity(LocalDate.of(2020, 1, 1), "New Year's Day", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 2, 24), "Carnival", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 3, 24), "Day of Remembrance for Truth and Justice", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 5, 1), "Labour Day", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 7, 9), "Independence Day", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 12, 25), "Christmas Day", CountryCode.AR));
        return holidays;
    }

    private List<HolidayEntity> getArgentinianHolidays2021() {
        List<HolidayEntity> holidays = new ArrayList<>();
        holidays.add(createHolidayEntity(LocalDate.of(2021, 1, 1), "New Year's Day", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2021, 2, 15), "Carnival", CountryCode.AR));
        holidays.add(createHolidayEntity(LocalDate.of(2021, 3, 24), "Day of Remembrance for Truth and Justice", CountryCode.AR));
        return holidays;
    }

    private List<HolidayEntity> getPolishHolidays2020() {
        List<HolidayEntity> holidays = new ArrayList<>();
        holidays.add(createHolidayEntity(LocalDate.of(2020, 1, 1), "New Year's Day", CountryCode.PL));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 4, 12), "Easter Day", CountryCode.PL));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 5, 1), "May Day", CountryCode.PL));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 11, 11), "Independence Day", CountryCode.PL));
        holidays.add(createHolidayEntity(LocalDate.of(2020, 12, 25), "Christmas Day", CountryCode.PL));
        return holidays;
    }

    private List<HolidayEntity> getPolishHolidays2021() {
        List<HolidayEntity> holidays = new ArrayList<>();
        holidays.add(createHolidayEntity(LocalDate.of(2021, 1, 1), "New Year's Day", CountryCode.PL));
        holidays.add(createHolidayEntity(LocalDate.of(2021, 4, 4), "Easter Day", CountryCode.PL));
        return holidays;
    }

    private HolidayEntity createHolidayEntity(LocalDate date, String name, CountryCode countryCode) {
        HolidayEntity entity = new HolidayEntity();
        entity.setDate(date);
        entity.setName(name);
        entity.setCountryCode(countryCode);
        return entity;
    }
}
