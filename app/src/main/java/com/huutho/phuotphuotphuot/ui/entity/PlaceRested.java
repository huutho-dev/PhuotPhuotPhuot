package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/2/17.
 */

public class PlaceRested extends BaseEntity {
    public String mIdPlaceRested;
    public String mNamePlaceRested;
    public String mLatLng;
    public String mImagePlaceRested;
    public String mIntroPlaceRested;
    public String mPhoneNumberPlace;
    public String mPrice;
    public String mIdPlace;

    public PlaceRested(){

    }

    public PlaceRested(String mIdPlaceRested, String mNamePlaceRested, String mLatLng,
                       String mImagePlaceRested, String mIntroPlaceRested,
                       String mPhoneNumberPlace, String mPrice, String mIdPlace) {
        this.mIdPlaceRested = mIdPlaceRested;
        this.mNamePlaceRested = mNamePlaceRested;
        this.mLatLng = mLatLng;
        this.mImagePlaceRested = mImagePlaceRested;
        this.mIntroPlaceRested = mIntroPlaceRested;
        this.mPhoneNumberPlace = mPhoneNumberPlace;
        this.mPrice = mPrice;
        this.mIdPlace = mIdPlace;
    }

    public PlaceRested(Cursor cursor) {
        mIdPlaceRested = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_ID));
        mNamePlaceRested = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_NAME));
        mLatLng = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_LATLNG));
        mImagePlaceRested = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_URL_IMAGE));
        mIntroPlaceRested = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_INTRO));
        mPhoneNumberPlace = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_PHONE_NUMBER));
        mPrice = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_PRICE));
        mIdPlace = cursor.getString(cursor.getColumnIndex(DbContracts.TableRested.RESTED_ID_PLACE));
    }


    @Override
    public String toString() {
        return "PlaceRested{" +
                "mIdPlaceRested='" + mIdPlaceRested + '\'' +
                ", mNamePlaceRested='" + mNamePlaceRested + '\'' +
                ", mLatLng='" + mLatLng + '\'' +
                ", mImagePlaceRested='" + mImagePlaceRested + '\'' +
                ", mIntroPlaceRested='" + mIntroPlaceRested + '\'' +
                ", mPhoneNumberPlace='" + mPhoneNumberPlace + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mIdPlace='" + mIdPlace + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdPlaceRested);
        dest.writeString(this.mNamePlaceRested);
        dest.writeString(this.mLatLng);
        dest.writeString(this.mImagePlaceRested);
        dest.writeString(this.mIntroPlaceRested);
        dest.writeString(this.mPhoneNumberPlace);
        dest.writeString(this.mPrice);
        dest.writeString(this.mIdPlace);
    }

    protected PlaceRested(Parcel in) {
        this.mIdPlaceRested = in.readString();
        this.mNamePlaceRested = in.readString();
        this.mLatLng = in.readString();
        this.mImagePlaceRested = in.readString();
        this.mIntroPlaceRested = in.readString();
        this.mPhoneNumberPlace = in.readString();
        this.mPrice = in.readString();
        this.mIdPlace = in.readString();
    }

    public static final Creator<PlaceRested> CREATOR = new Creator<PlaceRested>() {
        @Override
        public PlaceRested createFromParcel(Parcel source) {
            return new PlaceRested(source);
        }

        @Override
        public PlaceRested[] newArray(int size) {
            return new PlaceRested[size];
        }
    };
}
