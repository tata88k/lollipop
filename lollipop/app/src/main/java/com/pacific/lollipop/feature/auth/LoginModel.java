package com.pacific.lollipop.feature.auth;

import com.pacific.mvc.ActivityModel;

public class LoginModel extends ActivityModel<LoginView> {

    private AuthFragmentAdapter adapter;

    public LoginModel(LoginView mvcView) {
        super(mvcView);
        adapter = new AuthFragmentAdapter(view.getController().getSupportFragmentManager());
    }

    @Override
    protected Object[] getArgs() {
        return new Object[]{adapter};
    }
}
