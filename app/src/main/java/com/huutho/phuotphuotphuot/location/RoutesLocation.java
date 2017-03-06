package com.huutho.phuotphuotphuot.location;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnc on 03/03/2017.
 */

public class RoutesLocation {

    /**
     * routes : [{"legs":[{"distance":{"text":"4,1 km","value":4118},"duration":{"text":"12 phút","value":709},"end_address":"514 Nguyễn Chí Thanh, Láng Hạ, Đống Đa, Hà Nội, Việt Nam","endLocation":{"lat":21.0157579,"lng":105.8054525},"start_address":"233 Tô Hiệu, Nghĩa Đô, Cầu Giấy, Hà Nội, Việt Nam","start_location":{"lat":21.0428654,"lng":105.7968491},"steps":[{"distance":{"text":"73 m","value":73},"duration":{"text":"1 phút","value":14},"endLocation":{"lat":21.0429014,"lng":105.797547},"htmlInstructions":"Đi về hướng <b>Đông<\/b> về phía <b>Ngõ 203 Hoàng Quốc Việt<\/b><div style=\"font-size:0.9em\">Băng qua Ngân Hàng Tmcp Đầu Tư &amp; Phát Triển Việt Nam (Bidv) (ở phía bên trái)<\/div>","polyline":{"points":"}|l_CimvdS@_AGkA"},"start_location":{"lat":21.0428654,"lng":105.7968491},"travel_mode":"DRIVING"},{"distance":{"text":"0,4 km","value":426},"duration":{"text":"1 phút","value":80},"endLocation":{"lat":21.0390703,"lng":105.7976063},"htmlInstructions":"Rẽ <b>phải<\/b> vào <b>Nguyễn Văn Huyên<\/b><div style=\"font-size:0.9em\">Băng qua Điểm đầu 12, 39 (ở bên phải cách 300&nbsp;m)<\/div>","maneuver":"turn-right","polyline":{"points":"c}l_CuqvdSxIB`@?pBEfDEfBC"},"start_location":{"lat":21.0429014,"lng":105.797547},"travel_mode":"DRIVING"},{"distance":{"text":"1,0 km","value":957},"duration":{"text":"3 phút","value":163},"endLocation":{"lat":21.0344527,"lng":105.8049703},"htmlInstructions":"Rẽ <b>trái<\/b> vào <b>Nguyễn Khánh Toàn<\/b><div style=\"font-size:0.9em\">Băng qua Cửa Hàng Nội Thất Ô Tô Quang Vinh (ở phía bên phải)<\/div>","maneuver":"turn-left","polyline":{"points":"eel_CarvdSP?A_@C_BAy@?o@@a@Fa@HYJW^q@Xa@PY|B{CT]nCsDRY|B}CDIdDeEvBcDjAwA"},"start_location":{"lat":21.0390703,"lng":105.7976063},"travel_mode":"DRIVING"},{"distance":{"text":"0,6 km","value":592},"duration":{"text":"2 phút","value":92},"endLocation":{"lat":21.0301642,"lng":105.8016095},"htmlInstructions":"Rẽ <b>phải<\/b> tại KocoPlus Co., Ltd. vào <b>Bưởi<\/b>","maneuver":"turn-right","polyline":{"points":"ihk_Ca`xdSjI~EbBlAvHjGRL|AvA"},"start_location":{"lat":21.0344527,"lng":105.8049703},"travel_mode":"DRIVING"},{"distance":{"text":"2,0 km","value":1977},"duration":{"text":"5 phút","value":325},"endLocation":{"lat":21.0155611,"lng":105.8048207},"htmlInstructions":"Tiếp tục vào <b>Láng<\/b><div style=\"font-size:0.9em\">Băng qua Shop Thế Giới Giày Om (ở phía bên phải)<\/div>","polyline":{"points":"omj_CakwdSVPfLpJZN|@r@jAz@hB~@tCxAZHj@L~ATV@T?TCZGRI`Aa@NQLO\\i@f@o@BCrA_Bl@u@lA{Al@o@`@a@h@c@h@[zDcBlAm@PKxDcBRIhF_Cd@SPKVOnAu@xA}@lA_Aj@g@hAcAt@w@"},"start_location":{"lat":21.0301642,"lng":105.8016095},"travel_mode":"DRIVING"},{"distance":{"text":"93 m","value":93},"duration":{"text":"1 phút","value":35},"endLocation":{"lat":21.0157579,"lng":105.8054525},"htmlInstructions":"Rẽ <b>trái<\/b> vào <b>Nguyễn Chí Thanh<\/b>/<b>Trần Duy Hưng<\/b><div style=\"font-size:0.9em\">Băng qua Shop Thời Trang Supia (ở phía bên phải)<\/div><div style=\"font-size:0.9em\">Điểm đến sẽ ở bên phải<\/div>","maneuver":"turn-left","polyline":{"points":"grg_Cc_xdSHINOJKQU{@aA"},"start_location":{"lat":21.0155611,"lng":105.8048207},"travel_mode":"DRIVING"}]}]}]
     * status : OK
     */
    @SerializedName("status")
    public String status;
    @SerializedName("routes")
    public List<RoutesBean> routes;


