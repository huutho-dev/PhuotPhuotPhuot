package com.huutho.phuotphuotphuot.ui.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HuuTho on 2/27/2017.
 */

public class IntroItem implements Parcelable {
    public String title;
    public int resId ;

    public IntroItem(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.resId);
    }

    protected IntroItem(Parcel in) {
        this.title = in.readString();
        this.resId = in.readInt();
    }

    public static final Parcelable.Creator<IntroItem> CREATOR = new Parcelable.Creator<IntroItem>() {
        @Override
        public IntroItem createFromParcel(Parcel source) {
            return new IntroItem(source);
        }

        @Override
        public IntroItem[] newArray(int size) {
            return new IntroItem[size];
        }
    };
}


