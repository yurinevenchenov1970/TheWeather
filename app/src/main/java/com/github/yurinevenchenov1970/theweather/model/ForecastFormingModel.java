package com.github.yurinevenchenov1970.theweather.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.WeatherApp;
import com.github.yurinevenchenov1970.theweather.adapter.WeatherExtractor;
import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;
import com.github.yurinevenchenov1970.theweather.bean.SimpleWeatherToShow;
import com.github.yurinevenchenov1970.theweather.net.WeatherService;
import com.github.yurinevenchenov1970.theweather.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Yuri Nevenchenov on 12/22/2017.
 */

public class ForecastFormingModel extends MainModel {
    private final MainPresenter mMainPresenter;
    private BaseResponse mBaseResponse;
    List<SimpleWeatherToShow> mWeatherList;

    @Inject
    WeatherService mWeatherService;

    @Inject
    ConnectivityManager mConnectivityManager;

    public ForecastFormingModel(MainPresenter mainPresenter) {
        super(mainPresenter);
        WeatherApp.getNetWeatherComponent().inject(this);
        mMainPresenter = mainPresenter;
    }

    public void getForecast(String city) {
        if (hasConnection()) {
            Call<BaseResponse> responseCall = mWeatherService.getWeather(city);
            responseCall.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                    mBaseResponse = response.body();
                    if (mBaseResponse == null) {
                        mMainPresenter.treatError(R.string.no_server_responce);
                    } else {
                        formForecastList();
                        mMainPresenter.treatForecastResponse(mWeatherList);
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {
                    mMainPresenter.treatError(R.string.error_message);
                    Log.e("getWeatherFromServer", t.getMessage());
                }
            });
        } else {
            mMainPresenter.treatError(R.string.no_internet_connection);
        }
    }

    private void formForecastList() {
        mWeatherList = WeatherExtractor.extractSimpleWeatherToShow(mBaseResponse);
    }

    private boolean hasConnection() {
        boolean connected = false;
        if (mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        }
        return connected;
    }
}