package com.huutho.phuotphuotphuot.ui.fragment.detail;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.ui.entity.Food;
import com.huutho.phuotphuotphuot.ui.entity.PlaceRested;
import com.huutho.phuotphuotphuot.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 3/4/2017.
 */

public class FoodAndMotelDetail extends BaseActivity implements View.OnClickListener {
    public static final String EXTRA_DETAIL_FRAGMENT = "extra.detail.fragment";
    public static final String GOOGLE_URL = "https://www.google.com.vn/search?q=";
    public static final String GOOGLE_IMAGE_ENDPOINT = "&biw=1366&bih=672&source=lnms&tbm=isch&sa=X&sqi=2&ved=0ahUKEwi8udXXr73SAhXKHpQKHbK7CwYQ_AUIBigB";
    // common
    @BindView(R.id.toobar)
    Toolbar mToolbar;
    @Nullable
    @BindView(R.id.food_detail)
    RelativeLayout mFoodLayout;
    @Nullable
    @BindView(R.id.motel_detail)
    RelativeLayout mMotelLayout;
    @Nullable
    // common
    @BindView(R.id.image_detail)
    ImageView mImageDetail;
    @Nullable
    @BindView(R.id.txt_detail)
    TextView mIntroDetail;
    @Nullable

    // motel
    @BindView(R.id.btn_view_more)
    Button mViewMore;
    @Nullable
    @BindView(R.id.txt_motel_price)
    TextView mMotelPrice;
    @Nullable
    @BindView(R.id.txt_motel_phone)
    TextView mMotelPhone;

    //Food
    @BindView(R.id.webview)
    WebView mViewMoreFood;

    private String mImgUrl;
    private String mIntro;
    private String mName;
    private String mPrice;
    private String mPhone;
    private BaseEntity mEntity;


    private BaseEntity getBundleData() {
        Intent intent = getIntent();
        return intent.getParcelableExtra(EXTRA_DETAIL_FRAGMENT);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_food_and_motel_detail;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);

        mEntity = getBundleData();
        if (mEntity instanceof Food) {

            mMotelLayout.setVisibility(View.GONE);
            mFoodLayout.setVisibility(View.VISIBLE);

            mImgUrl = ((Food) mEntity).mImageFood;
            mIntro = ((Food) mEntity).mIntroFood;
            mName = ((Food) mEntity).mNameFood;
            mViewMore.setOnClickListener(this);


        } else if (mEntity instanceof PlaceRested) {
            mMotelLayout.setVisibility(View.VISIBLE);
            mFoodLayout.setVisibility(View.GONE);

            mImgUrl = ((PlaceRested) mEntity).mImagePlaceRested;
            mIntro = ((PlaceRested) mEntity).mIntroPlaceRested;
            mName = ((PlaceRested) mEntity).mNamePlaceRested;

            mPrice = ((PlaceRested) mEntity).mPrice;
            mPhone = ((PlaceRested) mEntity).mPhoneNumberPlace;

            mMotelPrice.setText("Giá : " + mPrice);
            mMotelPhone.setText("SĐT : " + mPhone);
        }


    }

    @Override
    public void activityReady() {

        ImageUtils.loadImage(this, mImgUrl, mImageDetail);
        mIntroDetail.setText(Html.fromHtml(mIntro));

        mToolbar.setTitle(mName);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_more:
                mViewMoreFood.setWebViewClient(new WebViewClient());
                mViewMoreFood.getSettings().setLoadsImagesAutomatically(true);
                mViewMoreFood.getSettings().setDomStorageEnabled(true);
                mViewMoreFood.getSettings().setBuiltInZoomControls(true);
                mViewMoreFood.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                mViewMoreFood.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
                mViewMoreFood.clearCache(true);

                mViewMoreFood.loadUrl(GOOGLE_URL + mName+GOOGLE_IMAGE_ENDPOINT);
                break;
        }
    }
}
