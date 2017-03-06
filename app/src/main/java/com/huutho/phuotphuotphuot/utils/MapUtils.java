package com.huutho.phuotphuotphuot.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.location.RoutesLocation;

import java.util.ArrayList;

import butterknife.internal.Utils;

/**
 * Created by HuuTho on 2/28/2017.
 */

public class MapUtils {
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

    public static LatLng stringLatLngToLatLng(String latlng) {
        latlng = convertStandStrLocation(latlng);
        String lat = latlng.substring(0, latlng.indexOf(","));
        String lng = latlng.substring(latlng.indexOf(",") + 1);

        double mLat = Double.parseDouble(lat);
        double mLng = Double.parseDouble(lng);

        return new LatLng(mLat, mLng);
    }

    public static String convertStandStrLocation(String location) {
        return location.replaceAll(" ", "");
    }


    public static void addMarker(Context context,GoogleMap googleMap, String latLng, String title, int markerRes){
        LogUtils.e("huutho",latLng);
        LogUtils.e("huutho",stringLatLngToLatLng(latLng)+"");
        MarkerOptions options = new MarkerOptions();
        options.position(stringLatLngToLatLng(latLng));
        options.title(title);
        options.anchor(0.5f , 0.5f);
        googleMap.addMarker(options);
    }

    public static CameraUpdate setCameraUpdate(String latlng){
        LatLng latLng = stringLatLngToLatLng(latlng);
        CameraPosition cameraPosition = new CameraPosition(latLng,15,15,15);
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
        return update;
    }

}
