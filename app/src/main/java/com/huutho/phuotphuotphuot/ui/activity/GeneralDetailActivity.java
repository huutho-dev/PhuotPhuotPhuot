package com.huutho.phuotphuotphuot.ui.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.app.AppController;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.ui.entity.Food;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.ui.entity.PlaceRested;
import com.huutho.phuotphuotphuot.utils.LogUtils;
import com.huutho.phuotphuotphuot.utils.MapUtils;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;
import com.huutho.phuotphuotphuot.utils.database.TableFood;
import com.huutho.phuotphuotphuot.utils.database.TableRested;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 3/5/2017.
 */

public class GeneralDetailActivity extends BaseActivity implements OnMapReadyCallback {
    private static final String EXTRA_GENERAL_ACTIVITY = "extra.general.activity";

    private Place mPlace;
    private ArrayList<PlaceRested> mResteds;

    private GoogleMap mMap;

    public static void newInstance(AppCompatActivity activity, Place place) {
        Intent intent = new Intent(activity, GeneralDetailActivity.class);
        intent.putExtra(EXTRA_GENERAL_ACTIVITY, place);
        activity.startActivity(intent);
    }

    private Place getBundleData(Bundle savedInstanceState) {
        return getIntent().getParcelableExtra(EXTRA_GENERAL_ACTIVITY);
    }

    private Runnable runFirstLoad = new Runnable() {
        @Override
        public void run() {
            initDataForMap(mPlace);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlace = getBundleData(savedInstanceState);

        mResteds = new ArrayList<>();
        getHandler().post(runFirstLoad);
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_general_detail;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void activityReady() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
        finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        getHandler().post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mResteds.size(); i++){
                    MapUtils.addMarker(GeneralDetailActivity.this, mMap, mResteds.get(i).mLatLng, mResteds.get(i).mNamePlaceRested, R.drawable.ic_motel);
                }
            }
        });


        MapUtils.addMarker(this, mMap, mPlace.mLatLng, mPlace.mNamePlace, R.drawable.ic_marker_red);


        mMap.animateCamera(MapUtils.setCameraUpdate(mPlace.mLatLng));
    }

    private void initDataForMap(Place place) {
        String restedSelection = DbContracts.TableRested.RESTED_ID_PLACE;
        String[] args = new String[]{place.mIdPlace};
        mResteds = TableRested.getInstance().getListData(restedSelection, args, null);
        LogUtils.e("huutho","size : " + mResteds.size() + mResteds.get(0).mLatLng);
    }
}
