package com.huutho.phuotphuotphuot.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.adapter.FoodsAdapter;
import com.huutho.phuotphuotphuot.ui.entity.Food;
import com.huutho.phuotphuotphuot.ui.entity.Place;

import butterknife.BindViews;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailFoodFragment extends BaseFragment implements IBaseAdapterCallback<Food> {

    @BindViews(R.id.fragment_place_detail_food_list_food)
    RecyclerView mRvFoods ;
    private FoodsAdapter mFoodAdapter;
    private GridLayoutManager layoutManager;

    public static PlaceDetailFoodFragment newInstance(Place place) {
        Bundle args = new Bundle();
        PlaceDetailFoodFragment fragment = new PlaceDetailFoodFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_food;
    }

    @Override
    public void bindViewToFragment() {
        mFoodAdapter = new FoodsAdapter(mContext,this);
        layoutManager = initGridLayoutManager(mActivity,2);
        mRvFoods.setLayoutManager(layoutManager);
        mRvFoods.setAdapter(mFoodAdapter);
//        mFoodAdapter.setDatas();
    }

    @Override
    public void fragmentReady() {

    }

    @Override
    public void onRecyclerViewItemClick(Food dataItem, View view, int position) {

    }

    private GridLayoutManager initGridLayoutManager(Context context ,int spanCout){
        GridLayoutManager layoutManager = new GridLayoutManager(context,spanCout);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 0;
            }
        });
        return layoutManager;
    }
}
