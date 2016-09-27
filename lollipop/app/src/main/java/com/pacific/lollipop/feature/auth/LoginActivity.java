package com.pacific.lollipop.feature.auth;

import android.content.Intent;
import android.os.Bundle;

import com.pacific.lollipop.R;
import com.pacific.lollipop.feature.boot.TutorialActivity;
import com.pacific.mvc.Activity;

public class LoginActivity extends Activity<LoginModel> implements LoginFragment.Action {

    private final int REQUEST_CODE_TUTORIAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        model = new LoginModel(new LoginView(this));
        model.onCreate();
        boolean isTutorial = getIntent().getBooleanExtra("Tutorial", false);
        if (isTutorial) {
            Intent intent = new Intent(this, TutorialActivity.class);
            startActivityForResult(intent, REQUEST_CODE_TUTORIAL);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TUTORIAL) {
            if (resultCode == RESULT_OK) {
            } else {
            }
        }
    }
}
