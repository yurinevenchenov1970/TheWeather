package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;
import com.github.yurinevenchenov1970.theweather.bean.Forecast;
import com.github.yurinevenchenov1970.theweather.bean.ForecastDate;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecast;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecastDay;
import com.github.yurinevenchenov1970.theweather.bean.Temperature;
import com.github.yurinevenchenov1970.theweather.bean.TextForecast;
import com.github.yurinevenchenov1970.theweather.bean.TextForecastDay;
import com.github.yurinevenchenov1970.theweather.bean.Wind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class BaseResponseTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "weather.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getBaseResponse(), BaseResponse.class);
    }

    private BaseResponse getBaseResponse() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setForecast(getForecast());
        return baseResponse;
    }

    private Forecast getForecast() {
        Forecast forecast = new Forecast();
        forecast.setSimpleForrecast(getSimpleForecast());
        forecast.setTextForecast(getTextForecast());
        return forecast;
    }

    private SimpleForecast getSimpleForecast() {
        SimpleForecast sf = new SimpleForecast();
        sf.setSimpleForecastDayList(getSimpleForecastDaysList());
        return sf;
    }

    private TextForecast getTextForecast() {
        TextForecast tf = new TextForecast();
        tf.setTextForecastDayList(getTextForecastDaysList());
        return tf;
    }

    // region Simple Forecast

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

    // endregion

    // region Text Forecast

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

    // endregion
}