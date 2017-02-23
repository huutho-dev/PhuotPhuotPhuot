package com.huutho.phuotphuotphuot.utils;

import android.util.Log;

import com.huutho.phuotphuotphuot.app.Config;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class LogUtils {
    private final String TAG = LogUtils.class.getSimpleName();

    public static void v(String tag, String msg) {
        if (Config.DEBUG) {
            Log.v("===> "+ tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (Config.DEBUG) {
            Log.i("===> "+tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (Config.DEBUG) {
            Log.d("===> "+tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (Config.DEBUG) {
            Log.e("===> "+tag, msg);
        }
    }
}
