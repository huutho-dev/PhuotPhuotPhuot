package com.huutho.phuotphuotphuot.app.retrofit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by HuuTho on 2/25/2017.
 */

//https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood4&key=YOUR_API_KEY

public class ApiRequestHelper {

    private static final String MAP_BASE_URL = "https://maps.googleapis.com";

    public Retrofit getMapApiRequest() {
        return  new Retrofit.Builder()
                .baseUrl(MAP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
