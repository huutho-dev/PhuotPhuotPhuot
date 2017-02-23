package com.huutho.phuotphuotphuot.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.BaseRVAdapter;
import com.huutho.phuotphuotphuot.base.adapter.BaseViewHolder;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.utils.ImageUtils;
import com.huutho.phuotphuotphuot.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 1/24/2017.
 */
public class PlaceRVAdapter extends BaseRVAdapter<PlaceRVAdapter.ViewHolder, Place> {
    private final String TAG = PlaceRVAdapter.class.getSimpleName();

    public interface IPlaceAdapterListener extends IBaseAdapterCallback<Place> {

    }

    public PlaceRVAdapter(Context context, IPlaceAdapterListener callback) {
        super(context, callback);
    }

    @Override
    public ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item_place, viewParent, false));
    }

    @Override
    public void onAdapterReady(ViewHolder holder, final int position) {
        final Place place = (Place) mDatas.get(position);

        String title = place.getmNamePlace();
        String urlImage = place.getmUrlImage();
        String city = place.getmCity();

        holder.mTitle.setText(title);
        holder.mCity.setText(city);
        ImageUtils.loadImageWithPicasso(mContext,urlImage,holder.mImage);

        LogUtils.e("huutho",place.getmUrlImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onRecyclerViewItemClick(place,v,position);
            }
        });
    }

    public static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.layout_item_place_imv_desc)
        ImageView mImage;
        @BindView(R.id.layout_item_place_tv_title_desc)
        TextView mTitle;
        @BindView(R.id.layout_item_place_tv_city_of_place)
        TextView mCity;

        protected ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