    public class RoutesBean {
        @SerializedName("legs")
        public List<LegsBean> legs;

        public class LegsBean {
            @SerializedName("distance")
            public DistanceBean distance;
            @SerializedName("duration")
            public DurationBean duration;
            @SerializedName("end_address")
            public String endAddress;
            @SerializedName("end_location")
            public EndLocationBean endLocation;
            @SerializedName("start_address")
            public String startAddress;
            @SerializedName("start_location")
            public StartLocationBean startLocation;
            @SerializedName("steps")
            public ArrayList<StepsBean> steps;

            public class DistanceBean {
                @SerializedName("text")
                public String text;
                @SerializedName("value")
                public int value;

                @Override
                public String toString() {
                    return "DistanceBean{" +
                            "text='" + text + '\'' +
                            ", value=" + value +
                            '}';
                }
            }

            public class DurationBean {
                @SerializedName("text")
                public String text;
                @SerializedName("value")
                public int value;

                @Override
                public String toString() {
                    return "DurationBean{" +
                            "text='" + text + '\'' +
                            ", value=" + value +
                            '}';
                }
            }

            public class EndLocationBean {
                @SerializedName("lat")
                public double lat;
                @SerializedName("lng")
                public double lng;

                @Override
                public String toString() {
                    return "EndLocationBean{" +
                            "lat=" + lat +
                            ", lng=" + lng +
                            '}';
                }
            }

            public class StartLocationBean {
                @SerializedName("lat")
                public double lat;
                @SerializedName("lng")
                public double lng;

                @Override
                public String toString() {
                    return "StartLocationBean{" +
                            "lat=" + lat +
                            ", lng=" + lng +
                            '}';
                }
            }

            public class StepsBean {
                @SerializedName("distance")
                public DistanceBeanX distance;
                @SerializedName("duration")
                public DurationBeanX duration;
                @SerializedName("end_location")
                public EndLocationBeanX endLocation;
                @SerializedName("html_instructions")
                public String htmlInstructions;
                @SerializedName("start_location")
                public StartLocationBeanX startLocation;
                @SerializedName("travel_mode")
                public String travelMode;
                @SerializedName("maneuver")
                public String maneuver;

                public class DistanceBeanX {
                    @SerializedName("text")
                    public String text;  @SerializedName("value")
                    public int value;

                    @Override
                    public String toString() {
                        return "DistanceBeanX{" +
                                "text='" + text + '\'' +
                                ", value=" + value +
                                '}';
                    }
                }

                public class DurationBeanX {
                    @SerializedName("text")
                    public String text;
                    @SerializedName("value")
                    public int value;

                    @Override
                    public String toString() {
                        return "DurationBeanX{" +
                                "text='" + text + '\'' +
                                ", value=" + value +
                                '}';
                    }
                }

                public class EndLocationBeanX {
                    @SerializedName("lat")
                    public double lat;
                    @SerializedName("lng")
                    public double lng;

                    @Override
                    public String toString() {
                        return "EndLocationBeanX{" +
                                "lat=" + lat +
                                ", lng=" + lng +
                                '}';
                    }
                }

                public class StartLocationBeanX {
                    @SerializedName("lat")
                    public double lat;
                    @SerializedName("lng")
                    public double lng;

                    @Override
                    public String toString() {
                        return "StartLocationBeanX{" +
                                "lat=" + lat +
                                ", lng=" + lng +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "StepsBean{" +
                            "distance=" + distance +
                            ", duration=" + duration +
                            ", endLocation=" + endLocation +
                            ", htmlInstructions='" + htmlInstructions + '\'' +
                            ", startLocation=" + startLocation +
                            ", travelMode='" + travelMode + '\'' +
                            ", maneuver='" + maneuver + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "LegsBean{" +
                        "distance=" + distance +
                        ", duration=" + duration +
                        ", endAddress='" + endAddress + '\'' +
                        ", endLocation=" + endLocation +
                        ", startAddress='" + startAddress + '\'' +
                        ", startLocation=" + startLocation +
                        ", steps=" + steps +
                        '}';
            }
        }
    }
}
