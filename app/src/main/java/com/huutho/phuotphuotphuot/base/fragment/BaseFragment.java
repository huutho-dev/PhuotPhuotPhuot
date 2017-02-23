package com.huutho.phuotphuotphuot.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HuuTho on 1/17/2017.
 */
public abstract class BaseFragment extends Fragment {
    private String TAG = BaseFragment.class.getSimpleName();
    public Handler mHandle ;
    public Activity mActivity;
    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        mActivity = getActivity();
        mHandle = new Handler();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setContentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViewToFragment();
        fragmentReady();
    }

    public abstract int setContentLayout();

    public abstract void bindViewToFragment();

    public abstract void fragmentReady();
}
