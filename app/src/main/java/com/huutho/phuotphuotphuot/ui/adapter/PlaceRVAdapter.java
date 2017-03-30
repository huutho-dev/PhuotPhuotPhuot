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
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.utils.ImageUtils;
import com.huutho.phuotphuotphuot.utils.database.TablePlace;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 1/24/2017.
 */
public class PlaceRVAdapter extends BaseRVAdapter<PlaceRVAdapter.ViewHolder, Place> {

    public static final String FAV = "true";
    public static final String UN_FAV = "false";

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
    public void onAdapterReady(final ViewHolder holder, final int position) {
        final Place place = (Place) mDatas.get(position);

        if (place.mFavorite.equals(FAV)){
            holder.mFav.setImageResource(R.drawable.icon_fav);
        }else {
            holder.mFav.setImageResource(R.drawable.icon_un_fav);
        }



        String title = place.mNamePlace;
        String urlImage = place.mUrlImage;
        String city = place.mCity;

        holder.mTitle.setText(title);
        holder.mCity.setText(city);
        ImageUtils.loadImage(mContext,urlImage,holder.mImage, holder.progressBar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onRecyclerViewItemClick(place,v,position);
            }
        });

        holder.mFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (place.mFavorite.equals(FAV)){
                   place.mFavorite = UN_FAV;
                }else {
                   place.mFavorite = FAV;
                }
                TablePlace.getInstance().update(place);
               notifyItemChanged(position);
            }
        });
    }

    public static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.layout_item_place_imv_desc)
        ImageView mImage;
        @BindView(R.id.layout_item_place_tv_title_desc)
        TextView mTitle;
        @BindView(R.id.item_favorite)
        ImageView mFav ;
        @BindView(R.id.layout_item_place_tv_city_of_place)
        TextView mCity;
        @BindView(R.id.loading)
        ProgressBar progressBar;

        protected ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
