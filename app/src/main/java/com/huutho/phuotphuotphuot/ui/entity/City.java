package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdCity);
        dest.writeString(this.mNameCity);
        dest.writeString(this.mIdZone);
        dest.writeString(this.mNameCityClean);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    protected City(Parcel in) {
        this.mIdCity = in.readString();
        this.mNameCity = in.readString();
        this.mIdZone = in.readString();
        this.mNameCityClean = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
