package com.github.yurinevenchenov1970.theweather;

import android.app.Application;
import android.content.Context;

/**
 * @author Yuri Nevenchenov on 10/30/2017.
 */

public class AppToGetContext extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}