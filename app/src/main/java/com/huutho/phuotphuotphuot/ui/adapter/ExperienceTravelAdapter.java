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
import com.huutho.phuotphuotphuot.ui.entity.ExperienceTravel;
import com.huutho.phuotphuotphuot.utils.ImageUtils;
import com.huutho.phuotphuotphuot.utils.database.TableExperience;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 07/03/2017.
 */

public class ExperienceTravelAdapter extends BaseRVAdapter<ExperienceTravelAdapter.ViewHolder, ExperienceTravel> {
    public ExperienceTravelAdapter(Context context, IBaseAdapterCallback callback) {
        super(context, callback);

        setDatas(TableExperience.getInstance().getListData(null,null,null));
    }

    @Override
    public ExperienceTravelAdapter.ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewParent.getContext())
                .inflate(R.layout.layout_item_experience, viewParent, false));
    }

    @Override
    public void onAdapterReady(ExperienceTravelAdapter.ViewHolder holder, final int position) {
        ExperienceTravel exp = getDataItem(position);
        ImageUtils.loadImage(mContext, exp.mImageExp, holder.mExpImage);
        holder.mExpTitle.setText(exp.mNameExp);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onRecyclerViewItemClick(getDataItem(position), v, position);
            }
        });
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.experience_image)
        ImageView mExpImage;
        @BindView(R.id.experience_title)
        TextView mExpTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
