package com.github.yurinevenchenov1970.theweather.adapter;

import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecast;
import com.github.yurinevenchenov1970.theweather.bean.SimpleForecastDay;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.github.yurinevenchenov1970.theweather.bean.TextForecast;
import com.github.yurinevenchenov1970.theweather.bean.TextForecastDay;
import com.github.yurinevenchenov1970.theweather.bean.TextWeatherToShow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuri Nevenchenov on 10/28/2017.
 */

public class WeatherExtractor {

    private BaseResponse mBaseResponse;
    private TextWeatherToShow mTextWeatherToShow;
    private SimpleWeatherToShow mSimpleWeatherToShow;

    public static List<String> extractTextWeatherToShow(BaseResponse response, int forecastLength) {
        TextForecast textForecast = response.getForecast().getTextForecast();
        List<TextForecastDay> list = textForecast.getTextForecastDayList();
        List<String> textWeatherArray = new ArrayList<>();
        for (int i = 0; i < forecastLength; i++){
            textWeatherArray.add(list.get(i).getForecastText());
        }
            return textWeatherArray;
    }

    public List<SimpleWeatherToShow> extractSimpleWeatherToShow(BaseResponse response) {
        SimpleForecast simpleForecast = response.getForecast().getSimpleForecast();


        List<SimpleForecastDay> simpleForecastDayList = simpleForecast.getSimpleForecastDayList();
        return null;
    }
}