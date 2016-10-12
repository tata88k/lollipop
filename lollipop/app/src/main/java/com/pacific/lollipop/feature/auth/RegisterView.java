package com.pacific.lollipop.feature.auth;

import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.binaryfork.spanny.Spanny;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.pacific.lollipop.R;
import com.pacific.lollipop.util.LevelUtil;
import com.pacific.lollipop.util.StringUtil;
import com.pacific.mvc.FragmentView;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;

public class RegisterView extends FragmentView<RegisterFragment> {
    private TextView agreement;
    private AutoCompleteTextView email;
    private EditText code;
    private View clear;

    public RegisterView(RegisterFragment fragment) {
        super(fragment);
    }

    @Override
    protected void initialize(Object... args) {
        agreement = retrieveView(R.id.tv_agreement);
        email = retrieveView(R.id.ac_email);
        code = retrieveView(R.id.edit_code);
        clear = retrieveView(R.id.img_clear);
        RxTextView
                .textChanges(email)
                .debounce(500, TimeUnit.MICROSECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(str -> {
                    if (TextUtils.isEmpty(str)) {
                        if (clear.getVisibility() != View.INVISIBLE) {
                            clear.setVisibility(View.INVISIBLE);
                        }
                    } else {
                        if (clear.getVisibility() != View.VISIBLE) {
                            clear.setVisibility(View.VISIBLE);
                        }
                    }
                });

        clear.setOnClickListener(v -> email.setText(null));
        retrieveView(R.id.btn_get_code).setOnClickListener(v -> {
            String value = email.getText().toString();
            if (StringUtil.isEmailValid(value)) {
                fragment.fetchAuthCode(value);
            } else {
                fragment.snack(R.string.invalidate_email);
            }
        });

        retrieveView(R.id.tv_login).setOnClickListener(v -> fragment.gotoLogin());

        int color;
        if (LevelUtil.level23()) {
            color = fragment.getResources().getColor(R.color.primary, null);
        } else {
            color = fragment.getResources().getColor(R.color.primary);
        }
        Spanny spanny = new Spanny(fragment.getString(R.string.agreement));
        spanny.findAndSpan(fragment.getString(R.string.service_agreement),
                () -> new ForegroundColorSpan(color));
        spanny.findAndSpan(fragment.getString(R.string.private_agreement),
                () -> new ForegroundColorSpan(color));
        agreement.setText(spanny);

        fragment.setTitle(R.string.register);
    }
}
