package com.github.yurinevenchenov1970.theweather;

import android.app.Application;
import android.content.Context;

import com.github.yurinevenchenov1970.theweather.dagger.AppModule;
import com.github.yurinevenchenov1970.theweather.dagger.DaggerNetCityComponent;
import com.github.yurinevenchenov1970.theweather.dagger.DaggerNetWeatherComponent;
import com.github.yurinevenchenov1970.theweather.dagger.NetCityComponent;
import com.github.yurinevenchenov1970.theweather.dagger.NetCityModule;
import com.github.yurinevenchenov1970.theweather.dagger.NetWeatherComponent;
import com.github.yurinevenchenov1970.theweather.dagger.NetWeatherModule;

/**
 * @author Yuri Nevenchenov on 10/26/2017.
 */

public class WeatherApp extends Application {

    private static final String BASE_CITY_URL = "http://autocomplete.wunderground.com/";
    private static final String BASE_WEATHER_URL = "http://api.wunderground.com/api/636b6d8468f29aa8/";

    private static NetCityComponent sNetCityComponent;
    private static NetWeatherComponent sNetWeatherComponent;

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sNetCityComponent = DaggerNetCityComponent.builder()
                .appModule(new AppModule(this))
                .netCityModule(new NetCityModule(BASE_CITY_URL))
                .build();

        sNetWeatherComponent = DaggerNetWeatherComponent.builder()
                .appModule(new AppModule(this))
                .netWeatherModule(new NetWeatherModule(BASE_WEATHER_URL))
                .build();

        sContext = this.getApplicationContext();
    }

    public static NetCityComponent getNetCityComponent() {
        return sNetCityComponent;
    }

    public static NetWeatherComponent getNetWeatherComponent() {
        return sNetWeatherComponent;
    }

    public static Context getContext() {
        return sContext;
    }
}