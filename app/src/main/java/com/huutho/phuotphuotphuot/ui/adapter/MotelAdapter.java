package com.huutho.phuotphuotphuot.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.BaseRVAdapter;
import com.huutho.phuotphuotphuot.base.adapter.BaseViewHolder;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.ui.entity.PlaceRested;
import com.huutho.phuotphuotphuot.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 03/03/2017.
 */

public class MotelAdapter extends BaseRVAdapter<MotelAdapter.ViewHolder,PlaceRested> {
    public MotelAdapter(Context context, IBaseAdapterCallback callback) {
        super(context, callback);
    }

    @Override
    public MotelAdapter.ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewParent.getContext()).inflate(R.layout.layout_item_motel,viewParent,false));
    }

    @Override
    public void onAdapterReady(MotelAdapter.ViewHolder holder, int position) {
        PlaceRested rested = getDataItem(position);
        holder.name.setText(rested.mNamePlaceRested);
        ImageUtils.loadImage(mContext,rested.mImagePlaceRested,holder.imageView,holder.progressBar);
        holder.itemView.setOnClickListener(new OnRecyclerViewItemClickListener(rested,position));
    }

    public static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.layout_item_motel_image)
        ImageView imageView;
        @BindView(R.id.layout_item_motel_name)
        TextView name;
        @BindView(R.id.loading)
        ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
