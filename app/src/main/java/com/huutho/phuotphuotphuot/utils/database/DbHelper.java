package com.huutho.phuotphuotphuot.utils.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.huutho.phuotphuotphuot.app.AppController;
import com.huutho.phuotphuotphuot.app.Config;
import com.huutho.phuotphuotphuot.utils.FileUtils;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class DbHelper {

    public SQLiteDatabase mSqlDatabase;
    public DbHelper() {
        if (!FileUtils.fileExist(Config.PATH_DB)) {
            FileUtils.copyDatabase(Config.PATH_DB);
        }
    }

    public void openDb() {
        mSqlDatabase = AppController
                .getInstance()
                .openOrCreateDatabase(Config.PATH_DB, Context.MODE_APPEND, null);
    }

    public void closeDb() {
        mSqlDatabase.close();
    }

}
