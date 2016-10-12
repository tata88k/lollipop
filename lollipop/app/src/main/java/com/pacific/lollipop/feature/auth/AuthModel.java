package com.pacific.lollipop.feature.auth;

import android.support.annotation.StringRes;

import com.pacific.mvc.ActivityModel;

public class AuthModel extends ActivityModel<AuthView> {
    public AuthModel(AuthView view) {
        super(view);
    }

    public void snack(@StringRes int resId) {
        view.snack(resId);
    }

    public void dismissSnack() {
        view.dismissSnack();
    }

    public void setTitle(@StringRes int resId) {
        view.setTitle(resId);
    }
}
