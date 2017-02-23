package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TablePlace extends DbHelper implements DbCommonOperator<Place> {

    private static TablePlace tablePlace;

    public static TablePlace getInstance() {
        if (tablePlace == null) {
            tablePlace = new TablePlace();
        }
        return tablePlace;
    }

    private TablePlace() {

    }

    @Override
    public ArrayList<Place> getListData(String selection, String[] args, String orderBy) {
        ArrayList<Place> places = new ArrayList<>();
        Cursor cursor = null;
        try {
            openDb();
            if (args == null || args.length == 0 || selection == null) {
                cursor = mSqlDatabase.query(DbContracts.TablePlace.TABLE_PLACE, null, selection, args, null, null, orderBy);
            } else {
                cursor = mSqlDatabase.query(DbContracts.TablePlace.TABLE_PLACE, null, selection + "=?", args, null, null, orderBy);
            }

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                places.add(new Place(cursor));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        closeDb();
        return places;
    }

    @Override
    public Place getItemData(String selection, String[] args) {
        return null;
    }

    @Override
    public int delete(Place place) {
        return 0;
    }

    @Override
    public int update(Place place) {
        return 0;
    }

    @Override
    public long insert(Place place) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(Place place) {
        return null;
    }
}
