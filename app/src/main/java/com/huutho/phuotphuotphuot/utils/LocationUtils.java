package com.huutho.phuotphuotphuot.utils;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by HuuTho on 2/28/2017.
 */

public class LocationUtils {
    public static String latLngToString(LatLng latLng) {
        StringBuilder builder = new StringBuilder();
        double lat = latLng.latitude;
        double lng = latLng.longitude;
        return builder.append(lat).append(",").append(lng).toString();
    }

    public static String locationToString(Location location) {
        StringBuilder builder = new StringBuilder();
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        return builder.append(lat).append(",").append(lng).toString();
    }

    public static Location stringLocationToLocation(String location) {
        String lat = location.substring(0, location.indexOf(","));
        String lng = location.substring(location.indexOf(",") + 1);
        double mLat = Double.parseDouble(lat);
        double mLng = Double.parseDouble(lng);
        Location mLocation = new Location("");
        mLocation.setLatitude(mLat);
        mLocation.setLongitude(mLng);
        return mLocation;
    }

    public  static LatLng stringLatLngToLatLng(String latlng){

        String lat = latlng.substring(0, latlng.indexOf(","));
        String lng = latlng.substring(latlng.indexOf(",") + 1);

        double mLat = Double.parseDouble(lat);
        double mLng = Double.parseDouble(lng);

        return new LatLng(mLat,mLng);
    }
}
