package com.github.yurinevenchenov1970.theweather.dagger;

import com.github.yurinevenchenov1970.theweather.model.ForecastFormingModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Yuri Nevenchenov on 1/7/2018.
 */
@Singleton
@Component(modules = {AppModule.class, NetWeatherModule.class})
public interface NetWeatherComponent {

    void inject(ForecastFormingModel model);
}