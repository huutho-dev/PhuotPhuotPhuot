package com.huutho.phuotphuotphuot.base.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.huutho.phuotphuotphuot.R;

/**
 * Created by HuuTho on 1/17/2017.
 */
public class FragmentSupportManager {
    private final String TAG = FragmentSupportManager.class.getSimpleName();
    private AppCompatActivity mActivity;

    public FragmentSupportManager(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    public void replaceFragment(int layoutId, Fragment fragment) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(fragment.getTag());
        ft.setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit, R.anim.fragment_enter, R.anim.fragment_exit);
        ft.replace(layoutId, fragment);
        ft.commit();
    }

    public void replaceFragmentAddBackStack(int layoutId, Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        boolean poped = fm.popBackStackImmediate(fragment.getTag(), 0);

    }

    public void replaceFragmentAddNullBackStack(int layoutId, Fragment fragment) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
    }

    public void addFragment(int layoutId, Fragment fragment) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(fragment.getTag());
        ft.add(layoutId, fragment);
        ft.commit();
    }

    public void addFragmentAnim(int layoutId, Fragment fragment) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit, R.anim.fragment_enter, R.anim.fragment_exit);
        ft.add(layoutId, fragment);
        ft.addToBackStack(fragment.getTag());
        ft.commit();
    }

    public void addFragmentAddBackStack(int layoutId, Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
    }

    public void addFragmentAddNullBackStack(int layoutId, Fragment fragment) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
    }

    public Fragment findFragmentByTag(String tag) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        return fm.findFragmentByTag(tag);
    }

    public Fragment findFragmentById(int layoutId) {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        return fm.findFragmentById(layoutId);
    }

    public void popFragment() {
        FragmentManager fm = mActivity.getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        if (count >= 1) {
            fm.popBackStackImmediate();
        }
    }
}
