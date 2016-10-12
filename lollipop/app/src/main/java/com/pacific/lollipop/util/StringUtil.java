package com.pacific.lollipop.util;

import android.text.TextUtils;

public class StringUtil {

    public static boolean isEmailValid(String str) {
        if (!TextUtils.isEmpty(str) && (str.contains("@") || str.length() == 11)) return true;
        return false;
    }

    public static boolean isPasswordValid(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 6) return true;
        return false;
    }
}
