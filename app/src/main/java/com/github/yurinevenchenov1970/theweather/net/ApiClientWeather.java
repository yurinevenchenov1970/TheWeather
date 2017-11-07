package com.github.yurinevenchenov1970.theweather.net;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Yuri Nevenchenov on 10/26/2017.
 */

public class ApiClientWeather {

    private static final String BASE_URL = "http://api.wunderground.com/api/636b6d8468f29aa8/";
    private static Retrofit sRetrofit = null;

    private ApiClientWeather() {
        throw new IllegalStateException("can't create an object");
    }

    public static Retrofit getClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}