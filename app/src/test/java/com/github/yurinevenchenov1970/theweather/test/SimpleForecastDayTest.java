package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.ForecastDate;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecastDay;
import com.github.yurinevenchenov1970.theweather.bean.Temperature;
import com.github.yurinevenchenov1970.theweather.bean.Wind;

import org.junit.Test;

/**
 * Test for @link SimpleForecastDay
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class SimpleForecastDayTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "simple_forecast_day.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getSimpleForecastDays(), SimpleForecastDay.class);
    }

    private SimpleForecastDay getSimpleForecastDays() {
        SimpleForecastDay day = createSimpleDay(29, 6, 2012, 4, 20, 11, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", 18, "West", 16, "West");
        return day;
    }

    private SimpleForecastDay createSimpleDay(int day, int month, int year,
                                              int period,
                                              int hiTemper, int lowTemper,
                                              String iconUrl,
                                              int maxWindSpeed, String maxWindDir,
                                              int aveWindSpeed, String aveWindDir) {
        SimpleForecastDay sfd = new SimpleForecastDay();
        sfd.setForecasrDate(getDate(day, month, year));
        sfd.setPeriod(period);
        sfd.setHighTemperature(getTemperature(hiTemper));
        sfd.setLowTemperature(getTemperature(lowTemper));
        sfd.setIconUrl(iconUrl);
        sfd.setMaxWind(getWind(maxWindSpeed, maxWindDir));
        sfd.setAveWind(getWind(aveWindSpeed, aveWindDir));

        return sfd;
    }

    private ForecastDate getDate(int day, int month, int year) {
        ForecastDate date = new ForecastDate();
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    private Temperature getTemperature(int temper) {
        Temperature t = new Temperature();
        t.setTemperature(temper);
        return t;
    }

    private Wind getWind(int speed, String direction) {
        Wind wind = new Wind();
        wind.setWindSpeed(speed);
        wind.setWindDirection(direction);
        return wind;
    }
}