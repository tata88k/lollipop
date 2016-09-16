package com.pacific.lollipop;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by root on 9/16/16.
 */

@Singleton
@Component
public interface AppConponent {
    void inject(App app);
}
