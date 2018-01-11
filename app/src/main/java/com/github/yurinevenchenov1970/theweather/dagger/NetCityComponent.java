package com.github.yurinevenchenov1970.theweather.dagger;

import com.github.yurinevenchenov1970.theweather.model.CityAutocompleteModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Yuri Nevenchenov on 1/7/2018.
 */
@Singleton
@Component(modules = {AppModule.class, NetCityModule.class})
public interface NetCityComponent {

    void inject(CityAutocompleteModel model);
}