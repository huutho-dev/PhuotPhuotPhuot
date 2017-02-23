package com.huutho.phuotphuotphuot.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.widget.ToobarBackButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nguyenhuutho on 2/1/17.
 */

public class InformationFragment extends BaseFragment {

    @BindView(R.id.fragment_information_toobar_back_button)
    ToobarBackButton mToobar;
    @BindView(R.id.fragment_information_txt_info)
    AppCompatTextView mTextInformation;

    @Override
    public int setContentLayout() {
        return R.layout.fragment_information;
    }

    @Override
    public void bindViewToFragment() {
        ButterKnife.bind(this, getView());
        mToobar.setTitle("Information");
        mToobar.setTitleTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTextInformation.setText("Hihi đồ ngốc");
    }

    @Override
    public void fragmentReady() {

    }
}
