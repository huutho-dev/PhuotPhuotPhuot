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
import com.huutho.phuotphuotphuot.ui.entity.Food;
import com.huutho.phuotphuotphuot.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 3/1/2017.
 */

public class FoodsAdapter extends BaseRVAdapter<FoodsAdapter.ViewHolder, Food> {
    public FoodsAdapter(Context context, IBaseAdapterCallback callback) {
        super(context, callback);
    }

    @Override
    public FoodsAdapter.ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewParent.getContext())
                .inflate(R.layout.layout_item_foods,viewParent,false));
    }

    @Override
    public void onAdapterReady(FoodsAdapter.ViewHolder holder, int position) {
        Food food = (Food) mDatas.get(position);
        holder.nameFood.setText(food.mNameFood);
        ImageUtils.loadImage(mContext,food.mImageFood,holder.imgFood,holder.progressBar);
        holder.itemView.setOnClickListener(new OnRecyclerViewItemClickListener(food,position));
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.image_item_foods)
        ImageView imgFood;
        @BindView(R.id.name_item_foods)
        TextView nameFood;
        @BindView(R.id.loading)
        ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
