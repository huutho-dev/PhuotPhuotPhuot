package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.SOS;

import java.util.ArrayList;

/**
 * Created by hnc on 31/03/2017.
 */

public class TableSOS extends DbHelper implements DbCommonOperator<SOS> {

    private static TableSOS tableSos;

    public static TableSOS getInstance() {
        if (tableSos == null) {
            tableSos = new TableSOS();
        }
        return tableSos;
    }

    private TableSOS() {

    }



    @Override
    public ArrayList<SOS> getListData(String selection, String[] args, String orderBy) {
        ArrayList<SOS> soses = new ArrayList<>();
        Cursor cursor = null;
        try {
            openDb();
                cursor = mSqlDatabase.query(DbContracts.TableSOS.TABLE_SOS, null, selection, args, null, null, orderBy);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                soses.add(new SOS(cursor));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        closeDb();
        return soses;
    }

    @Override
    public SOS getItemData(String selection, String[] args) {
        return null;
    }

    @Override
    public int delete(SOS sos) {
        return 0;
    }

    @Override
    public int update(SOS sos) {
        return 0;
    }

    @Override
    public long insert(SOS sos) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(SOS sos) {
        return null;
    }
}
