package com.github.yurinevenchenov1970.theweather.dagger;

import android.content.Context;
import android.net.ConnectivityManager;

import dagger.Module;
import dagger.Provides;

/**
 * @author Yuri Nevenchenov on 1/11/2018.
 */
@Module
public class MainModule {

    @Provides
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}