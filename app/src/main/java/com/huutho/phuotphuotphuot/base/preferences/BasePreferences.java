package com.huutho.phuotphuotphuot.base.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.huutho.phuotphuotphuot.app.AppController;

/**
 * Created by HuuTho on 1/18/2017.
 */
public abstract class BasePreferences {
    private Context mContext ;


    public  BasePreferences (){
        mContext = AppController.getInstance().getApplicationContext();
    }

    public SharedPreferences getSharePreferences(){
        return mContext.getSharedPreferences(getNamePreferences(),Context.MODE_PRIVATE);
    }
    public SharedPreferences.Editor getEditor(){
        return getSharePreferences().edit();
    }

    public abstract String getNamePreferences();
}
