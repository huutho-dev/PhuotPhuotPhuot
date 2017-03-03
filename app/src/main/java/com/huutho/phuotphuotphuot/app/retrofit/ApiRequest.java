package com.huutho.phuotphuotphuot.app.retrofit;

import com.huutho.phuotphuotphuot.location.RoutesLocation;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by HuuTho on 2/25/2017.
 */

public interface ApiRequest {
        public static final String MODE_DRIVING ="driving";
        public static final String MODE_WALKING ="walking";
        public static final String MODE_BICYCLING ="bicycling";
        public static final String MODE_TRANSIT ="transit";
        public static final String LANGUAGE ="vi";



    /**
     * @param latlngOrigin     : latlng start point
     * @param latlngDesination : latlng end point
     * @param mode             : driving (default) , walking , bicycling , transit
     * @param language         : en, fr, ja,vi ; The language in which to return results.
     */

    @GET("/maps/api/directions/json?")
     Call<RoutesLocation> getDirection(
            @Query("origin") String latlngOrigin,
            @Query("destination") String latlngDesination
    );

    @GET("/maps/api/geocode/json?")
    Call<LocationEntity> getGeocoder(
            @Query("latlng")String latlng,
            @Query("language") String language ,
            @Query("key") String key
    );
}
