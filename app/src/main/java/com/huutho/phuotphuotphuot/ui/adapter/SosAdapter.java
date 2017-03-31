package com.huutho.phuotphuotphuot.ui.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.adapter.BaseRVAdapter;
import com.huutho.phuotphuotphuot.base.adapter.BaseViewHolder;
import com.huutho.phuotphuotphuot.base.adapter.IBaseAdapterCallback;
import com.huutho.phuotphuotphuot.ui.entity.SOS;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hnc on 31/03/2017.
 */

public class SosAdapter extends BaseRVAdapter<SosAdapter.ViewHolder, SOS> {

    public interface ISosAdapterListener extends IBaseAdapterCallback<SOS> {

    }

    public SosAdapter(Context context, ISosAdapterListener callback) {
        super(context, callback);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    @Override
    public ViewHolder onCreateViewAdapter(ViewGroup viewParent, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewParent.getContext()).inflate(R.layout.layout_item_sos, viewParent, false));
    }

    @Override
    public void onAdapterReady(ViewHolder holder, int position) {
        final SOS item = (SOS) mDatas.get(position);
        holder.mTxtCityName.setText(item.nameCity);
        holder.mImvHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog(item.hospitalPhone);
            }
        });

        holder.mImvPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog(item.policePhone);
            }
        });

        holder.mImvRescue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog(item.rescuePhone);
            }
        });
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.txt_city_name)
        public TextView mTxtCityName;

        @BindView(R.id.btn_hospital_phone)
        public ImageView mImvHospital;

        @BindView(R.id.btn_rescue_phone)
        public ImageView mImvRescue;

        @BindView(R.id.btn_police_phone)
        public ImageView mImvPolice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private void getDialog(final String number) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext)
                .setTitle("Cuộc gọi khẩn cấp")
                .setMessage("Bạn có thực sự cần được giúp đỡ !")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + number));
                            if (intent.resolveActivity(mContext.getPackageManager()) != null) {
                                mContext.startActivity(intent);
                            }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }
}
