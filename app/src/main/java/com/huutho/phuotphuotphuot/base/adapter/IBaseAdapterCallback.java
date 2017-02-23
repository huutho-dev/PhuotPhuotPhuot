package com.huutho.phuotphuotphuot.base.adapter;

import android.view.View;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;

/**
 * Created by HuuTho on 1/17/2017.
 */
public interface IBaseAdapterCallback<E extends BaseEntity>  {
   void onRecyclerViewItemClick(E dataItem, View view, int position);
}
