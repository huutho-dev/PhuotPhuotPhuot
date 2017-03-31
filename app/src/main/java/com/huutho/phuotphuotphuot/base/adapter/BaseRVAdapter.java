package com.huutho.phuotphuotphuot.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by HuuTho on 1/17/2017.
 */
public abstract class BaseRVAdapter<VH extends BaseViewHolder, E extends BaseEntity> extends RecyclerView.Adapter<VH> {
    public Context mContext;
    public ArrayList<BaseEntity> mDatas;
    public IBaseAdapterCallback<E> mAdapterCallback;

    public BaseRVAdapter(Context context, IBaseAdapterCallback callback) {
        this.mContext = context;
        this.mAdapterCallback = callback;
        this.mDatas = new ArrayList<>();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewAdapter(parent, viewType);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onAdapterReady(holder, position);
    }

    @Override
    public int getItemCount() {
        if (mDatas != null && mDatas.size() != 0) {
            return mDatas.size();
        }
        return 0;
    }

    public void setDatas(ArrayList<E> datas) {
        if (mDatas != null) {
            mDatas.clear();
            mDatas.addAll(datas);
            notifyDataSetChanged();
        }
    }

    public void appendData(BaseEntity data) {
        if (mDatas != null) {
            mDatas.add(data);
        }
    }

    public void appendData(BaseEntity data, int position) {
        if (mDatas != null) {
            mDatas.add(position, data);
        }
    }

    public E getDataItem(int position) {
        if (mDatas != null) {
            return (E) mDatas.get(position);
        }
        return null;
    }

    public class OnRecyclerViewItemClickListener implements View.OnClickListener {
        private E data;
        private int position;

        public OnRecyclerViewItemClickListener(E data, int position) {
            this.data = data;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            mAdapterCallback.onRecyclerViewItemClick(data, v, position);
        }
    }

    public abstract VH onCreateViewAdapter(ViewGroup viewParent, int viewType);

    public abstract void onAdapterReady(VH holder, int position);
}
