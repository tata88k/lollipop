package com.pacific.lollipop.mvc.controller;

import android.os.Bundle;

import com.pacific.lollipop.R;
import com.pacific.lollipop.mvc.model.LoginModel;
import com.pacific.lollipop.mvc.view.LoginView;
import com.pacific.mvc.Activity;

public class LoginActivity extends Activity<LoginModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mvcModel = new LoginModel(new LoginView(this));
        mvcModel.onCreate();
    }
}
