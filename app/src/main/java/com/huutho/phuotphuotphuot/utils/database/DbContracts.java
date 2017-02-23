package com.huutho.phuotphuotphuot.utils.database;

/**
 * Created by HuuTho on 2/22/2017.
 */

public final class DbContracts {
    public static class TablePlace {
        public static final String TABLE_PLACE = "DiaDanh";
        public static final String PLACE_ID_PLACE = "id_dia_danh";
        public static final String PLACE_ID_CITY = "id_thanh_pho";
        public static final String PLACE_ID_ZONE = "id_vung_mien";
        public static final String PLACE_NAME_PLACE = "ten_dia_danh";
        public static final String PLACE_LATLNG = "lat_long";
        public static final String PLACE_FAVORITE = "yeu_thich";
        public static final String PLACE_INTRO = "gioi_thieu";
        public static final String PLACE_URL_IMAGE = "url_hinh_anh";
        public static final String PLACE_NAME_CITY = "ten_thanh_pho";
    }

    public static class TableRested {
        public static final String TABLE_RESTED = "DiaDiemNghiNgoi";
        public static final String RESTED_ID = "id_dia_diem_nghi_ngoi";
        public static final String RESTED_NAME = "ten_dia_diem_nghi_ngoi";
        public static final String RESTED_LATLNG = "lat_long_dia_diem_nghi_ngoi";
        public static final String RESTED_URL_IMAGE = "hinh_anh_dia_diem_nghi_ngoi";
        public static final String RESTED_INTRO = "gioi_thieu_dia_diem_nghi_ngoi";
        public static final String RESTED_PHONE_NUMBER = "sdt_dia_diem_nghi_ngoi";
        public static final String RESTED_PRICE = "gia_tien_dia_diem_nghi_ngoi";
        public static final String RESTED_ID_PLACE = "id_dia_danh";
    }

    public static class TableFood {
        public static final String TABLE_FOOD = "DoAn";
        public static final String FOOD_ID = "id_do_an";
        public static final String FOOD_NAME = "ten_do_an";
        public static final String FOOD_INTRO = "gioi_thieu_do_an";
        public static final String FOOD_URL_IMAGE = "hinh_anh_do_an";
        public static final String FOOD_ID_PLACE = "id_dia_danh";
    }

    public static class TableImagePlace {
        public static final String TABLE_IMAGE_PLACE = "HinhAnhDiaDanh";
        public static final String IMAGE_PLACE_ID = "id_hinh_anh_dia_danh";
        public static final String IMAGE_PLACE_ID_PLACE = "id_dia_danh";
        public static final String IMAGE_PLACE_URL_IMAGE = "link_url_hinh_anh";
    }

    public static class TableExperience {
        public static final String TABLE_EXPERIENCE = "KinhNghiemPhuot";
        public static final String EXPERIENCE_ID = "id_kinh_nghiem";
        public static final String EXPERIENCE_NAME = "ten_kinh_nghiem";
        public static final String EXPERIENCE_DESC = "mo_ta_kinh_nghiem";
        public static final String EXPERIENCE_URL_IMAGE = "hinh_anh_kinh_nghiem";
    }

    public static class TableCity {
        public static final String TABLE_CITY = "ThanhPho";
        public static final String CITY_ID = "id_thanh_pho";
        public static final String CITY_NAME = "ten_thanh_pho";
        public static final String CITY_ID_ZONE = "vung_mien";
        public static final String CITY_NAME_CLEAN = "ten_thanh_pho_clean";
    }

    public static class TableZone {
        public static final String TABLE_ZONE = "VungMien";
        public static final String ZONE_ID = "id_vung_mien";
        public static final String ZONE_NAME = "ten_vung_mien";
        public static final String ZONE_NAME_CLEAN = "ten_vung_mien_clean";
    }
}
