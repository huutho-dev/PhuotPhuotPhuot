package com.huutho.phuotphuotphuot.app.retrofit;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by HuuTho on 2/25/2017.
 */

public interface ApiRequest {

    /**
     * @param latlngOrigin     : latlng start point
     * @param latlngDesination : latlng end point
     * @param mode             : driving (default) , walking , bicycling , transit
     * @param alternatives     : True - False ; If set to true, specifies that the Directions service may provide more than one route alternative in the response.
     * @param language         : en, fr, ja,vi ; The language in which to return results.
     */

    @GET("/maps/api/directions/json?")
     void getDirection(
            @Query("origin") String latlngOrigin,
            @Query("destination ") String latlngDesination,
            @Query("mode") String mode,
            @Query("alternatives") String alternatives,
            @Query("language") String language,
            @Query("key") String key
    );

    @GET("/maps/api/geocode/json?")
    Call<LocationEntity> getGeocoder(
            @Query("latlng")String latlng,
            @Query("language") String language ,
            @Query("key") String key
    );
}
