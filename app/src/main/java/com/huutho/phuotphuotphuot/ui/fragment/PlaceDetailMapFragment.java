package com.huutho.phuotphuotphuot.ui.fragment;

import android.os.Bundle;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.entity.Place;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailMapFragment  extends BaseFragment{

    public static PlaceDetailMapFragment newInstance(Place place) {

        Bundle args = new Bundle();

        PlaceDetailMapFragment fragment = new PlaceDetailMapFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_map;
    }

    @Override
    public void bindViewToFragment() {

    }

    @Override
    public void fragmentReady() {

    }
}
