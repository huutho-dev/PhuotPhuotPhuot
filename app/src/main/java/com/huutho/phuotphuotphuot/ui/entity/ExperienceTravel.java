package com.huutho.phuotphuotphuot.ui.entity;

import android.os.Parcel;

import com.huutho.phuotphuotphuot.base.entity.BaseEntity;

/**
 * Created by nguyenhuutho on 2/3/17.
 */

public class ExperienceTravel extends BaseEntity {
    public String mIdExp;
    public String mNameExp;
    public String mDescExp;
    public String mImageExp;

    public ExperienceTravel() {

    }

    public ExperienceTravel(Builder builder) {
        mIdExp = builder.mIdExp;
        mNameExp = builder.mNameExp;
        mDescExp = builder.mDescExp;
        mImageExp = builder.mImageExp;
    }

    public static class Builder {
        public String mIdExp;
        public String mNameExp;
        public String mDescExp;
        public String mImageExp;

        public Builder() {

        }

        public Builder setId(String id) {
            this.mIdExp = id;
            return this;
        }

        public Builder setName(String name) {
            this.mNameExp = name;
            return this;
        }

        public Builder setDesc(String desc) {
            this.mDescExp = desc;
            return this;
        }

        public Builder setImage(String image) {
            this.mImageExp = image;
            return this;
        }

        public ExperienceTravel build() {
            return new ExperienceTravel(this);
        }
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mIdExp);
        dest.writeString(this.mNameExp);
        dest.writeString(this.mDescExp);
        dest.writeString(this.mImageExp);
    }

    protected ExperienceTravel(Parcel in) {
        this.mIdExp = in.readString();
        this.mNameExp = in.readString();
        this.mDescExp = in.readString();
        this.mImageExp = in.readString();
    }

    public static final Creator<ExperienceTravel> CREATOR = new Creator<ExperienceTravel>() {
        @Override
        public ExperienceTravel createFromParcel(Parcel source) {
            return new ExperienceTravel(source);
        }

        @Override
        public ExperienceTravel[] newArray(int size) {
            return new ExperienceTravel[size];
        }
    };
}
