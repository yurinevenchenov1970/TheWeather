package com.github.yurinevenchenov1970.theweather.net;

import com.github.yurinevenchenov1970.theweather.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Yuri Nevenchenov on 10/26/2017.
 */

public interface WeatherService {

    @GET("forecast10day/q/{city}.json")
    Call<BaseResponse> getWeather(@Path("city") String city);
}