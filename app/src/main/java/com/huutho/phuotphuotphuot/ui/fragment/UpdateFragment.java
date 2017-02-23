package com.huutho.phuotphuotphuot.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.widget.ToobarBackButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 1/21/2017.
 */
public class UpdateFragment extends BaseFragment{
    private final String TAG = UpdateFragment.class.getSimpleName();

    @BindView(R.id.fragment_update_toobar_back_button)
    ToobarBackButton mToolbar ;
    @BindView(R.id.fragment_update_loading)
    ProgressBar mLoading;
    @BindView(R.id.fragment_update_title)
    TextView mTitle ;

    @Override
    public int setContentLayout() {
        return R.layout.fragment_update;
    }

    @Override
    public void bindViewToFragment() {
        ButterKnife.bind(this,getView());
        mToolbar.setTitle("Update");
        mToolbar.setTitleTextColor(ContextCompat.getColor(mContext, R.color.white));
    }

    @Override
    public void fragmentReady() {
        mHandle.postDelayed(loadUpdate,2000);
    }

    private Runnable loadUpdate = new Runnable() {
        @Override
        public void run() {
            mTitle.setText("Phiên bản hiện tại là bản mới nhất");
            mLoading.setVisibility(View.INVISIBLE);
        }
    };
}
