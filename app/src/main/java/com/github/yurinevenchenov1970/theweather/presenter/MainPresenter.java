package com.github.yurinevenchenov1970.theweather.presenter;

import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;

import java.util.List;

/**
 * @author Yuri Nevenchenov on 12/20/2017.
 */

public interface MainPresenter {
    void treatCityViewChanges(String partialCity);

    void treatCityResponse(List<String> citiesList);

    void treatCitySelection(String city);

    void treatForecastLengthChanges(int forecastLength);

    void getForecast(String city);

    void treatForecastResponse(List<SimpleWeatherToShow> weatherList);

    void showForecast(int forecastLength);

    void treatError(int errorDescription);

    void showError(int errorDescription);
}