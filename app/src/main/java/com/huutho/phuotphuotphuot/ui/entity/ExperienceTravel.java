package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class ExperienceTravel extends BaseEntity {
    private String mIdExp ;
    private String mNameExp ;
    private String mDescExp ;
    private String mImageExp ;

    public ExperienceTravel(String mIdExp, String mNameExp, String mDescExp, String mImageExp) {
        this.mIdExp = mIdExp;
        this.mNameExp = mNameExp;
        this.mDescExp = mDescExp;
        this.mImageExp = mImageExp;
    }
    public ExperienceTravel(Cursor cursor){
        mIdExp = cursor.getString(cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_ID));
        mNameExp = cursor.getString(cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_NAME));
        mDescExp = cursor.getString(cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_DESC));
        mImageExp = cursor.getString(cursor.getColumnIndex(DbContracts.TableExperience.EXPERIENCE_URL_IMAGE));
    }

    public String getmIdExp() {
        return mIdExp;
    }

    public void setmIdExp(String mIdExp) {
        this.mIdExp = mIdExp;
    }

    public String getmNameExp() {
        return mNameExp;
    }

    public void setmNameExp(String mNameExp) {
        this.mNameExp = mNameExp;
    }

    public String getmDescExp() {
        return mDescExp;
    }

    public void setmDescExp(String mDescExp) {
        this.mDescExp = mDescExp;
    }

    public String getmImageExp() {
        return mImageExp;
    }

    public void setmImageExp(String mImageExp) {
        this.mImageExp = mImageExp;
    }

    @Override
    public String toString() {
        return "ExperienceTravel{" +
                "mIdExp='" + mIdExp + '\'' +
                ", mNameExp='" + mNameExp + '\'' +
                ", mDescExp='" + mDescExp + '\'' +
                ", mImageExp='" + mImageExp + '\'' +
                '}';
    }
}
