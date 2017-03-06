package com.huutho.phuotphuotphuot.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.maps.SupportMapFragment;
import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.ui.adapter.MotelAdapter;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.ui.entity.PlaceRested;
import com.huutho.phuotphuotphuot.ui.fragment.detail.FoodAndMotelDetail;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;
import com.huutho.phuotphuotphuot.utils.database.TableRested;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailMotelFragment extends BaseFragment implements IBaseAdapterCallback<PlaceRested> {
    private static final String EXTRA_MOTEL_FRAGMENT ="extra.motel.fragment";

    @BindView(R.id.fragment_place_detail_motel_list_motel)
    RecyclerView mRvMotel ;

    private Place mPlace ;
    private ArrayList<PlaceRested> mMotelData;
    private MotelAdapter mMotelAdapter ;
    private GridLayoutManager mLayoutManager;

    private Runnable runLoadData = new Runnable() {
        @Override
        public void run() {
            String selection = DbContracts.TableRested.RESTED_ID_PLACE;
            String [] args = new String[]{mPlace.mIdPlace};
            mMotelData = TableRested.getInstance().getListData(selection,args,null);
            mMotelAdapter.setDatas(mMotelData);
        }
    };

    private Place getBundleData(Bundle savedInstanceState){
        if (savedInstanceState == null){
            return getArguments().getParcelable(EXTRA_MOTEL_FRAGMENT);
        }
        return savedInstanceState.getParcelable(EXTRA_MOTEL_FRAGMENT);
    }

    public static PlaceDetailMotelFragment newInstance(Place place) {
        Bundle args = new Bundle();
        PlaceDetailMotelFragment fragment = new PlaceDetailMotelFragment();
        args.putParcelable(EXTRA_MOTEL_FRAGMENT,place);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_motel;
    }

    @Override
    public void bindViewToFragment(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        mPlace = getBundleData(savedInstanceState);
        mMotelData = new ArrayList<>();
        mPlace = getBundleData(savedInstanceState);
        getHandle().post(runLoadData);

        mMotelAdapter = new MotelAdapter(mContext,this);
        mLayoutManager = new GridLayoutManager(mContext,2);
        mRvMotel.setLayoutManager(mLayoutManager);
        mRvMotel.setAdapter(mMotelAdapter);
        mMotelAdapter.setDatas(mMotelData);
    }

    @Override
    public void fragmentReady() {

    }

    @Override
    public void onRecyclerViewItemClick(PlaceRested dataItem, View view, int position) {
        Intent intent = new Intent(mActivity,FoodAndMotelDetail.class);
        intent.putExtra(FoodAndMotelDetail.EXTRA_DETAIL_FRAGMENT,dataItem);
        mActivity.startActivity(intent);
    }
}
