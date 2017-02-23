package com.huutho.phuotphuotphuot.base.activity;

import android.os.Bundle;
import android.os.Handler;

import com.huutho.phuotphuotphuot.utils.LogUtils;


/**
 * Created by HuuTho on 1/17/2017.
 */
public abstract class BaseActivity extends SupportActivity {
    private String TAG = BaseActivity.class.getSimpleName();

    public Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        TAG = this.getLocalClassName();
        super.onCreate(savedInstanceState);
        setContentView(setContentLayout());
        bindViewToLayout();
        activityReady();
        LogUtils.i(TAG, "onCreate");
    }

    public Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        return mHandler;
    }

    public abstract int setContentLayout();

    public abstract void bindViewToLayout();

    public abstract void activityReady();

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.gc();
        LogUtils.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtils.i(TAG, "onBackPress");
    }
}
