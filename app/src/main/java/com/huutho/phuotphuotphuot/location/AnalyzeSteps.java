package com.huutho.phuotphuotphuot.location;

import com.google.android.gms.maps.model.LatLng;
import com.huutho.phuotphuotphuot.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by HuuTho on 3/3/2017.
 */

public class AnalyzeSteps {
    private ArrayList<RoutesLocation.RoutesBean.LegsBean.StepsBean> stepsBeen;
    private int sizeSteps ;
    public AnalyzeSteps(ArrayList<RoutesLocation.RoutesBean.LegsBean.StepsBean> stepsBeen) {
        this.stepsBeen = stepsBeen;
        sizeSteps = stepsBeen.size();

    }


    /**
     * - get ArrayList<latLng> from Steps
     * - Get all startPoint each step
     * - The lastPoint add endPoint
     * @return ArrayList<LatLng>
     */
    public ArrayList<LatLng> getLatLngs(){
        ArrayList<LatLng> latLngs = new ArrayList<>();
        for (int i = 0; i < sizeSteps; i++) {
            double lat = stepsBeen.get(i).startLocation.lat;
            double lng = stepsBeen.get(i).startLocation.lng;
            latLngs.add(new LatLng(lat,lng));

            double latEnd = stepsBeen.get(i).endLocation.lat;
            double lngEnd = stepsBeen.get(i).endLocation.lng;
            latLngs.add(new LatLng(latEnd,lngEnd));

            LogUtils.e("huutho",lat+","+lng );
            LogUtils.e("huutho",latEnd+","+lngEnd );
            LogUtils.e("huutho","--------------------");

        }

        return latLngs;
    }


}
