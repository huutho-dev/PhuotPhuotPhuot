package com.huutho.phuotphuotphuot.widget.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by HuuTho on 2/20/2017.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mListFragment;
    private List<String> mListTitle;

    public TabPagerAdapter(FragmentManager fm, List<Fragment> listFragment, List<String> listTitle) {
        super(fm);
        this.mListFragment = listFragment;
        this.mListTitle = listTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }

}
