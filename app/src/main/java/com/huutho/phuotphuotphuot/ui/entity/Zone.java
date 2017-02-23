package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;

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
}
