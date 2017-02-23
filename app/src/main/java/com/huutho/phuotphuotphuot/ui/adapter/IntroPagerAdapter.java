package com.huutho.phuotphuotphuot.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.huutho.phuotphuotphuot.ui.fragment.Intro1Fragment;
import com.huutho.phuotphuotphuot.ui.fragment.Intro2Fragment;
import com.huutho.phuotphuotphuot.ui.fragment.Intro3Fragment;
import com.huutho.phuotphuotphuot.ui.fragment.Intro4Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuuTho on 1/18/2017.
 */
public class IntroPagerAdapter extends FragmentPagerAdapter {
    private final String TAG = IntroPagerAdapter.class.getSimpleName();
    private List<Fragment> mListFragment;

    public IntroPagerAdapter(FragmentManager fm) {
        super(fm);
        mListFragment = new ArrayList<>();
        mListFragment.add(new Intro1Fragment());
        mListFragment.add(new Intro2Fragment());
        mListFragment.add(new Intro3Fragment());
        mListFragment.add(new Intro4Fragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
