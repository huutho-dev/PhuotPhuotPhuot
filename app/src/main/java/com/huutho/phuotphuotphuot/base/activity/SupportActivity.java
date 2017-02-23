package com.huutho.phuotphuotphuot.base.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.huutho.phuotphuotphuot.base.ISupportFragment;


/**
 * Created by HuuTho on 1/17/2017.
 */
public class SupportActivity extends AppCompatActivity implements ISupportFragment {
    private final String TAG = SupportActivity.class.getSimpleName();
    private FragmentSupportManager mSupportFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSupportFragment = new FragmentSupportManager(this);
    }

    @Override
    public void replaceFragment(int layoutId, Fragment fragment) {
        mSupportFragment.replaceFragment(layoutId, fragment);
    }

    @Override
    public void replaceFragmentAddBackStack(int layoutId, Fragment fragment, boolean addToBackStack) {
        mSupportFragment.replaceFragmentAddBackStack(layoutId, fragment, addToBackStack);
    }

    @Override
    public void replaceFragmentAddNullBackStack(int layoutId, Fragment fragment) {
        mSupportFragment.replaceFragmentAddNullBackStack(layoutId, fragment);
    }

    @Override
    public void addFragment(int layoutId, Fragment fragment) {
        mSupportFragment.addFragment(layoutId, fragment);
    }

    @Override
    public void addFragmentAnim(int layoutId, Fragment fragment) {
        mSupportFragment.addFragmentAnim(layoutId,fragment);
    }

    @Override
    public void addFragmentAddBackStack(int layoutId, Fragment fragment, boolean addToBackStack) {
        mSupportFragment.replaceFragmentAddBackStack(layoutId, fragment, addToBackStack);
    }

    @Override
    public void addFragmentAddNullBackStack(int layoutId, Fragment fragment) {
        mSupportFragment.replaceFragmentAddNullBackStack(layoutId, fragment);
    }

    @Override
    public Fragment findFragmentByTag(String tag) {
        return mSupportFragment.findFragmentByTag(tag);
    }

    @Override
    public Fragment findFragmentById(int layoutId) {
        return mSupportFragment.findFragmentById(layoutId);
    }

}
