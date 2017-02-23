package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.City;
import com.huutho.phuotphuotphuot.ui.entity.Place;

import java.util.ArrayList;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TableCity extends DbHelper implements DbCommonOperator<City> {

    private static TableCity tableCity;

    public static TableCity getInstance() {
        if (tableCity == null) {
            tableCity = new TableCity();
        }
        return tableCity;
    }

    private TableCity() {

    }

    @Override
    public ArrayList<City> getListData(String selection, String[] args, String orderBy) {
        ArrayList<City> cities = new ArrayList<>();
        Cursor cursor = null;
        try {
            openDb();
            if (args == null || args.length == 0 || selection == null) {
                cursor = mSqlDatabase.query(DbContracts.TableCity.TABLE_CITY, null, selection, args, null, null, orderBy);
            } else {
                cursor = mSqlDatabase.query(DbContracts.TableCity.TABLE_CITY, null, selection + "=?", args, null, null, orderBy);
            }

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                cities.add(new City(cursor));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        closeDb();
        return cities;
    }

    @Override
    public City getItemData(String selection, String[] args) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }

    @Override
    public int update(City city) {
        return 0;
    }

    @Override
    public long insert(City city) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(City city) {
        return null;
    }
}
