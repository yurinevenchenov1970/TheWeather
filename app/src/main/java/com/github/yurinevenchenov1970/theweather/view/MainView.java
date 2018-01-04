package com.github.yurinevenchenov1970.theweather.view;

import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;

import java.util.List;

/**
 * @author Yuri Nevenchenov on 12/20/2017.
 */

public interface MainView {
    void showAvailableCitiesList(List<String> availableCities);

    int getForecastLength();

    void showForecast(List<SimpleWeatherToShow> forecastList);

    void showError(String errorDescription);
}