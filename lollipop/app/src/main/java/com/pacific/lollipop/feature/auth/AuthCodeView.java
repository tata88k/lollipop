package com.pacific.lollipop.feature.auth;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.binaryfork.spanny.Spanny;
import com.pacific.lollipop.R;
import com.pacific.lollipop.util.LevelUtil;
import com.pacific.mvc.FragmentView;

public class AuthCodeView extends FragmentView<AuthCodeFragment> implements View.OnClickListener {
    private TextView agreement;
    private AutoCompleteTextView email;
    private EditText code;
    private Snackbar snackbar;

    public AuthCodeView(AuthCodeFragment fragment) {
        super(fragment);
    }

    @Override
    protected void initialize(Object... args) {
        agreement = retrieveView(R.id.tv_agreement);
        email = retrieveView(R.id.ac_email);
        code = retrieveView(R.id.edit_code);

        retrieveView(R.id.img_clear).setOnClickListener(this);
        retrieveView(R.id.btn_get_code).setOnClickListener(this);
        retrieveView(R.id.tv_login).setOnClickListener(this);
        retrieveView(R.id.btn_next).setOnClickListener(this);
        retrieveView(R.id.img_chat).setOnClickListener(this);
        retrieveView(R.id.img_qq).setOnClickListener(this);
        retrieveView(R.id.img_note).setOnClickListener(this);
        retrieveView(R.id.img_pocket).setOnClickListener(this);
        retrieveView(R.id.img_sin).setOnClickListener(this);
        retrieveView(R.id.img_twitter).setOnClickListener(this);

        int color;
        if (LevelUtil.level23()) {
            color = fragment.getResources().getColor(R.color.primary, null);
        } else {
            color = fragment.getResources().getColor(R.color.primary);
        }
        Spanny spanny = new Spanny(fragment.getString(R.string.agreement));
        spanny.findAndSpan(fragment.getString(R.string.agreement1),
                () -> new ForegroundColorSpan(color));
        spanny.findAndSpan(fragment.getString(R.string.agreement2),
                () -> new ForegroundColorSpan(color));
        agreement.setText(spanny);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_chat:
                break;
            case R.id.img_qq:
                break;
            case R.id.img_note:
                break;
            case R.id.img_pocket:
                break;
            case R.id.img_sin:
                break;
            case R.id.img_twitter:
                break;
            case R.id.img_clear:
                code.setText(null);
                break;
            case R.id.btn_get_code:
                String str = email.getText().toString();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (isEmailOrPhone(str)) fragment.fetchAuthCode(str);
                break;
            case R.id.tv_login:
                break;
            default:
                break;
        }
    }

    private boolean isEmailOrPhone(String str) {
        snack(R.string.invalidate_email);
        return false;
    }

    public void snack(int resIs) {
        if (snackbar != null && snackbar.isShown()) snackbar.dismiss();
        snackbar = Snackbar.make(code, resIs, Snackbar.LENGTH_SHORT).setAction(R.string.snack_close, (v) -> snackbar.dismiss());
        snackbar.show();
    }
}
