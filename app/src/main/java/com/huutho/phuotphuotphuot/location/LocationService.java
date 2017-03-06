package com.huutho.phuotphuotphuot.location;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.huutho.phuotphuotphuot.utils.LogUtils;
import com.huutho.phuotphuotphuot.utils.SharePreferencesUtils;

/**
 * Created by HuuTho on 2/25/2017.
 */

public class LocationService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static final long INTERVAL = 10000;
    private static final long FAST_INTERVAL = 5000;
    private static final long SMALLESDISPLACEMENT = 1;

    private GoogleApiClient mGoogleApiClient;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createGoogleApiClient();

        getLastKnowLocation();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        connectGoogleApi();
        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        stopLocationUpdate();
        disConnectGoogleApi();
        super.onDestroy();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        startLocationUpdate();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        String strLocation = location.getLatitude() + "," + location.getLongitude();
        SharePreferencesUtils.getInstances().setLastKnowLocation(strLocation);

        Intent intent = new Intent();
        intent.setAction("onLocationChanged");
        intent.putExtra("onLocationChanged", strLocation);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /**
     * Google Api
     */

    private void createGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    private void connectGoogleApi() {
        mGoogleApiClient.connect();
    }

    private void disConnectGoogleApi() {
        mGoogleApiClient.disconnect();
    }


    /**
     * @return Location request
     */

    private LocationRequest setLocationRequest() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FAST_INTERVAL);
        mLocationRequest.setSmallestDisplacement(SMALLESDISPLACEMENT);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }


    /**
     * Location update
     */

    private void startLocationUpdate() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, setLocationRequest(), this);
    }

    private void stopLocationUpdate() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }


    /**
     * @return LastKnowLocation
     */

    private Location getLastKnowLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        Location lastKnowLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (lastKnowLocation != null) {
            LogUtils.e("lastKnowLocation", lastKnowLocation.getLatitude() + "," + lastKnowLocation.getLongitude());
            SharePreferencesUtils.getInstances().setLastKnowLocation(lastKnowLocation.getLatitude() + "," + lastKnowLocation.getLongitude());
            return lastKnowLocation;
        }
        return null;
    }
}
