package com.huutho.phuotphuotphuot.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.widget.ToobarBackButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 03/04/2017.
 */

public class ReportForMeFragment extends BaseFragment {

    @BindView(R.id.toobar)
    ToobarBackButton toolbar;
    @BindView(R.id.fragment_report_title)
    EditText mReportTitle;
    @BindView(R.id.fragment_report_content)
    EditText mReportContent;
    @BindView(R.id.fragment_report_button_send)
    Button mButtonSend;

    private String title;
    private String content;

    @Override
    public int setContentLayout() {
        return R.layout.fragment_report;
    }

    @Override
    public void bindViewToFragment(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        toolbar.setToolbarTitle(getResources().getString(R.string.title_fragment_report));
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = mReportTitle.getText().toString();
                content = mReportContent.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "singgumcole@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                getActivity().startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }

    @Override
    public void fragmentReady() {

    }
}
