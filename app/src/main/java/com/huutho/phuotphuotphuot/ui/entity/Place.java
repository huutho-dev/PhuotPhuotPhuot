package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by HuuTho on 1/24/2017.
 */
public class Place extends BaseEntity {
    private final String TAG = Place.class.getSimpleName();

    private String mIdPlace;
    private String mIdCity;
    private String mIdZone ;
    private String mNamePlace;
    private String mLatLng ;
    private String mFavorite;
    private String mIntro ;
    private String mUrlImage;
    private String mCity ;

    public Place(String mIdPlace, String mIdCity, String mIdZone, String mNamePlace, String mLatLng,
                 String mFavorite, String mIntro, String mUrlImage, String mCity) {
        this.mIdPlace = mIdPlace;
        this.mIdCity = mIdCity;
        this.mIdZone = mIdZone;
        this.mNamePlace = mNamePlace;
        this.mLatLng = mLatLng;
        this.mFavorite = mFavorite;
        this.mIntro = mIntro;
        this.mUrlImage = mUrlImage ;
        this.mCity = mCity;
    }

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

    public String getmUrlImage() {
        return mUrlImage;
    }

    public void setmUrlImage(String mUrlImage) {
        this.mUrlImage = mUrlImage;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getTAG() {
        return TAG;
    }

    public String getmIdPlace() {
        return mIdPlace;
    }

    public void setmIdPlace(String mIdPlace) {
        this.mIdPlace = mIdPlace;
    }

    public String getmIdCity() {
        return mIdCity;
    }

    public void setmIdCity(String mIdCity) {
        this.mIdCity = mIdCity;
    }

    public String getmIdZone() {
        return mIdZone;
    }

    public void setmIdZone(String mIdZone) {
        this.mIdZone = mIdZone;
    }

    public String getmNamePlace() {
        return mNamePlace;
    }

    public void setmNamePlace(String mNamePlace) {
        this.mNamePlace = mNamePlace;
    }

    public String getmLatLng() {
        return mLatLng;
    }

    public void setmLatLng(String mLatLng) {
        this.mLatLng = mLatLng;
    }

    public String getmFavorite() {
        return mFavorite;
    }

    public void setmFavorite(String mFavorite) {
        this.mFavorite = mFavorite;
    }

    public String getmIntro() {
        return mIntro;
    }

    public void setmIntro(String mIntro) {
        this.mIntro = mIntro;
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
