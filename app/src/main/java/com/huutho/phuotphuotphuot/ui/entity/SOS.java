package com.huutho.phuotphuotphuot.ui.entity;

import android.database.Cursor;
import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;
import com.huutho.phuotphuotphuot.utils.database.DbContracts;

/**
 * Created by hnc on 31/03/2017.
 */

public class SOS extends BaseEntity {
    public String id;
    public String idCity;
    public String nameCity;
    public String policePhone;
    public String hospitalPhone;
    public String rescuePhone;

    public SOS(Builder builder) {
        this.id = builder.id;
        this.idCity = builder.idCity;
        this.nameCity = builder.nameCity;
        this.policePhone = builder.policePhone;
        this.hospitalPhone = builder.hospitalPhone;
        this.rescuePhone = builder.rescuePhone;
    }

    public SOS(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(DbContracts.TableSOS.SOS_ID));
        idCity = cursor.getString(cursor.getColumnIndex(DbContracts.TableSOS.SOS_ID_CITY));
        nameCity = cursor.getString(cursor.getColumnIndex(DbContracts.TableSOS.SOS_NAME_CITY));
        policePhone = cursor.getString(cursor.getColumnIndex(DbContracts.TableSOS.SOS_POLICE_PHONE));
        hospitalPhone = cursor.getString(cursor.getColumnIndex(DbContracts.TableSOS.SOS_HOSPITAL_PHONE));
        rescuePhone = cursor.getString(cursor.getColumnIndex(DbContracts.TableSOS.SOS_RESCUE_PHONE));
    }


    public class Builder {
        public String id;
        public String idCity;
        public String nameCity;
        public String policePhone;
        public String hospitalPhone;
        public String rescuePhone;

        public Builder() {

        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setIdCity(String id) {
            this.idCity = id;
            return this;
        }

        public Builder setNameCity(String name) {
            this.nameCity = name;
            return this;
        }

        public Builder setPolicePhone(String phone) {
            this.policePhone = phone;
            return this;
        }

        public Builder setHospitalPhone(String phone) {
            this.hospitalPhone = phone;
            return this;
        }

        public Builder setRescuePhone(String phone) {
            this.rescuePhone = phone;
            return this;
        }

        public SOS build() {
            return new SOS(this);
        }

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.idCity);
        dest.writeString(this.nameCity);
        dest.writeString(this.policePhone);
        dest.writeString(this.hospitalPhone);
        dest.writeString(this.rescuePhone);
    }

    protected SOS(Parcel in) {
        this.id = in.readString();
        this.idCity = in.readString();
        this.nameCity = in.readString();
        this.policePhone = in.readString();
        this.hospitalPhone = in.readString();
        this.rescuePhone = in.readString();
    }

    public static final Creator<SOS> CREATOR = new Creator<SOS>() {
        @Override
        public SOS createFromParcel(Parcel source) {
            return new SOS(source);
        }

        @Override
        public SOS[] newArray(int size) {
            return new SOS[size];
        }
    };
}
