package com.pacific.lollipop.feature.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.lollipop.R;

public class RegisterFragment extends AuthFragment<RegisterModel> {

    public RegisterFragment() {
    }

    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new RegisterModel(new RegisterView(this));
        pageIndex++;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_validate, container, false);
    }

    public void fetchAuthCode(String str) {
    }

    public void gotoLogin() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        model.onDestroy();
        pageIndex--;
    }
}
