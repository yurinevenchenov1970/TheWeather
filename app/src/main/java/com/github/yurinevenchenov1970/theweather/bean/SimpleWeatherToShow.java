package com.github.yurinevenchenov1970.theweather.bean;

/**
 * @author Yuri Nevenchenov on 10/27/2017.
 */

public class SimpleWeatherToShow {

    private String data;
    private String icon;
    private String temperature;
    private String wind;

    public SimpleWeatherToShow(ForecastDate forecastDate,
                               String icon,
                               Temperature lowTemperature, Temperature highTemperature,
                               Wind aveWind, Wind maxWind, String speedSign) {
        this.data = forecastDate.getDay() + "." +
                forecastDate.getMonth() + "." +
                forecastDate.getYear();
        this.icon = icon;
        this.temperature = lowTemperature.getTemperature() + "-" + highTemperature.getTemperature() + " C";
        this.wind = aveWind.getWindDirection() + " " + aveWind.getWindSpeed() + speedSign +
                "-" + maxWind.getWindDirection() + " " + maxWind.getWindSpeed() + speedSign;
        // to pass speedSign call (this.(getResources().)getString(R.string.kph_symbol) in Activity where instance created
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