package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class City extends BaseEntity {
    private String mIdCity;
    private String mNameCity;
    private String mIdZone;
    private String mNameCityClean;

    public boolean isSelected = false;

    public City(String mIdCity, String mNameCity, String mIdZone, String mNameCityClean) {
        this.mIdCity = mIdCity;
        this.mNameCity = mNameCity;
        this.mIdZone = mIdZone;
        this.mNameCityClean = mNameCityClean;
    }

    public City(Cursor cursor) {
        mIdCity = cursor.getString(cursor.getColumnIndex(DbContracts.TableCity.CITY_ID));
        mNameCity = cursor.getString(cursor.getColumnIndex(DbContracts.TableCity.CITY_NAME));
        mIdZone = cursor.getString(cursor.getColumnIndex(DbContracts.TableCity.CITY_ID_ZONE));
        mNameCityClean = cursor.getString(cursor.getColumnIndex(DbContracts.TableCity.CITY_NAME_CLEAN));
    }

    public String getmIdCity() {
        return mIdCity;
    }

    public void setmIdCity(String mIdCity) {
        this.mIdCity = mIdCity;
    }

    public String getmNameCity() {
        return mNameCity;
    }

    public void setmNameCity(String mNameCity) {
        this.mNameCity = mNameCity;
    }

    public String getmIdZone() {
        return mIdZone;
    }

    public void setmIdZone(String mIdZone) {
        this.mIdZone = mIdZone;
    }

    public String getmNameCityClean() {
        return mNameCityClean;
    }

    public void setmNameCityClean(String mNameCityClean) {
        this.mNameCityClean = mNameCityClean;
    }

    @Override
    public String toString() {
        return "City{" +
                "mIdCity='" + mIdCity + '\'' +
                ", mNameCity='" + mNameCity + '\'' +
                ", mIdZone='" + mIdZone + '\'' +
                ", mNameCityClean='" + mNameCityClean + '\'' +
                '}';
    }
}
