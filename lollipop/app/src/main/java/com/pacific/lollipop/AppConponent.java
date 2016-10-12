package com.pacific.lollipop;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface AppConponent {
    void inject(App app);
}
