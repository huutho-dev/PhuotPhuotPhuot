package com.huutho.phuotphuotphuot.app;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
/**
 * Created by HuuTho on 1/17/2017.
 */
public class AppController extends Application {
    private static AppController ourInstance ;
    public static int WIDTH_SCREEN;
    public static int HEIGHT_SCREEN;

    public static synchronized AppController getInstance() {
        if (ourInstance == null)
            ourInstance = new AppController();
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        ourInstance = this;
        getDimenScreen();
    }

    private void getDimenScreen() {
        WindowManager wm = (WindowManager) this.getSystemService(WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        HEIGHT_SCREEN = dm.heightPixels;
        WIDTH_SCREEN = dm.widthPixels;
    }
}
