package com.pacific.lollipop.feature.boot;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.pacific.lollipop.R;
import com.pacific.lollipop.feature.auth.AuthActivity;
import com.pacific.lollipop.util.Cons;
import com.pacific.lollipop.util.PrefsUtil;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable.just(0)
                .subscribeOn(Schedulers.newThread())
                .map((anInt) -> {
                    fixEnv();
                    return sameVersion();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe((aBool) -> {
                    Intent in = new Intent();
                    in.setClass(SplashActivity.this, AuthActivity.class);
                    in.putExtra("Tutorial", !aBool);
                    startActivity(in);
                    finish();
                }, (e) -> alertExit());
    }

    private void fixEnv() {
        Context app = getApplication();
        if (!PrefsUtil.contains(app, Cons.VERSION)) {
            PrefsUtil.put(app, Cons.VERSION, "0.0.0");
        }
        if (!PrefsUtil.contains(app, Cons.USERNAME)) {
            PrefsUtil.put(app, Cons.USERNAME, "20161001");
        }
        if (!PrefsUtil.contains(app, Cons.PASSWORD)) {
            PrefsUtil.put(app, Cons.PASSWORD, "20161001");
        }
    }

    private boolean sameVersion() {
        Context app = getApplication();
        PackageManager pm = app.getPackageManager();
        try {
            String version = pm.getPackageInfo(app.getPackageName(), 0).versionName;
            String oldVersion = PrefsUtil.get(app, Cons.VERSION, version).toString();
            if (version.equals(oldVersion)) return true;
            PrefsUtil.put(app, Cons.VERSION, version);
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void headerLogin() {

    }

    private void alertExit() {
        new AlertDialog.Builder(SplashActivity.this)
                .setTitle(R.string.alert_exit_title)
                .setMessage(R.string.alert_exit_msg)
                .setCancelable(false)
                .setPositiveButton(R.string.alert_exit_positive, (dlg, anInt) -> finish())
                .setOnDismissListener((dlg) -> finish())
                .create()
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
