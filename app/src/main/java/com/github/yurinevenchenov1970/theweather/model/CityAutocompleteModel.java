package com.github.yurinevenchenov1970.theweather.model;

import android.util.Log;

import com.github.yurinevenchenov1970.theweather.R;
import com.github.yurinevenchenov1970.theweather.bean.CitiesList;
import com.github.yurinevenchenov1970.theweather.bean.City;
import com.github.yurinevenchenov1970.theweather.net.ApiClientCity;
import com.github.yurinevenchenov1970.theweather.net.CityService;
import com.github.yurinevenchenov1970.theweather.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Yuri Nevenchenov on 12/22/2017.
 */

public class CityAutocompleteModel extends MainModel {
    private final MainPresenter mMainPresenter;
    private CityService mCityService;
    private List<String> mCitiesList;

    public CityAutocompleteModel(MainPresenter mainPresenter) {
        super(mainPresenter);
        mMainPresenter = mainPresenter;
        mCitiesList = new ArrayList<>();
    }

    public void getCitiesListFromServer(String partialCity) {
        mCityService = ApiClientCity.getClient().create(CityService.class);
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
    }

    private void convertCitiesListToStringList(CitiesList list) {
        for (City city : list.getCitiesList()) {
            mCitiesList.add(city.getCityName());
        }
    }
}