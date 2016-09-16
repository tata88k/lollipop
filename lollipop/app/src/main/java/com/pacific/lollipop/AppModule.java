package com.pacific.lollipop;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by root on 9/16/16.
 */

@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public App provideApp(){
        return app;
    }

    @Provides
    public OkHttpClient okHttpClient(){
        return  new OkHttpClient.Builder().build();
    }
}
