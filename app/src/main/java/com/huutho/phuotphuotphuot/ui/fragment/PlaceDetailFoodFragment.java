package com.huutho.phuotphuotphuot.ui.fragment;

import android.os.Bundle;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.entity.Place;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailFoodFragment extends BaseFragment {

    public static PlaceDetailFoodFragment newInstance(Place place) {

        Bundle args = new Bundle();

        PlaceDetailFoodFragment fragment = new PlaceDetailFoodFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_food;
    }

    @Override
    public void bindViewToFragment() {

    }

    @Override
    public void fragmentReady() {

    }
}
