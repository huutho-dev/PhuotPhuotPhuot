package com.huutho.phuotphuotphuot.base;

import android.support.v4.app.Fragment;

/**
 * Created by HuuTho on 1/17/2017.
 */

public interface ISupportFragment {
    void replaceFragment(int layoutId, Fragment fragment);

    void replaceFragmentAddBackStack(int layoutId, Fragment fragment, boolean addToBackStack);

    void replaceFragmentAddNullBackStack(int layoutId, Fragment fragment);

    void addFragment(int layoutId, Fragment fragment);

    void addFragmentAnim(int layoutId, Fragment fragment);

    void addFragmentAddBackStack(int layoutId, Fragment fragment, boolean addToBackStack);

    void addFragmentAddNullBackStack(int layoutId, Fragment fragment);

    Fragment findFragmentByTag(String tag);

    Fragment findFragmentById(int layoutId);

}
