package com.huutho.phuotphuotphuot.location;

import java.util.List;

/**
 * Created by hnc on 03/03/2017.
 */

public class RoutesLocation {

    /**
     * routes : [{"legs":[{"distance":{"text":"4,1 km","value":4118},"duration":{"text":"12 phút","value":709},"end_address":"514 Nguyễn Chí Thanh, Láng Hạ, Đống Đa, Hà Nội, Việt Nam","end_location":{"lat":21.0157579,"lng":105.8054525},"start_address":"233 Tô Hiệu, Nghĩa Đô, Cầu Giấy, Hà Nội, Việt Nam","start_location":{"lat":21.0428654,"lng":105.7968491},"steps":[{"distance":{"text":"73 m","value":73},"duration":{"text":"1 phút","value":14},"end_location":{"lat":21.0429014,"lng":105.797547},"html_instructions":"Đi về hướng <b>Đông<\/b> về phía <b>Ngõ 203 Hoàng Quốc Việt<\/b><div style=\"font-size:0.9em\">Băng qua Ngân Hàng Tmcp Đầu Tư &amp; Phát Triển Việt Nam (Bidv) (ở phía bên trái)<\/div>","polyline":{"points":"}|l_CimvdS@_AGkA"},"start_location":{"lat":21.0428654,"lng":105.7968491},"travel_mode":"DRIVING"},{"distance":{"text":"0,4 km","value":426},"duration":{"text":"1 phút","value":80},"end_location":{"lat":21.0390703,"lng":105.7976063},"html_instructions":"Rẽ <b>phải<\/b> vào <b>Nguyễn Văn Huyên<\/b><div style=\"font-size:0.9em\">Băng qua Điểm đầu 12, 39 (ở bên phải cách 300&nbsp;m)<\/div>","maneuver":"turn-right","polyline":{"points":"c}l_CuqvdSxIB`@?pBEfDEfBC"},"start_location":{"lat":21.0429014,"lng":105.797547},"travel_mode":"DRIVING"},{"distance":{"text":"1,0 km","value":957},"duration":{"text":"3 phút","value":163},"end_location":{"lat":21.0344527,"lng":105.8049703},"html_instructions":"Rẽ <b>trái<\/b> vào <b>Nguyễn Khánh Toàn<\/b><div style=\"font-size:0.9em\">Băng qua Cửa Hàng Nội Thất Ô Tô Quang Vinh (ở phía bên phải)<\/div>","maneuver":"turn-left","polyline":{"points":"eel_CarvdSP?A_@C_BAy@?o@@a@Fa@HYJW^q@Xa@PY|B{CT]nCsDRY|B}CDIdDeEvBcDjAwA"},"start_location":{"lat":21.0390703,"lng":105.7976063},"travel_mode":"DRIVING"},{"distance":{"text":"0,6 km","value":592},"duration":{"text":"2 phút","value":92},"end_location":{"lat":21.0301642,"lng":105.8016095},"html_instructions":"Rẽ <b>phải<\/b> tại KocoPlus Co., Ltd. vào <b>Bưởi<\/b>","maneuver":"turn-right","polyline":{"points":"ihk_Ca`xdSjI~EbBlAvHjGRL|AvA"},"start_location":{"lat":21.0344527,"lng":105.8049703},"travel_mode":"DRIVING"},{"distance":{"text":"2,0 km","value":1977},"duration":{"text":"5 phút","value":325},"end_location":{"lat":21.0155611,"lng":105.8048207},"html_instructions":"Tiếp tục vào <b>Láng<\/b><div style=\"font-size:0.9em\">Băng qua Shop Thế Giới Giày Om (ở phía bên phải)<\/div>","polyline":{"points":"omj_CakwdSVPfLpJZN|@r@jAz@hB~@tCxAZHj@L~ATV@T?TCZGRI`Aa@NQLO\\i@f@o@BCrA_Bl@u@lA{Al@o@`@a@h@c@h@[zDcBlAm@PKxDcBRIhF_Cd@SPKVOnAu@xA}@lA_Aj@g@hAcAt@w@"},"start_location":{"lat":21.0301642,"lng":105.8016095},"travel_mode":"DRIVING"},{"distance":{"text":"93 m","value":93},"duration":{"text":"1 phút","value":35},"end_location":{"lat":21.0157579,"lng":105.8054525},"html_instructions":"Rẽ <b>trái<\/b> vào <b>Nguyễn Chí Thanh<\/b>/<b>Trần Duy Hưng<\/b><div style=\"font-size:0.9em\">Băng qua Shop Thời Trang Supia (ở phía bên phải)<\/div><div style=\"font-size:0.9em\">Điểm đến sẽ ở bên phải<\/div>","maneuver":"turn-left","polyline":{"points":"grg_Cc_xdSHINOJKQU{@aA"},"start_location":{"lat":21.0155611,"lng":105.8048207},"travel_mode":"DRIVING"}]}]}]
     * status : OK
     */

    public String status;

    public List<RoutesBean> routes;


    public class RoutesBean {
        public List<LegsBean> legs;

        public class LegsBean {

            public DistanceBean distance;
            public DurationBean duration;
            public String end_address;
            public EndLocationBean end_location;
            public String start_address;
            public StartLocationBean start_location;
            public List<StepsBean> steps;

            public class DistanceBean {
                public String text;
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
                public String text;
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
                public double lat;
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
                public double lat;
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

                public DistanceBeanX distance;
                public DurationBeanX duration;
                public EndLocationBeanX end_location;
                public String html_instructions;
                public StartLocationBeanX start_location;
                public String travel_mode;
                public String maneuver;

                public class DistanceBeanX {
                    public String text;
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
                    public String text;
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
                    public double lat;
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
                    public double lat;
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
                            ", end_location=" + end_location +
                            ", html_instructions='" + html_instructions + '\'' +
                            ", start_location=" + start_location +
                            ", travel_mode='" + travel_mode + '\'' +
                            ", maneuver='" + maneuver + '\'' +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "LegsBean{" +
                        "distance=" + distance +
                        ", duration=" + duration +
                        ", end_address='" + end_address + '\'' +
                        ", end_location=" + end_location +
                        ", start_address='" + start_address + '\'' +
                        ", start_location=" + start_location +
                        ", steps=" + steps +
                        '}';
            }
        }
    }
}
