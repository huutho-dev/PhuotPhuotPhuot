package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class ImagePlace extends BaseEntity {
    private String mIdImage;
    private String mLinkImage ;
    private String mIdPlace ;

    public ImagePlace(String mIdImage, String mLinkImage, String mIdPlace) {
        this.mIdImage = mIdImage;
        this.mLinkImage = mLinkImage;
        this.mIdPlace = mIdPlace;
    }

    public ImagePlace(Cursor cursor){
        mIdImage = cursor.getString(cursor.getColumnIndex(DbContracts.TableImagePlace.IMAGE_PLACE_ID));
        mLinkImage = cursor.getString(cursor.getColumnIndex(DbContracts.TableImagePlace.IMAGE_PLACE_URL_IMAGE));
        mIdPlace = cursor.getString(cursor.getColumnIndex(DbContracts.TableImagePlace.IMAGE_PLACE_ID_PLACE));
    }

    public String getmIdImage() {
        return mIdImage;
    }

    public void setmIdImage(String mIdImage) {
        this.mIdImage = mIdImage;
    }

    public String getmLinkImage() {
        return mLinkImage;
    }

    public void setmLinkImage(String mLinkImage) {
        this.mLinkImage = mLinkImage;
    }

    public String getmIdPlace() {
        return mIdPlace;
    }

    public void setmIdPlace(String mIdPlace) {
        this.mIdPlace = mIdPlace;
    }

    @Override
    public String toString() {
        return "ImagePlace{" +
                "mIdImage='" + mIdImage + '\'' +
                ", mLinkImage='" + mLinkImage + '\'' +
                ", mIdPlace='" + mIdPlace + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdImage);
        dest.writeString(this.mLinkImage);
        dest.writeString(this.mIdPlace);
    }

    protected ImagePlace(Parcel in) {
        this.mIdImage = in.readString();
        this.mLinkImage = in.readString();
        this.mIdPlace = in.readString();
    }

    public static final Creator<ImagePlace> CREATOR = new Creator<ImagePlace>() {
        @Override
        public ImagePlace createFromParcel(Parcel source) {
            return new ImagePlace(source);
        }

        @Override
        public ImagePlace[] newArray(int size) {
            return new ImagePlace[size];
        }
    };
}
