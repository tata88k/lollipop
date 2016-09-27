package com.pacific.lollipop;

import android.app.Application;

/**
 * Created by root on 16-3-26.
 */
public class App extends Application {
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
