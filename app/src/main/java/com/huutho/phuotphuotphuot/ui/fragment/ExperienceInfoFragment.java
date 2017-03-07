package com.huutho.phuotphuotphuot.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.entity.ExperienceTravel;
import com.huutho.phuotphuotphuot.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 07/03/2017.
 */

public class ExperienceInfoFragment extends BaseFragment {

    private static final String EXTRA_EXP_FRAGMENT = "extra.exp.fragment";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fragment_info_exp_image)
    ImageView mInfoImage;
    @BindView(R.id.fragment_info_exp_title)
    TextView mInfoText;

    private ExperienceTravel mExp;


    public static ExperienceInfoFragment newInstance(ExperienceTravel exp) {

        Bundle args = new Bundle();
        args.putParcelable(EXTRA_EXP_FRAGMENT, exp);
        ExperienceInfoFragment fragment = new ExperienceInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ExperienceTravel getBundleData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return getArguments().getParcelable(EXTRA_EXP_FRAGMENT);
        }
        return savedInstanceState.getParcelable(EXTRA_EXP_FRAGMENT);
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_info_experience;
    }

    @Override
    public void bindViewToFragment(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        mExp = getBundleData(savedInstanceState);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle(mExp.mNameExp);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mActivity.onBackPressed();
            }
        });
    }

    @Override
    public void fragmentReady() {
        ImageUtils.loadImage(mContext, mExp.mImageExp, mInfoImage);
        mInfoText.setText(Html.fromHtml(mExp.mDescExp));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EXTRA_EXP_FRAGMENT, mExp);
    }

}
