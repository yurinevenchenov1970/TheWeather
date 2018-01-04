package com.github.yurinevenchenov1970.theweather.model;

import com.github.yurinevenchenov1970.theweather.AppToGetContext;
import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.adapter.WeatherExtractor;
import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.github.yurinevenchenov1970.theweather.net.ApiClientWeather;
import com.github.yurinevenchenov1970.theweather.net.WeatherService;
import com.github.yurinevenchenov1970.theweather.presenter.MainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Yuri Nevenchenov on 12/22/2017.
 */

public class ForecastFormingModel extends MainModel {
    private final MainPresenter mMainPresenter;
    private WeatherService mWeatherService;
    private BaseResponse mBaseResponse;
    List<SimpleWeatherToShow> mWeatherList;

    public ForecastFormingModel(MainPresenter mainPresenter) {
        super(mainPresenter);
        mMainPresenter = mainPresenter;
    }

    public void getForecast(String city) {
        getResponseFromServer(city);
    }

    private void getResponseFromServer(String city) {
        mWeatherService = ApiClientWeather.getClient().create(WeatherService.class);
        Call<BaseResponse> responseCall = mWeatherService.getWeather(city);
        responseCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                mBaseResponse = response.body();
                if (mBaseResponse == null) {
                    mMainPresenter.treatError(AppToGetContext.getContext().getString(R.string.no_server_responce));
                } else {
                    formForecastList();
                    mMainPresenter.treatForecastResponse(mWeatherList);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                mMainPresenter.treatError("failure " + t.getMessage());
            }
        });
    }

    private void formForecastList() {
            mWeatherList = WeatherExtractor.extractSimpleWeatherToShow(mBaseResponse);
    }
}