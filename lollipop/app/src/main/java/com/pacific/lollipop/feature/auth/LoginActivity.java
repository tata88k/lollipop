package com.pacific.lollipop.feature.auth;

import android.os.Bundle;

import com.pacific.lollipop.R;
import com.pacific.mvc.Activity;

public class LoginActivity extends Activity<LoginModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        model = new LoginModel(new LoginView(this));
        model.onCreate();
    }
}
