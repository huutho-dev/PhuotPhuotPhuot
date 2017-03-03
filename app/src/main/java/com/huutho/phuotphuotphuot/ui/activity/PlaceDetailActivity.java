package com.huutho.phuotphuotphuot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.location.LocationService;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailFoodFragment;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailIntroFragment;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailMapFragment;
import com.huutho.phuotphuotphuot.ui.fragment.PlaceDetailMotelFragment;
import com.huutho.phuotphuotphuot.widget.tab.TabBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

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

}
