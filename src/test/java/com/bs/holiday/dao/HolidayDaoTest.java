package com.bs.holiday.dao;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HolidayDaoTest {

    @InjectMocks
    private final HolidayDao holidayDao = new HolidayDao();

    //TODO adds some tests for WebClient, using MockWebServer? integration tests?
}
