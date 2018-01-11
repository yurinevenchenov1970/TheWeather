package com.github.yurinevenchenov1970.theweather.dagger;

import com.github.yurinevenchenov1970.theweather.net.CityService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Yuri Nevenchenov on 1/7/2018.
 */
@Module
public class NetCityModule extends MainModule {

    private final String mBaseUrl;

    public NetCityModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Converter.Factory provideJacksonConverterFactory() {
        return JacksonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory factory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(factory)
                .build();
    }

    @Provides
    @Singleton
    CityService provideCityService(Retrofit retrofit) {
        return retrofit.create(CityService.class);
    }
}