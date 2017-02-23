package com.huutho.phuotphuotphuot.ui.fragment;

import android.os.Bundle;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.entity.Place;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailMotelFragment extends BaseFragment {
    public static PlaceDetailMotelFragment newInstance(Place place) {

        Bundle args = new Bundle();

        PlaceDetailMotelFragment fragment = new PlaceDetailMotelFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_motel;
    }

    @Override
    public void bindViewToFragment() {

    }

    @Override
    public void fragmentReady() {

    }
}
