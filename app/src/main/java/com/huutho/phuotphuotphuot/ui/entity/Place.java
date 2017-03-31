package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by HuuTho on 1/24/2017.
 */
public class Place extends BaseEntity {
    public final String TAG = Place.class.getSimpleName();

    public String mIdPlace;
    public String mIdCity;
    public String mIdZone ;
    public String mNamePlace;
    public String mLatLng ;
    public String mFavorite;
    public String mIntro ;
    public String mUrlImage;
    public String mCity ;


    public Place(Cursor cursor){
        mIdPlace = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_ID_PLACE));
        mIdCity = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_ID_CITY));
        mIdZone = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_ID_ZONE));
        mNamePlace = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_NAME_PLACE));
        mLatLng = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_LATLNG));
        mFavorite = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_FAVORITE));
        mIntro = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_INTRO));
        mUrlImage = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_URL_IMAGE));
        mCity = cursor.getString(cursor.getColumnIndex(DbContracts.TablePlace.PLACE_NAME_CITY));
    }

    @Override
    public String toString() {
        return "Place{" +
                "TAG='" + TAG + '\'' +
                ", mIdPlace='" + mIdPlace + '\'' +
                ", mIdCity='" + mIdCity + '\'' +
                ", mIdZone='" + mIdZone + '\'' +
                ", mNamePlace='" + mNamePlace + '\'' +
                ", mLatLng='" + mLatLng + '\'' +
                ", mFavorite='" + mFavorite + '\'' +
                ", mIntro='" + mIntro + '\'' +
                ", mUrlImage='" + mUrlImage + '\'' +
                ", mCity='" + mCity + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdPlace);
        dest.writeString(this.mIdCity);
        dest.writeString(this.mIdZone);
        dest.writeString(this.mNamePlace);
        dest.writeString(this.mLatLng);
        dest.writeString(this.mFavorite);
        dest.writeString(this.mIntro);
        dest.writeString(this.mUrlImage);
        dest.writeString(this.mCity);
    }

    protected Place(Parcel in) {
        this.mIdPlace = in.readString();
        this.mIdCity = in.readString();
        this.mIdZone = in.readString();
        this.mNamePlace = in.readString();
        this.mLatLng = in.readString();
        this.mFavorite = in.readString();
        this.mIntro = in.readString();
        this.mUrlImage = in.readString();
        this.mCity = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel source) {
            return new Place(source);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}
