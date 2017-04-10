package com.huutho.phuotphuotphuot.ui.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.BaseRVAdapter;
import com.huutho.phuotphuotphuot.base.adapter.BaseViewHolder;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.location.RoutesLocation;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ThoNH on 10/04/2017.
 */

public class NavigateDirectionAdapter extends BaseRVAdapter<NavigateDirectionAdapter.ViewHolder, RoutesLocation.RoutesBean.LegsBean.StepsBean> {

    public NavigateDirectionAdapter(Context context, IBaseAdapterCallback callback) {
        super(context, callback);
    }

    @Override
    public NavigateDirectionAdapter.ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(viewParent.getContext()).inflate(R.layout.layout_instructions_map,viewParent,false));
    }

    @Override
    public void onAdapterReady(NavigateDirectionAdapter.ViewHolder holder, int position) {
        RoutesLocation.RoutesBean.LegsBean.StepsBean stepsBean = getDataItem(position);
        String maneuver = stepsBean.maneuver ;
        if (maneuver == null){
            maneuver = "Unknow";
        }
        holder.mTxtManeuver.setText(maneuver +"  : " +stepsBean.distance.text + " - " + stepsBean.duration.text);
        holder.mTxtHtml.setText(Html.fromHtml(stepsBean.htmlInstructions));

    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.txt_maneuver)
        public TextView mTxtManeuver;

        @BindView(R.id.txt_htmlInstructions)
        public TextView mTxtHtml;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
