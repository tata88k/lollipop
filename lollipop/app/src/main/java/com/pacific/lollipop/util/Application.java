package com.pacific.lollipop.util;

import android.support.multidex.MultiDexApplication;

/**
 * Created by root on 16-3-26.
 */
public class Application extends MultiDexApplication {
    private static Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public synchronized static Application getInstance() {
        return mInstance;
    }
}
