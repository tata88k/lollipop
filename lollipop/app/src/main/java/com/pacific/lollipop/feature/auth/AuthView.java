package com.pacific.lollipop.feature.auth;

import android.support.v7.widget.Toolbar;

import com.pacific.lollipop.R;
import com.pacific.mvc.ActivityView;

public class AuthView extends ActivityView<AuthActivity> {

    private Toolbar toolbar;

    public AuthView(AuthActivity activity) {
        super(activity);
    }

    @Override
    protected void initialize(Object... args) {
        toolbar = retrieveView(R.id.tb_auth);
        toolbar.setTitle(R.string.sign_in);
        activity.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_return);
        activity.replaceFragment(R.id.fl_container, LoginFragment.newInstance(), false);
    }
}
