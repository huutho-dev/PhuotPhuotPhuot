package com.huutho.phuotphuotphuot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.app.Config;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.ui.adapter.IntroPagerAdapter;
import com.huutho.phuotphuotphuot.utils.FileUtils;
import com.huutho.phuotphuotphuot.utils.LogUtils;
import com.huutho.phuotphuotphuot.utils.SharePreferencesUtils;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.act_intro_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.act_intro_btn_next)
    Button mButtonNext;
    @BindView(R.id.act_intro_btn_previos)
    Button mButtomPrevious;
    @BindView(R.id.act_intro_dot_1)
    ImageView mDot1;
    @BindView(R.id.act_intro_dot_2)
    ImageView mDot2;
    @BindView(R.id.act_intro_dot_3)
    ImageView mDot3;
    @BindView(R.id.act_intro_dot_4)
    ImageView mDot4;

    private ArrayList<ImageView> mListDot;
    private Animation mZoomOut, mZoomIn;

    private IntroPagerAdapter mAdapter;
    int mLastPositionPage = 0;
    int currentPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


        // lấy biến kiểm tra xem có phải lần đầu run app không
        boolean isFirstLoad = SharePreferencesUtils.getInstances().getFirstRunApp();
        if (isFirstLoad) {
            SharePreferencesUtils.getInstances().setFirstRunApp(false);
            FileUtils.copyDatabase(Config.PATH_DB);
        } else {
            startActivity(new Intent(IntroActivity.this, HomeActivity.class));
            finish();
        }
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_intro;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);
        mButtonNext.setOnClickListener(this);
        mButtomPrevious.setOnClickListener(this);
        mButtomPrevious.setVisibility(View.INVISIBLE);

        mListDot = new ArrayList<>();
        mListDot.add(mDot1);
        mListDot.add(mDot2);
        mListDot.add(mDot3);
        mListDot.add(mDot4);

        mZoomIn = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_in);
        mZoomOut = AnimationUtils.loadAnimation(this, R.anim.anim_zoom_out);
    }

    @Override
    public void activityReady() {
        mAdapter = new IntroPagerAdapter(this.getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(onPageChangeListener);

        setAnimDots(0, 0);
        mDot1.setSelected(true);
    }

    /**
     * Activity click event
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        currentPosition = mViewPager.getCurrentItem();
        switch (v.getId()) {
            case R.id.act_intro_btn_next:
                if (currentPosition == 3) {
                    startActivity(new Intent(IntroActivity.this, HomeActivity.class));
                } else {
                    mLastPositionPage = currentPosition;
                    currentPosition++;
                    mViewPager.setCurrentItem(currentPosition);
                    setAnimDots(currentPosition, mLastPositionPage);
                }

                break;
            case R.id.act_intro_btn_previos:
                mLastPositionPage = currentPosition;
                currentPosition--;
                mViewPager.setCurrentItem(currentPosition);
                setAnimDots(currentPosition, mLastPositionPage);
                break;
        }
    }

    /**
     * ViewPager Event PagerChangedListener
     */

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            LogUtils.v("huutho", position + "");
        }

        @Override
        public void onPageSelected(int position) {


            if (position == 3) {
                mButtonNext.setText("Let's start");
                mButtomPrevious.setVisibility(View.INVISIBLE);
            } else if (position == 0) {
                mButtomPrevious.setVisibility(View.INVISIBLE);
            } else {
                mButtonNext.setText("Next");
                if (mButtomPrevious.getVisibility() == View.INVISIBLE)
                    mButtomPrevious.setVisibility(View.VISIBLE);
            }
            currentPosition = position;
            int totalPage = 4;
            for (int i = 0; i < totalPage; i++) {
                if (i == position) {
                    setAnimDots(i, mLastPositionPage);
                    mListDot.get(i).setSelected(true);
                } else {
                    mListDot.get(i).setSelected(false);
                    mListDot.get(i).clearAnimation();
                }
            }
            mLastPositionPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private void setAnimDots(int currentPosition, int lastPosition) {
        mListDot.get(lastPosition).startAnimation(mZoomOut);
        mListDot.get(currentPosition).startAnimation(mZoomIn);
    }
}
