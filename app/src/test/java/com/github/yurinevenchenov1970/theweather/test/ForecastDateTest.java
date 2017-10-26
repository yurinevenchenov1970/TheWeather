package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.ForecastDate;

import org.junit.Test;

/**
 * Test for @link ForecastDate
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class ForecastDateTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "forecast_date.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getForecastDate(), ForecastDate.class);
    }

    private ForecastDate getForecastDate() {
        ForecastDate date = createDate(29, 6, 2012);
        return date;
    }

    private ForecastDate createDate(int day, int month, int year) {
        ForecastDate date = new ForecastDate();
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }
}