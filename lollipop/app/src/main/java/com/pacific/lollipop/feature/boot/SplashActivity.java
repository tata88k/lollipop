package com.pacific.lollipop.feature.boot;

import android.os.Bundle;

import com.pacific.lollipop.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class SplashActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
