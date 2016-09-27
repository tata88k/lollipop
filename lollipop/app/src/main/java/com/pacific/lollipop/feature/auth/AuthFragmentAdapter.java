package com.pacific.lollipop.feature.auth;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.pacific.adapter.FragmentPagerAdapter2;

/**
 * Created by root on 9/23/16.
 */

public class AuthFragmentAdapter extends FragmentPagerAdapter2 {

    public AuthFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return RegisterFragment.newInstance();
        }
        return LoginFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
