package com.huutho.phuotphuotphuot.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.entity.ImagePlace;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.utils.ImageUtils;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;
import com.huutho.phuotphuotphuot.utils.database.TableImagePlace;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by HuuTho on 2/15/2017.
 */

public class PlaceDetailIntroFragment extends BaseFragment implements ViewPager.OnPageChangeListener{
    private static final String BUNDLE_KEY_DETAIL_INTRO = "bundle.key.detail.intro";
    private static final int TIME_TO_NEXT = 3500;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.fragment_place_detail_intro_toolbar)
    Toolbar mToobar;
    @BindView(R.id.fragment_place_detail_intro_view_pager)
    ViewPager mViewpage;
    @BindView(R.id.indicator)
    CircleIndicator mIndicator;
    @BindView(R.id.fragment_place_detail_intro_tv_intro)
    TextView mTextIntro;


    private List<ImagePlace> mListImage;
    private IntroDetailPagerAdapter mPagerAdapter;
    private Place mPlace;
    int mCurrentPage;
    int mSizeImage;

    private Runnable autoNextImage = new Runnable() {
        @Override
        public void run() {
            if (mCurrentPage == mSizeImage - 1) {
                mCurrentPage = 0;
            } else {
                mCurrentPage++;
            }
            mViewpage.setCurrentItem(mCurrentPage);
            mHandle.postDelayed(this, TIME_TO_NEXT);
        }
    };

    public static PlaceDetailIntroFragment newInstance(Place place) {
        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_KEY_DETAIL_INTRO, place);
        PlaceDetailIntroFragment fragment = new PlaceDetailIntroFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPlace = getBundleData(this.getArguments());
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_intro;
    }

    @Override
    public void bindViewToFragment(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        initToolbar();
        this.mListImage = TableImagePlace
                .getInstance()
                .getListData(
                        DbContracts.TableImagePlace.IMAGE_PLACE_ID_PLACE,
                        new String[]{mPlace.mIdPlace}, null);
        this.mPagerAdapter = new IntroDetailPagerAdapter(mContext, mListImage);
        this.mSizeImage = mListImage.size();
        this.mViewpage.setAdapter(mPagerAdapter);
        this.mViewpage.addOnPageChangeListener(this);
        this.mIndicator.setViewPager(mViewpage);
        this.mHandle.postDelayed(autoNextImage, TIME_TO_NEXT);
    }

    private void initToolbar() {
        mCollapsingToolbar.setTitle(mPlace.mNamePlace);
        mCollapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorTransparent));
        mCollapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
    }

    private Place getBundleData(Bundle saveInstance) {
        return (Place) saveInstance.getParcelable(BUNDLE_KEY_DETAIL_INTRO);
    }

    @Override
    public void fragmentReady() {
        mTextIntro.setText(Html.fromHtml(mPlace.mIntro));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mCurrentPage = position;
        mHandle.removeCallbacks(autoNextImage);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class IntroDetailPagerAdapter extends PagerAdapter {
        private Context mContext;
        private List<ImagePlace> datas;

        public IntroDetailPagerAdapter(Context context, List<ImagePlace> datas) {
            this.mContext = context;
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_image_detail, container, false);
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_detail);
            ImageUtils.loadImage(mContext, datas.get(position).getmLinkImage(), imageView, progressBar);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (RelativeLayout) object;
        }
    }
}
