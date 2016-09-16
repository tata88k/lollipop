package com.pacific.lollipop;

import android.support.multidex.MultiDexApplication;

/**
 * Created by root on 16-3-26.
 */
public class App extends MultiDexApplication {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getInstance() {
        return mInstance;
    }
}
