package com.github.yurinevenchenov1970.theweather.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.WeatherApp;
import com.github.yurinevenchenov1970.theweather.bean.CitiesList;
import com.github.yurinevenchenov1970.theweather.bean.City;
import com.github.yurinevenchenov1970.theweather.net.CityService;
import com.github.yurinevenchenov1970.theweather.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Yuri Nevenchenov on 12/22/2017.
 */

public class CityAutocompleteModel extends MainModel {
    private final MainPresenter mMainPresenter;
    private List<String> mCitiesList;

    @Inject
    CityService mCityService;

    @Inject
    ConnectivityManager mConnectivityManager;

    public CityAutocompleteModel(MainPresenter mainPresenter) {
        super(mainPresenter);
        WeatherApp.getNetCityComponent().inject(this);
        mMainPresenter = mainPresenter;
        mCitiesList = new ArrayList<>();
    }

    public void getCitiesListFromServer(String partialCity) {
        if (hasConnection()) {
            Call<CitiesList> responseCall = mCityService.getCity(partialCity);
            responseCall.enqueue(new Callback<CitiesList>() {
                @Override
                public void onResponse(Call<CitiesList> call, Response<CitiesList> response) {
                    mCitiesList.clear();
                    CitiesList cityResponse = response.body();
                    if (cityResponse == null) {
                        mCitiesList.add("There are no available cities");
                    } else {
                        convertCitiesListToStringList(cityResponse);
                    }
                    mMainPresenter.treatCityResponse(mCitiesList);
                }

                @Override
                public void onFailure(Call<CitiesList> call, Throwable t) {
                    mMainPresenter.treatError(R.string.error_message);
                    Log.e("getCitiesFromServer", t.getMessage());
                }
            });
        } else {
            mMainPresenter.treatError(R.string.no_internet_connection);
        }
    }

    private void convertCitiesListToStringList(CitiesList list) {
        for (City city : list.getCitiesList()) {
            mCitiesList.add(city.getCityName());
        }
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