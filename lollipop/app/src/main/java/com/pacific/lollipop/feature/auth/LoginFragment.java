package com.pacific.lollipop.feature.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.lollipop.R;

public class LoginFragment extends AuthFragment<LoginModel> {

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        model = new LoginModel(new LoginView(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        model.onDestroy();
    }

    public void gotoRegister() {
        callback.replaceFragment(R.id.fl_container, RegisterFragment.newInstance(), true);
    }

    public void gotoPassword() {

    }

    public void login(String email, String password) {

    }
}
