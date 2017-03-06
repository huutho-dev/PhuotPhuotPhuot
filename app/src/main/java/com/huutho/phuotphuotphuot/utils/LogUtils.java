package com.huutho.phuotphuotphuot.utils;

import android.util.Log;

import com.huutho.phuotphuotphuot.app.Config;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class LogUtils {
    private final static String TAG = "[ --> HuuTho <--]";

    public static void v(String tag, String msg) {
        if (Config.DEBUG) {
            Log.v("===> " + tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (Config.DEBUG) {
            Log.i("===> " + tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (Config.DEBUG) {
            Log.d("===> " + tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (Config.DEBUG) {
            Log.e("===> " + tag, msg);
        }
    }

    public static void showLog(String msg) {
        if (Config.DEBUG) {
            StackTraceElement element = new Exception().getStackTrace()[1];
            StringBuilder builder = new StringBuilder();
            builder.append("-------------------------------------------------------------------------------------");
            builder.append(element.getClassName())
                    .append(element.getMethodName())
                    .append(element.getLineNumber());
            builder.append(msg);
            builder.append("-------------------------------------------------------------------------------------");
            LogUtils.e(TAG, builder.toString());
        }
    }
}
