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

import com.huutho.phuotphuotphuot.utils.LogUtils;

/**
 * Created by HuuTho on 1/17/2017.
 */
public abstract class BaseFragment extends Fragment {
    private String TAG = BaseFragment.class.getSimpleName();
    ;
    public Handler mHandle;
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
        LogUtils.v("huutho","onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.v("huutho","onResume");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setContentLayout(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViewToFragment(view,savedInstanceState);
        fragmentReady();
    }

    public abstract int setContentLayout();

    public abstract void bindViewToFragment(View view, Bundle savedInstanceState);

    public abstract void fragmentReady();

    public Handler getHandle(){
        return mHandle;
    }
}
