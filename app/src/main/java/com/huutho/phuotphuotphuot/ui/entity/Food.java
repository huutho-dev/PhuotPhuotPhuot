package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class Food extends BaseEntity {
    private String mIdFood;
    private String mNameFood ;
    private String mIntroFood;
    private String mImageFood;
    private String mIdPlace;

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

    public String getmIdFood() {
        return mIdFood;
    }

    public void setmIdFood(String mIdFood) {
        this.mIdFood = mIdFood;
    }

    public String getmNameFood() {
        return mNameFood;
    }

    public void setmNameFood(String mNameFood) {
        this.mNameFood = mNameFood;
    }

    public String getmIntroFood() {
        return mIntroFood;
    }

    public void setmIntroFood(String mIntroFood) {
        this.mIntroFood = mIntroFood;
    }

    public String getmImageFood() {
        return mImageFood;
    }

    public void setmImageFood(String mImageFood) {
        this.mImageFood = mImageFood;
    }

    public String getmIdPlace() {
        return mIdPlace;
    }

    public void setmIdPlace(String mIdPlace) {
        this.mIdPlace = mIdPlace;
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
}
