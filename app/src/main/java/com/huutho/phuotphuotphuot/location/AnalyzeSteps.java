package com.huutho.phuotphuotphuot.location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

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
           latLngs.addAll(decodePoly(stepsBeen.get(i).points.points));
        }
        return latLngs;
    }


    // reference : http://wptrafficanalyzer.in/blog/route-between-two-locations-with-waypoints-in-google-map-android-api-v2/

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> arrPoly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            arrPoly.add(p);
        }

        return arrPoly;
    }

}
