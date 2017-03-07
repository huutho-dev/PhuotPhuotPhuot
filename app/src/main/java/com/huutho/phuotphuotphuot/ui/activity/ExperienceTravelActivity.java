package com.huutho.phuotphuotphuot.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.activity.BaseActivity;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.ui.adapter.ExperienceTravelAdapter;
import com.huutho.phuotphuotphuot.ui.entity.ExperienceTravel;
import com.huutho.phuotphuotphuot.ui.fragment.ExperienceInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 07/03/2017.
 */

public class ExperienceTravelActivity extends BaseActivity implements IBaseAdapterCallback {

    @BindView(R.id.toobar)
    Toolbar toolbar;
    @BindView(R.id.activity_experience_list)
    RecyclerView mRvExperiences;

    private RecyclerView.LayoutManager mLinearManager;
    private ExperienceTravelAdapter mRvAdapter ;


    public static void newInstance(AppCompatActivity activity){
        Intent intent = new Intent(activity, ExperienceTravelActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public int setContentLayout() {
        return R.layout.activity_experience_travel;
    }

    @Override
    public void bindViewToLayout() {
        ButterKnife.bind(this);
        toolbar.setTitle("Kinh nghiệm phượt");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mLinearManager = new LinearLayoutManager(this);
        mRvAdapter = new ExperienceTravelAdapter(this,this);
        mRvExperiences.setLayoutManager(mLinearManager);
        mRvExperiences.setAdapter(mRvAdapter);
    }

    @Override
    public void activityReady() {

    }

    @Override
    public void onRecyclerViewItemClick(BaseEntity dataItem, View view, int position) {
        addFragment(R.id.root, ExperienceInfoFragment.newInstance((ExperienceTravel) dataItem));
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        if (count!=0){
            fm.popBackStack();
        }else {
            super.onBackPressed();
        }
    }
}
