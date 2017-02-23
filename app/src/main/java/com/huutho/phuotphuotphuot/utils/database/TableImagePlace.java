package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.City;
import com.huutho.phuotphuotphuot.ui.entity.ImagePlace;

import java.util.ArrayList;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TableImagePlace extends DbHelper implements DbCommonOperator<ImagePlace> {

    private static TableImagePlace tableImage;

    public static TableImagePlace getInstance() {
        if (tableImage == null) {
            tableImage = new TableImagePlace();
        }
        return tableImage;
    }

    private TableImagePlace() {

    }

    @Override
    public ArrayList<ImagePlace> getListData(String selection, String[] args, String orderBy) {
        ArrayList<ImagePlace> imagePlaces = new ArrayList<>();
        Cursor cursor = null;
        try {
            openDb();
            if (args == null || args.length == 0 || selection == null) {
                cursor = mSqlDatabase.query(DbContracts.TableImagePlace.TABLE_IMAGE_PLACE, null, selection, args, null, null, orderBy);
            } else {
                cursor = mSqlDatabase.query(DbContracts.TableImagePlace.TABLE_IMAGE_PLACE, null, selection + "=?", args, null, null, orderBy);
            }

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                imagePlaces.add(new ImagePlace(cursor));
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        closeDb();
        return imagePlaces;
    }

    @Override
    public ImagePlace getItemData(String selection, String[] args) {
        return null;
    }

    @Override
    public int delete(ImagePlace imagePlace) {
        return 0;
    }

    @Override
    public int update(ImagePlace imagePlace) {
        return 0;
    }

    @Override
    public long insert(ImagePlace imagePlace) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(ImagePlace imagePlace) {
        return null;
    }
}
