package com.pacific.lollipop.feature.auth;

import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.pacific.lollipop.R;
import com.pacific.lollipop.util.StringUtil;
import com.pacific.mvc.FragmentView;

public class LoginView extends FragmentView<LoginFragment> {

    private AutoCompleteTextView email;
    private EditText password;

    public LoginView(LoginFragment fragment) {
        super(fragment);
    }

    @Override
    protected void initialize(Object... args) {
        email = retrieveView(R.id.ac_email);
        password = retrieveView(R.id.edit_password);
        retrieveView(R.id.btn_login).setOnClickListener(v -> {
            String emailValue = email.getText().toString();
            if (!StringUtil.isEmailValid(emailValue)) {
                fragment.snack(R.string.email_error);
                return;
            }
            String passwordValue = password.getText().toString();
            if (!StringUtil.isPasswordValid(passwordValue)) {
                fragment.snack(R.string.password_error);
                return;
            }
            fragment.login(emailValue, passwordValue);
        });
        retrieveView(R.id.tv_create).setOnClickListener(v -> fragment.gotoRegister());
        retrieveView(R.id.tv_forgot).setOnClickListener(v -> fragment.gotoPassword());

        fragment.setTitle(R.string.login);
    }
}
