package com.pacific.lollipop.feature.auth;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;

import com.pacific.lollipop.R;
import com.pacific.mvc.ActivityView;

public class AuthView extends ActivityView<AuthActivity> {
    private Toolbar toolbar;
    private Snackbar snack;

    public AuthView(AuthActivity activity) {
        super(activity);
    }

    @Override
    protected void initialize(Object... args) {
        toolbar = retrieveView(R.id.tb_auth);
        setTitle(R.string.login);
        activity.setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> {
            if (AuthFragment.pageIndex != 0) {
                activity.getSupportFragmentManager().popBackStack();
            }
        });
        activity.replaceFragment(R.id.fl_container, LoginFragment.newInstance(), false);
    }

    public void snack(int resIs) {
        dismissSnack();
        snack = Snackbar.make(toolbar, resIs, Snackbar.LENGTH_SHORT)
                .setAction(R.string.snack_close, (v) -> snack.dismiss());
        snack.show();
    }

    public void dismissSnack() {
        if (snack != null && snack.isShown()) snack.dismiss();
    }

    public void setTitle(@StringRes int resId) {
        toolbar.setTitle(resId);
        if (resId == R.string.login) {
            toolbar.setNavigationIcon(R.drawable.ic_logo);
        } else {
            toolbar.setNavigationIcon(R.drawable.ic_return);
        }
    }
}
