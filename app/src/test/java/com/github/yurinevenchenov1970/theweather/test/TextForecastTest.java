package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.TextForecast;
import com.github.yurinevenchenov1970.theweather.bean.TextForecastDay;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for @link TextForecast
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class TextForecastTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "text_forecast.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getTextForecast(), TextForecast.class);
    }

    private TextForecast getTextForecast() {
        TextForecast tf = new TextForecast();
        tf.setTextForecastDayList(getTextForecastDaysList());
        return tf;
    }

    private List<TextForecastDay> getTextForecastDaysList() {
        List<TextForecastDay> tfdl = new ArrayList<>();
        tfdl.add(createTextDay(0, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Partly cloudy in the morning, then clear. High of 20C. Windy. Winds from the West at 20 to 35 km/h."));
        tfdl.add(createTextDay(1, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Mostly cloudy. Fog overnight. Low of 10C. Breezy. Winds from the WSW at 10 to 20 km/h."));
        tfdl.add(createTextDay(2, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Mostly cloudy. Fog early. High of 22C. Breezy. Winds from the WSW at 15 to 20 km/h."));
        tfdl.add(createTextDay(3, "http://icons-ak.wxug.com/i/c/k/mostlycloudy.gif", "Overcast. Fog overnight. Low of 12C. Breezy. Winds from the WSW at 10 to 20 km/h."));
        tfdl.add(createTextDay(4, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Overcast in the morning, then partly cloudy. Fog early. High of 22C. Breezy. Winds from the WSW at 15 to 25 km/h."));
        tfdl.add(createTextDay(5, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Partly cloudy in the evening, then overcast. Fog overnight. Low of 12C. Breezy. Winds from the WNW at 10 to 20 km/h."));
        tfdl.add(createTextDay(6, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Overcast in the morning, then partly cloudy. Fog early. High of 20C. Breezy. Winds from the West at 10 to 20 km/h."));
        tfdl.add(createTextDay(7, "http://icons-ak.wxug.com/i/c/k/partlycloudy.gif", "Mostly cloudy. Fog overnight. Low of 11C. Winds from the West at 10 to 15 km/h."));

        return tfdl;
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