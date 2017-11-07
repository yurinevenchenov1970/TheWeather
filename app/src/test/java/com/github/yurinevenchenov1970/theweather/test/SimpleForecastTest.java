package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.ForecastDate;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecast;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecastDay;
import com.github.yurinevenchenov1970.theweather.bean.Temperature;
import com.github.yurinevenchenov1970.theweather.bean.Wind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for @link SimpleForecast
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class SimpleForecastTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "simple_forecast.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getSimpleForecast(), SimpleForecast.class);
    }

    private SimpleForecast getSimpleForecast() {
        SimpleForecast sf = new SimpleForecast();
        sf.setSimpleForecastDayList(getSimpleForecastDaysList());
        return sf;
    }

    private List<SimpleForecastDay> getSimpleForecastDaysList() {
        List<SimpleForecastDay> sfdl = new ArrayList<>();
        sfdl.add(createSimpleDay(26, 6, 2012, 1, 20, 10, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", 34, "West", 27, "West"));
        sfdl.add(createSimpleDay(27, 6, 2012, 2, 22, 12, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", 18, "WSW", 14, "WSW"));
        sfdl.add(createSimpleDay(28, 6, 2012, 3, 22, 12, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", 22, "West", 19, "WSW"));
        sfdl.add(createSimpleDay(29, 6, 2012, 4, 20, 11, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", 18, "West", 16, "West"));

        return sfdl;
    }

    private SimpleForecastDay createSimpleDay(int day, int month, int year,
                                              int period,
                                              int hiTemper, int lowTemper,
                                              String iconUrl,
                                              int maxWindSpeed, String maxWindDir,
                                              int aveWindSpeed, String aveWindDir) {
        SimpleForecastDay sfd = new SimpleForecastDay();
        sfd.setForecastDate(getDate(day, month, year));
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