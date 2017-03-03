package com.huutho.phuotphuotphuot.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.adapter.FoodsAdapter;
import com.huutho.phuotphuotphuot.ui.entity.Food;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;
import com.huutho.phuotphuotphuot.utils.database.TableFood;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailFoodFragment extends BaseFragment implements IBaseAdapterCallback<Food> {
    private static final String EXTRA_FOOD_FRAGMENT = "extra.food.fragment";

    @BindView(R.id.fragment_place_detail_food_list_food)
    RecyclerView mRvFoods;

    private Place mPlace;
    private FoodsAdapter mFoodAdapter;
    private GridLayoutManager layoutManager;
    private ArrayList<Food> mFoodDatas;

    private Place getBundleData(Bundle bundle) {
        if (bundle == null) {
            return getArguments().getParcelable(EXTRA_FOOD_FRAGMENT);
        }
        return bundle.getParcelable(EXTRA_FOOD_FRAGMENT);
    }

    private Runnable runLoadData = new Runnable() {
        @Override
        public void run() {
            String selection = DbContracts.TableFood.FOOD_ID_PLACE ;
            String [] args = new String[]{mPlace.mIdPlace};
            mFoodDatas = TableFood.getInstance().getListData(selection,args,null);
            mFoodAdapter.setDatas(mFoodDatas);
        }
    };


    public static PlaceDetailFoodFragment newInstance(Place place) {
        Bundle args = new Bundle();
        PlaceDetailFoodFragment fragment = new PlaceDetailFoodFragment();
        args.putParcelable(EXTRA_FOOD_FRAGMENT, place);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_food;
    }

    @Override
    public void bindViewToFragment(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, getView());
        mFoodDatas = new ArrayList<>();
        mPlace = getBundleData(savedInstanceState);
        getHandle().post(runLoadData);

        mFoodAdapter = new FoodsAdapter(mContext, this);
        layoutManager = new GridLayoutManager(mActivity,2);
        mRvFoods.setLayoutManager(layoutManager);
        mRvFoods.setAdapter(mFoodAdapter);
    }

    @Override
    public void fragmentReady() {

    }

    @Override
    public void onRecyclerViewItemClick(Food dataItem, View view, int position) {

    }

}
