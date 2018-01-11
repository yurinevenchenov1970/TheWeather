package com.github.yurinevenchenov1970.theweather.bean;

import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.WeatherApp;

/**
 * @author Yuri Nevenchenov on 10/27/2017.
 */

public class SimpleWeatherToShow {

    private String data;
    private String icon;
    private String temperature;
    private String wind;

    private String speedSign = WeatherApp.getContext().getResources().getString(R.string.kph_symbol);

    public SimpleWeatherToShow(ForecastDate forecastDate,
                               String icon,
                               Temperature lowTemperature, Temperature highTemperature,
                               Wind aveWind, Wind maxWind) {
        this.data = forecastDate.getDay() + "." +
                forecastDate.getMonth() + "." +
                forecastDate.getYear();
        this.icon = icon;
        this.temperature = lowTemperature.getTemperature() + " - " + highTemperature.getTemperature() + " C";
        this.wind = aveWind.getWindDirection() + " " + aveWind.getWindSpeed() + speedSign +
                " - " + maxWind.getWindDirection() + " " + maxWind.getWindSpeed() + speedSign;
    }

    public String getDataString() {
        return data;
    }

    public String getIconPath() {
        return icon;
    }

    public String getTemperatureString() {
        return temperature;
    }

    public String getWindString() {
        return wind;
    }
}