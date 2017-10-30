package com.github.yurinevenchenov1970.theweather.bean;

/**
 * @author Yuri Nevenchenov on 10/27/2017.
 */

public class TextWeatherToShow {

    private String textForecast;

    public TextWeatherToShow(String textForecast) {
        this.textForecast = textForecast;
    }

    public String getTextForecast() {
        return textForecast;
    }
}