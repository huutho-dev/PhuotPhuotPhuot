package com.huutho.phuotphuotphuot.utils;

import com.huutho.phuotphuotphuot.app.Config;
import com.huutho.phuotphuotphuot.base.preferences.BasePreferences;

/**
 * Created by HuuTho on 1/18/2017.
 */
public class SharePreferencesUtils extends BasePreferences {

    private static final String KEY_FIRST_RUN_APP = "key.first.run.app";

    public static SharePreferencesUtils getInstances() {
        return new SharePreferencesUtils();
    }

    private SharePreferencesUtils(){
        super();
    }

    @Override
    public String getNamePreferences() {
        return Config.SHARE_PRERERENCES_NAME;
    }

    public void setFirstRunApp(boolean isFirst) {
        getEditor().putBoolean(KEY_FIRST_RUN_APP, isFirst).commit();
    }

    public boolean getFirstRunApp() {
      return getSharePreferences().getBoolean(KEY_FIRST_RUN_APP,true);
    }

}
