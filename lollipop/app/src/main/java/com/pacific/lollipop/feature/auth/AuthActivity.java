package com.pacific.lollipop.feature.auth;

import android.content.Intent;
import android.os.Bundle;

import com.pacific.lollipop.R;
import com.pacific.lollipop.feature.boot.TutorialActivity;
import com.pacific.mvc.Activity;

public class AuthActivity extends Activity<AuthModel> implements LoginFragment.Action {

    private final int REQUEST_CODE_TUTORIAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        model = new AuthModel(new AuthView(this));
        model.onCreate();
        if (getIntent().getBooleanExtra("Tutorial", false)) {
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
