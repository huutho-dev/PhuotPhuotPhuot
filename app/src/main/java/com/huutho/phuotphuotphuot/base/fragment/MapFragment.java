package com.huutho.phuotphuotphuot.base.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;

import com.huutho.phuotphuotphuot.app.retrofit.ApiRequest;
import com.huutho.phuotphuotphuot.app.retrofit.ApiRequestHelper;
import com.huutho.phuotphuotphuot.app.retrofit.LocationEntity;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.utils.LogUtils;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HuuTho on 2/26/2017.
 */

public abstract class MapFragment extends BaseFragment {
    private String mLocationChanged;

    @Override
    public int setContentLayout() {
        return 0;
    }

    @Override
    public void bindViewToFragment() {

    }

    @Override
    public void fragmentReady() {

    }

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(mActivity).registerReceiver(onLocationReceiver, new IntentFilter("onLocationChanged"));
    }

    @Override
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(mActivity).unregisterReceiver(onLocationReceiver);
    }

    public abstract void onLocationChange(String location);

    private BroadcastReceiver onLocationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mLocationChanged = intent.getStringExtra("onLocationChanged");
            onLocationChange(mLocationChanged);
        }
    };
}
