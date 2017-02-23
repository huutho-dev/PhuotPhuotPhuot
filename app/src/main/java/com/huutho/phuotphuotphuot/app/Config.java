package com.huutho.phuotphuotphuot.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class Config {
    public static final boolean DEBUG = true;
    public static final String PATH_DB = Environment.getDataDirectory().getPath()
            + "/data/com.huutho.phuotphuotphuot/database/PhuotVietNam.sqlite";

    public static final String SHARE_PRERERENCES_NAME = "PhuotSharePreferences";
}
