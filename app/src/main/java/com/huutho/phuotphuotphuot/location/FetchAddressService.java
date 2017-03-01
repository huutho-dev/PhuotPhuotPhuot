package com.huutho.phuotphuotphuot.location;

import android.app.IntentService;
import android.content.Intent;
import android.location.Geocoder;

/**
 * Created by HuuTho on 2/26/2017.
 */

public class FetchAddressService extends IntentService {
    private static final int SUCCESS_RESULT =1 ;
    private static final int FAILURE_RESULT = 0 ;
    private Geocoder mGeocoder ;

    public FetchAddressService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
