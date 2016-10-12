package com.pacific.lollipop;

import android.app.Application;

import io.victoralbertos.rx1_permissions_result.RxPermissionsResult;

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RxPermissionsResult.register(this);
    }

    public static App getInstance() {
        return instance;
    }
}
