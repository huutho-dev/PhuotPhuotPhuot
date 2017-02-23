package com.huutho.phuotphuotphuot.widget.tab;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by HuuTho on 2/19/2017.
 */

public class TabBuilder {
    private FragmentActivity mContext;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabPagerAdapter mPagerAdapter;
    private List<Fragment> mListFragment;
    private List<String> mListTitle;

    public TabBuilder(Fragment fragment, TabLayout tabLayout, ViewPager viewPager) {
        this.mContext = fragment.getActivity();
        this.mViewPager = viewPager;
        this.mTabLayout = tabLayout;
        this.mListFragment = new ArrayList<>();
        this.mListTitle = new ArrayList<>();
    }

    public TabBuilder(AppCompatActivity activity, TabLayout tabLayout, ViewPager viewPager) {
        this.mContext = activity;
        this.mViewPager = viewPager;
        this.mTabLayout = tabLayout;
        this.mListFragment = new ArrayList<>();
        this.mListTitle = new ArrayList<>();
    }

    public TabBuilder setFragment(Fragment... fragments) {
        mListFragment.clear();
        Collections.addAll(mListFragment, fragments);
        return this;
    }

    public TabBuilder setTitle(String... titles) {
        mListTitle.clear();
        Collections.addAll(mListTitle, titles);
        return this;
    }

    public TabBuilder setIcon(int... icon) {
        int tabCount = mTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            mTabLayout.getTabAt(i).setIcon(icon[i]);
        }
        return this;
    }

    public TabBuilder setIcon(Drawable... icon) {
        int tabCount = mTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            mTabLayout.getTabAt(i).setIcon(icon[i]);
        }
        return this;
    }

    public TabBuilder setCustomTab(int layoutId, int idTitle, int idIcon, String[] title, int[] icon) {
        int tabCount = mTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {

            View tabView = LayoutInflater.from(mContext).inflate(layoutId, null);
            ((TextView) tabView.findViewById(idTitle)).setText(title[i]);
            ((ImageView) tabView.findViewById(idIcon)).setImageResource(icon[i]);
            mTabLayout.getTabAt(i).setCustomView(tabView);
        }
        return this;
    }

    public void build() {
        mPagerAdapter = new TabPagerAdapter(mContext.getSupportFragmentManager(),
                mListFragment, mListTitle);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.addOnTabSelectedListener(tabSelectedListener);
        mViewPager.addOnPageChangeListener(pageChangeListener);
    }


    public int getCurrentTab() {
        return mViewPager.getCurrentItem();
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

}
