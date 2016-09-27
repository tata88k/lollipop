package com.pacific.lollipop.feature.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.lollipop.R;
import com.pacific.mvc.Fragment;

public class AuthCodeFragment extends Fragment<AuthCodeModel> {

    public AuthCodeFragment() {
    }

    public static AuthCodeFragment newInstance() {
        AuthCodeFragment fragment = new AuthCodeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        model = new AuthCodeModel(new AuthCodeView(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auth_code, container, false);
    }

    public void fetchAuthCode(String str) {
    }
}
