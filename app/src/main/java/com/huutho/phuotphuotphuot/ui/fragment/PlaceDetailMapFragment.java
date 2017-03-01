package com.huutho.phuotphuotphuot.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huutho.phuotphuotphuot.R;
import com.huutho.phuotphuotphuot.base.fragment.BaseFragment;
import com.huutho.phuotphuotphuot.base.fragment.MapFragment;
import com.huutho.phuotphuotphuot.ui.entity.Place;
import com.huutho.phuotphuotphuot.utils.LocationUtils;
import com.huutho.phuotphuotphuot.utils.LogUtils;
import com.huutho.phuotphuotphuot.utils.SharePreferencesUtils;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by HuuTho on 2/16/2017.
 */

public class PlaceDetailMapFragment extends MapFragment implements OnMapReadyCallback {
    MapView mGoogleMap;

    private GoogleMap mMap;

    public static PlaceDetailMapFragment newInstance(Place place) {
        Bundle args = new Bundle();
        PlaceDetailMapFragment fragment = new PlaceDetailMapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setContentLayout() {
        return R.layout.fragment_place_detail_map;
    }

    @Override
    public void bindViewToFragment() {
        mGoogleMap = (MapView) getView().findViewById(R.id.map);
        getHandle().post(new Runnable() {
            @Override
            public void run() {
                mGoogleMap.onCreate(null);
                mGoogleMap.onResume();
                mGoogleMap.getMapAsync(PlaceDetailMapFragment.this);
            }
        });



    }

    @Override
    public void fragmentReady() {
    }

    @Override
    public void onLocationChange(String location) {
        if (mMap != null){
            LatLng myLocation = LocationUtils.stringLatLngToLatLng(location);
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_red);
            MarkerOptions options = new MarkerOptions();
            options.position(myLocation);
            options.snippet("U are here");
            options.title("This");
            options.icon(null);
            mMap.addMarker(options);

            CameraPosition cameraPosition = new CameraPosition(myLocation,15,15,15);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            mMap.animateCamera(cameraUpdate);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MapsInitializer.initialize(mContext);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

//        LatLng myLocation = LocationUtils.stringLatLngToLatLng(SharePreferencesUtils.getInstances().getLastKnowLocation());
//        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_red);
//        MarkerOptions options = new MarkerOptions();
//        options.position(myLocation);
//        options.snippet("U are here");
//        options.title("This");
//        options.icon(bitmapDescriptor);
//        mMap.addMarker(options);
//
//        CameraPosition cameraPosition = new CameraPosition(myLocation,15,15,15);
//        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
//        mMap.animateCamera(cameraUpdate);

    }


    @Override
    public void onStop() {
        super.onStop();
        mGoogleMap.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mGoogleMap.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mGoogleMap.onDestroy();
    }
}
