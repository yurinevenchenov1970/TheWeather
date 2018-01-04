package com.github.yurinevenchenov1970.theweather.presenter;

import com.github.yurinevenchenov1970.theweather.AppToGetContext;
import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.github.yurinevenchenov1970.theweather.model.CityAutocompleteModel;
import com.github.yurinevenchenov1970.theweather.model.ForecastFormingModel;
import com.github.yurinevenchenov1970.theweather.view.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuri Nevenchenov on 12/22/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private final MainView mMainView;
    private final CityAutocompleteModel mCityAutocompleteModel;
    private final ForecastFormingModel mForecastFormingModel;

    private String mCity;
    private List<SimpleWeatherToShow> mForecastList;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
        mCityAutocompleteModel = new CityAutocompleteModel(this);
        mForecastFormingModel = new ForecastFormingModel(this);
    }

    @Override
    public void treatCityViewChanges(String partialCity) {
        getCitiesList(partialCity);
    }

    @Override
    public void getCitiesList(String partialCity) {
        mCityAutocompleteModel.getCitiesListFromServer(partialCity);
    }

    @Override
    public void treatCityResponse(List<String> citiesList) {
        showAvailableCitiesList(citiesList);
    }

    @Override
    public void showAvailableCitiesList(List<String> citiesList) {
        mMainView.showAvailableCitiesList(citiesList);
    }

    @Override
    public void treatCitySelection(String city) {
        mCity = city;
        getForecast(mCity);
    }

    @Override
    public void treatForecastLengthChanges(int forecastLength) {
        if (mCity != null) {
            if (mForecastList == null) {
                getForecast(mCity);
            }
            showForecast(forecastLength);
        }
    }

    @Override
    public void getForecast(String city) {
        mForecastFormingModel.getForecast(city);
    }

    @Override
    public void treatForecastResponse(List<SimpleWeatherToShow> weatherList) {
        if (weatherList == null) {
            treatError(AppToGetContext.getContext().getString(R.string.missing_forecast_for_the_city));
        } else {
            mForecastList = weatherList;
            int forecastLength = mMainView.getForecastLength();
            showForecast(forecastLength);
        }
    }

    @Override
    public void showForecast(int forecastLength) {
        if (forecastLength + 1 < mForecastList.size()) {
            forecastLength += 1;
        }
        mMainView.showForecast(new ArrayList<>(mForecastList.subList(0, forecastLength)));
    }

    @Override
    public void treatError(String errorDescription) {
        showError(errorDescription);
    }

    @Override
    public void showError(String errorDescription) {
        mMainView.showError(errorDescription);
    }
}