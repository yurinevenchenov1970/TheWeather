package com.github.yurinevenchenov1970.theweather.net;

import com.github.yurinevenchenov1970.theweather.bean.CitiesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Yuri Nevenchenov on 10/26/2017.
 */

public interface CityService {

    @GET("aq")
    Call<CitiesList> getCity(@Query("query") String city);
}