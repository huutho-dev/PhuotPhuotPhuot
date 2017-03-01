package com.huutho.phuotphuotphuot.app.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HuuTho on 2/26/2017.
 */

public class LocationEntity  {

    @SerializedName("status")
    public String status ;

    @SerializedName("lat")
    public String lat ;

    @SerializedName("lng")
    public String lng ;

    @Override
    public String toString() {
        return "LocationEntity{" +
                "status='" + status + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
