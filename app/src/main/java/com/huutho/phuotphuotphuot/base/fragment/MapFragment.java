package com.huutho.phuotphuotphuot.base.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

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
    public abstract void bindViewToFragment(View view, Bundle saveInstance);

    @Override
    public abstract void fragmentReady() ;

    @Override
    public void onResume() {
        LocalBroadcastManager.getInstance(mActivity).registerReceiver(onLocationReceiver, new IntentFilter("onLocationChanged"));
        super.onResume();
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
