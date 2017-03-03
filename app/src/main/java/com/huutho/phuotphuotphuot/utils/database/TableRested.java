package com.huutho.phuotphuotphuot.utils.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.huutho.phuotphuotphuot.ui.entity.PlaceRested;

import java.util.ArrayList;

/**
 * Created by HuuTho on 2/22/2017.
 */

public class TableRested extends DbHelper implements DbCommonOperator<PlaceRested> {

    private static TableRested mInstance;

    public static synchronized TableRested getInstance() {
        if (mInstance == null) {
            mInstance = new TableRested();
        }
        return mInstance;
    }

    private TableRested() {

    }

    @Override
    public ArrayList<PlaceRested> getListData(String selection, String[] args, String orderBy) {
        ArrayList<PlaceRested> resteds = new ArrayList<>();
        Cursor cursor = null;
        openDb();
        try {
            cursor = mSqlDatabase.query(DbContracts.TableRested.TABLE_RESTED, null, selection + "=?", args, null, null, orderBy);
            cursor.moveToFirst();
            int indexRestedId = cursor.getColumnIndex(DbContracts.TableRested.RESTED_ID);
            int indexRestedName = cursor.getColumnIndex(DbContracts.TableRested.RESTED_NAME);
            int indexRestedLatLng = cursor.getColumnIndex(DbContracts.TableRested.RESTED_LATLNG);
            int indexRestedImage = cursor.getColumnIndex(DbContracts.TableRested.RESTED_URL_IMAGE);
            int indexRestedIntro = cursor.getColumnIndex(DbContracts.TableRested.RESTED_INTRO);
            int indexRestedPrice = cursor.getColumnIndex(DbContracts.TableRested.RESTED_PRICE);
            int indexRestedIdPlace = cursor.getColumnIndex(DbContracts.TableRested.RESTED_ID_PLACE);
            int indexRestedPhone = cursor.getColumnIndex(DbContracts.TableRested.RESTED_PHONE_NUMBER);
            while (!cursor.isAfterLast()) {
                PlaceRested placeRested = new PlaceRested();
                placeRested.mIdPlaceRested = cursor.getString(indexRestedId);
                placeRested.mNamePlaceRested = cursor.getString(indexRestedName);
                placeRested.mLatLng = cursor.getString(indexRestedLatLng);
                placeRested.mImagePlaceRested = cursor.getString(indexRestedImage);
                placeRested.mIntroPlaceRested = cursor.getString(indexRestedIntro);
                placeRested.mPrice = cursor.getString(indexRestedPrice);
                placeRested.mIdPlace = cursor.getString(indexRestedIdPlace);
                placeRested.mPhoneNumberPlace = cursor.getString(indexRestedPhone);
                resteds.add(placeRested);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeDb();
        if (cursor != null && !cursor.isClosed()) cursor.close();
        return resteds;
    }

    @Override
    public PlaceRested getItemData(String selection, String[] args) {
        return null;
    }

    @Override
    public int delete(PlaceRested placeRested) {
        return 0;
    }

    @Override
    public int update(PlaceRested placeRested) {
        return 0;
    }

    @Override
    public long insert(PlaceRested placeRested) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(PlaceRested placeRested) {
        return null;
    }
}
