package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class Food extends BaseEntity {
    public String mIdFood;
    public String mNameFood ;
    public String mIntroFood;
    public String mImageFood;
    public String mIdPlace;

    public Food(String mIdFood, String mNameFood, String mIntroFood, String mImageFood, String mIdPlace) {
        this.mIdFood = mIdFood;
        this.mNameFood = mNameFood;
        this.mIntroFood = mIntroFood;
        this.mImageFood = mImageFood;
        this.mIdPlace = mIdPlace;
    }
    public Food(Cursor cursor){
        mIdFood = cursor.getString(cursor.getColumnIndex(DbContracts.TableFood.FOOD_ID));
        mNameFood = cursor.getString(cursor.getColumnIndex(DbContracts.TableFood.FOOD_NAME));
        mIntroFood = cursor.getString(cursor.getColumnIndex(DbContracts.TableFood.FOOD_INTRO));
        mImageFood = cursor.getString(cursor.getColumnIndex(DbContracts.TableFood.FOOD_URL_IMAGE));
        mIdPlace = cursor.getString(cursor.getColumnIndex(DbContracts.TableFood.FOOD_ID_PLACE));
    }


    @Override
    public String toString() {
        return "Food{" +
                "mIdFood='" + mIdFood + '\'' +
                ", mNameFood='" + mNameFood + '\'' +
                ", mIntroFood='" + mIntroFood + '\'' +
                ", mImageFood='" + mImageFood + '\'' +
                ", mIdPlace='" + mIdPlace + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdFood);
        dest.writeString(this.mNameFood);
        dest.writeString(this.mIntroFood);
        dest.writeString(this.mImageFood);
        dest.writeString(this.mIdPlace);
    }

    protected Food(Parcel in) {
        this.mIdFood = in.readString();
        this.mNameFood = in.readString();
        this.mIntroFood = in.readString();
        this.mImageFood = in.readString();
        this.mIdPlace = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}
