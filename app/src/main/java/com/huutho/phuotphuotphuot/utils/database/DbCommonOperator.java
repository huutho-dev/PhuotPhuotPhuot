package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;

import java.util.ArrayList;

/**
 * Created by HuuTho on 2/22/2017.
 */

public interface DbCommonOperator<E> {
    ArrayList<E> getListData(String selection, String[] args, String orderBy);

    E getItemData(String selection, String[] args);

    int delete(E e);

    int update(E e);

    long insert(E e);

    ContentValues convertObjToContentValues(E e);
}
