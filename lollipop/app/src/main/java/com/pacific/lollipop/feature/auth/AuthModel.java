package com.pacific.lollipop.feature.auth;

import com.pacific.mvc.ActivityModel;

public class AuthModel extends ActivityModel<AuthView> {

    private AuthFragmentAdapter adapter;

    public AuthModel(AuthView mvcView) {
        super(mvcView);
        adapter = new AuthFragmentAdapter(view.getController().getSupportFragmentManager());
    }

    @Override
    protected Object[] getArgs() {
        return new Object[]{adapter};
    }
}
