package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class Zone extends BaseEntity {
    private String mIdZone ;
    private String mNameZone;
    private String mNameZoneClean ;

    public Zone(String mIdZone, String mNameZone, String mNameZoneClean) {
        this.mIdZone = mIdZone;
        this.mNameZone = mNameZone;
        this.mNameZoneClean = mNameZoneClean;
    }
    public Zone(Cursor cursor){
        mIdZone =cursor.getString(cursor.getColumnIndex(DbContracts.TableZone.ZONE_ID));
        mNameZone =cursor.getString(cursor.getColumnIndex(DbContracts.TableZone.ZONE_NAME));
        mNameZoneClean =cursor.getString(cursor.getColumnIndex(DbContracts.TableZone.ZONE_NAME_CLEAN));
    }

    public String getmIdZone() {
        return mIdZone;
    }

    public void setmIdZone(String mIdZone) {
        this.mIdZone = mIdZone;
    }

    public String getmNameZone() {
        return mNameZone;
    }

    public void setmNameZone(String mNameZone) {
        this.mNameZone = mNameZone;
    }

    public String getmNameZoneClean() {
        return mNameZoneClean;
    }

    public void setmNameZoneClean(String mNameZoneClean) {
        this.mNameZoneClean = mNameZoneClean;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "mIdZone='" + mIdZone + '\'' +
                ", mNameZone='" + mNameZone + '\'' +
                ", mNameZoneClean='" + mNameZoneClean + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdZone);
        dest.writeString(this.mNameZone);
        dest.writeString(this.mNameZoneClean);
    }

    protected Zone(Parcel in) {
        this.mIdZone = in.readString();
        this.mNameZone = in.readString();
        this.mNameZoneClean = in.readString();
    }

    public static final Creator<Zone> CREATOR = new Creator<Zone>() {
        @Override
        public Zone createFromParcel(Parcel source) {
            return new Zone(source);
        }

        @Override
        public Zone[] newArray(int size) {
            return new Zone[size];
        }
    };
}
