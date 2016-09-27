package com.pacific.lollipop.feature.auth;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.jakewharton.rxbinding.support.v4.view.RxViewPager;
import com.pacific.lollipop.R;
import com.pacific.mvc.ActivityView;

/**
 * Created by root on 16-3-27.
 */
public class LoginView extends ActivityView<LoginActivity> {

    private Toolbar toolbar;
    private ViewPager viewPager;

    public LoginView(LoginActivity activity) {
        super(activity);
    }

    @Override
    protected void initialize(Object... args) {
        toolbar = retrieveView(R.id.tb_auth);
        toolbar.setTitle(R.string.register);
        activity.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_return);

        viewPager = retrieveView(R.id.vp_auth);
        viewPager.setAdapter((AuthFragmentAdapter) args[0]);
        RxViewPager.pageSelections(viewPager).subscribe((position) -> {
            if (position == 0) {
                toolbar.setTitle(R.string.register);
            } else {
                toolbar.setTitle(R.string.login);
            }
        });
    }
}
