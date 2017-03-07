package com.huutho.phuotphuotphuot.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.BaseRVAdapter;
import com.huutho.phuotphuotphuot.base.adapter.BaseViewHolder;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.ui.entity.City;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;
import com.huutho.phuotphuotphuot.utils.database.TableCity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 2/12/2017.
 */

public class ChooseCityAdapter extends BaseRVAdapter<ChooseCityAdapter.ViewHolder, City> {

    private ArrayList<City> cities;
    private City city;
    private int mSizeDatas;

    public interface ICitySelected extends IBaseAdapterCallback {

    }

    public ChooseCityAdapter(Context context, int idZone, ICitySelected callback) {
        super(context, callback);
        cities = TableCity.getInstance().getListData(DbContracts.TableCity.CITY_ID_ZONE,
                new String[]{String.valueOf(idZone)}, null);

        mSizeDatas = cities.size();
        setDatas(cities);
    }

    @Override
    public ChooseCityAdapter.ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewParent.getContext())
                .inflate(R.layout.item_choose_city, viewParent, false));
    }

    @Override
    public void onAdapterReady(ChooseCityAdapter.ViewHolder holder, final int position) {
        city = getDataItem(position);
        holder.mCity.setText(city.getmNameCity());
        holder.mCheckbox.setChecked(city.isSelected);
        holder.mCheckbox.setClickable(false);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onRecyclerViewItemClick(getDataItem(position), v, position);
                for (int i = 0; i < mSizeDatas; i++) {
                    getDataItem(i).isSelected = false;
                }
                getDataItem(position).isSelected = true;
                notifyDataSetChanged();
            }
        });
    }

    protected static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.item_tv_city)
        AppCompatTextView mCity;
        @BindView(R.id.item_ckb_select)
        AppCompatCheckBox mCheckbox;
        @BindView(R.id.view_parent)
        RelativeLayout viewParent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
