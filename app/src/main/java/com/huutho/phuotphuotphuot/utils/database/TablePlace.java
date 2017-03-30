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
        openDb();
       int update =  mSqlDatabase.update(DbContracts.TablePlace.TABLE_PLACE,
               convertObjToContentValues(place),
               DbContracts.TablePlace.PLACE_ID_PLACE+"=?",new String[]{place.mIdPlace});
        return update;
    }

    @Override
    public long insert(Place place) {
        return 0;
    }

    @Override
    public ContentValues convertObjToContentValues(Place place) {
        ContentValues values = new ContentValues();
        values.put(DbContracts.TablePlace.PLACE_ID_PLACE,place.mIdPlace);
        values.put(DbContracts.TablePlace.PLACE_NAME_CITY,place.mCity);
        values.put(DbContracts.TablePlace.PLACE_FAVORITE,place.mFavorite);
        values.put(DbContracts.TablePlace.PLACE_ID_ZONE,place.mIdZone);
        values.put(DbContracts.TablePlace.PLACE_INTRO,place.mIntro);
        values.put(DbContracts.TablePlace.PLACE_LATLNG,place.mLatLng);
        values.put(DbContracts.TablePlace.PLACE_NAME_PLACE,place.mNamePlace);
        values.put(DbContracts.TablePlace.PLACE_URL_IMAGE,place.mUrlImage);
        values.put(DbContracts.TablePlace.PLACE_ID_CITY,place.mIdCity);
        return values;
    }
}
