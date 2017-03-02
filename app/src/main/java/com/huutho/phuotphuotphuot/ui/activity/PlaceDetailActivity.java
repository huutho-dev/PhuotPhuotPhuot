package com.huutho.phuotphuotphuot.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.app.AppController;
import com.huutho.phuotphuotphuot.app.retrofit.ApiRequest;
import com.huutho.phuotphuotphuot.app.retrofit.ApiRequestHelper;
import com.huutho.phuotphuotphuot.app.retrofit.LocationEntity;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.location.LocationService;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailFoodFragment;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailIntroFragment;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailMapFragment;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailMotelFragment;
import com.huutho.phuotphuotphuot.utils.LogUtils;
import com.huutho.phuotphuotphuot.widget.tab.TabBuilder;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by HuuTho on 2/14/2017.
 */

public class PlaceDetailActivity extends BaseActivity {
    private static final int REQUEST_PERMISSION = 111;
    public static final String KEY_DATA = "key.data";

    @BindView(R.id.atc_place_detail_pager_tab)
    ViewPager mViewPager;
    @BindView(R.id.act_place_detail_tablayout)
    TabLayout mTabLayout;

    private Place mPlace;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPlace = getBundleData();
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_place_detail;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);
        initTabAndViewPager(mTabLayout, mViewPager);

    }

    @Override
    public void activityReady() {
        startService(new Intent(this, LocationService.class));
        if (!hasPermisstionLocation()){
            requestPermisstion();;
        }
    }


    private Place getBundleData() {
        Intent intent = getIntent();
        return (Place) intent.getParcelableExtra(PlaceDetailActivity.KEY_DATA);
    }

    private void initTabAndViewPager(TabLayout tabLayout, ViewPager viewPager) {
        TabBuilder tabBuilder = new TabBuilder(this, tabLayout, viewPager)
        .setFragment(PlaceDetailIntroFragment.newInstance(mPlace),
                PlaceDetailMapFragment.newInstance(mPlace),
                PlaceDetailFoodFragment.newInstance(mPlace),
                PlaceDetailMotelFragment.newInstance(mPlace))
        .setTitle("Intro", "Map", "Food", "Motel");
        tabBuilder.build();
    }

    private boolean hasPermisstionLocation() {
        boolean accessCoarseLocationGranted = ContextCompat.checkSelfPermission(
                AppController.getInstance().getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean accessFineLocationGranted = ContextCompat.checkSelfPermission(
                AppController.getInstance().getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        return accessCoarseLocationGranted || accessFineLocationGranted;

    }

    private void requestPermisstion() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)
                    && shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("Need permisstion for Map");
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestPermissions(new String[]{
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                        Manifest.permission.ACCESS_FINE_LOCATION},
                                REQUEST_PERMISSION);
                    }
                }).show();
            } else {
                requestPermissions(new String[]{
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_PERMISSION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length != -1 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                //TODO
                LogUtils.e("Permission","Granted");
            }
        }
    }

}
