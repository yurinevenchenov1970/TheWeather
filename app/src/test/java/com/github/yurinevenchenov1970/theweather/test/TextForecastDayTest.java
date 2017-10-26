package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.TextForecastDay;

import org.junit.Test;

/**
 * Test for @link TextForecastDay
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class TextForecastDayTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "text_forecast_day.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getTextForecastDay(), TextForecastDay.class);
    }

    private TextForecastDay getTextForecastDay() {

        TextForecastDay day = createTextDay(0, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Partly cloudy in the morning, then clear. High of 20C. Windy. Winds from the West at 20 to 35 km/h.");
        return day;
    }

    private TextForecastDay createTextDay(int period,
                                          String iconUrl,
                                          String metricForecastText) {
        TextForecastDay tfd = new TextForecastDay();

        tfd.setPeriod(period);
        tfd.setIconUrl(iconUrl);
        tfd.setForecastText(metricForecastText);
        return tfd;
    }
}