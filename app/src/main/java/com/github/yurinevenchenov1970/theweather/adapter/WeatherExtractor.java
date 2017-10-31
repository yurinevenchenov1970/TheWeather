package com.github.yurinevenchenov1970.theweather.adapter;

import com.github.yurinevenchenov1970.theweather.AppToGetContext;
import com.github.yurinevenchenov1970.theweather.R;
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
        for (int i = 0; i <= forecastLength; i++){
            String dayInForecast;
            int period = list.get(i).getPeriod();
            if(period==0){
                dayInForecast = "Today";
            }else{
                dayInForecast = String.valueOf(period);
            }
            textWeatherArray.add(dayInForecast + "   " + list.get(i).getForecastText());
        }
            return textWeatherArray;
    }

    public static List<SimpleWeatherToShow> extractSimpleWeatherToShow(BaseResponse response, int forecastLength) {
        SimpleForecast simpleForecast = response.getForecast().getSimpleForecast();
        List<SimpleForecastDay> simpleForecastDayList = simpleForecast.getSimpleForecastDayList();
        List<SimpleWeatherToShow> simpleWeatherArray = new ArrayList<>();
        for (int i = 0; i <= forecastLength; i++){
            simpleWeatherArray.add(convertSimpleForecastDayToWeatherToShow(simpleForecastDayList.get(i)));
        }
        return simpleWeatherArray;
    }

    private static SimpleWeatherToShow convertSimpleForecastDayToWeatherToShow(SimpleForecastDay simpleForecastDay){
        return new SimpleWeatherToShow(simpleForecastDay.getForecastDate(),
                simpleForecastDay.getIconUrl(),
                simpleForecastDay.getLowTemperature(), simpleForecastDay.getHighTemperature(),
                simpleForecastDay.getAveWind(), simpleForecastDay.getMaxWind());
    }
}