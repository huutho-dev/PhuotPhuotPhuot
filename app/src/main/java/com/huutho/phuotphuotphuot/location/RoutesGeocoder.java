package com.huutho.phuotphuotphuot.location;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;
import com.huutho.phuotphuotphuot.base.entity.BaseEntity;

import java.util.List;

/**
 * Created by hnc on 03/03/2017.
 */

public class RoutesGeocoder extends BaseEntity {


    @SerializedName("distance")
    public Distance distance;

    @SerializedName("duration")
    public Duration duration;

    @SerializedName("end_address")
    public String endAddress;

    @SerializedName("end_location")
    public LatLng endLocation;

    @SerializedName("start_address")
    public String startAddress;

    @SerializedName("start_location")
    public LatLng startLocation;

    @SerializedName("steps")
    public List<Step> steps;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    @Override
    public String toString() {
        return "RoutesGeocoder{" +
                "distance=" + distance +
                ", duration=" + duration +
                ", endAddress='" + endAddress + '\'' +
                ", endLocation=" + endLocation +
                ", startAddress='" + startAddress + '\'' +
                ", startLocation=" + startLocation +
                ", steps=" + steps +
                '}';
    }

    public class Distance {
        @SerializedName("text")
        public String text;
        @SerializedName("value")
        public String value;

        @Override
        public String toString() {
            return "Distance{" +
                    "text='" + text + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public class Duration {
        @SerializedName("text")
        public String text;
        @SerializedName("value")
        public String value;

        @Override
        public String toString() {
            return "Duration{" +
                    "text='" + text + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private class LatLng {
        @SerializedName("lat")
        public String lat;
        @SerializedName("lng")
        public String lng;

        @Override
        public String toString() {
            return "LatLng{" +
                    "lat='" + lat + '\'' +
                    ", lng='" + lng + '\'' +
                    '}';
        }
    }

    private class Step {
        @SerializedName("distance")
        public Distance distance;

        @SerializedName("duration")
        public Duration duration;

        @SerializedName("end_location")
        public LatLng endLocation;

        @SerializedName("html_instructions")
        public String instructions;

        @SerializedName("points")
        public String polyLinePoint;

        @SerializedName("start_location")
        public LatLng startLocation;

        @SerializedName("travel_mode")
        public String travelMode;

        @Override
        public String toString() {
            return "Step{" +
                    "distance=" + distance +
                    ", duration=" + duration +
                    ", endLocation=" + endLocation +
                    ", instructions='" + instructions + '\'' +
                    ", polyLinePoint='" + polyLinePoint + '\'' +
                    ", startLocation=" + startLocation +
                    ", travelMode='" + travelMode + '\'' +
                    '}';
        }
    }
}
