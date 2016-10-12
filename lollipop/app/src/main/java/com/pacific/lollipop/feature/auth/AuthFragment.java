package com.pacific.lollipop.feature.auth;

import android.content.Context;
import android.support.annotation.StringRes;

import com.pacific.mvc.Fragment;
import com.pacific.mvc.FragmentModel;

abstract class AuthFragment<T extends FragmentModel> extends Fragment<T> {
    public interface Action {
        void snack(@StringRes int resId);

        void dismissSnack();

        void setTitle(@StringRes int resId); 
    }

    protected Action action;
    public static int pageIndex = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Action) {
            action = (Action) context;
        } else {
            throw new RuntimeException(context.toString() + " must AuthFragment.Action");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        action = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissSnack();
    }

    public void snack(int resIs) {
        action.snack(resIs);
    }

    public void dismissSnack() {
        action.dismissSnack();
    }

    public void setTitle(@StringRes int resId) {
        action.setTitle(resId);
    }
}
