package com.app.task.add_location.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Addresses {

    public DataBean data;
    public List<String> msg;
    public int code;
    public boolean status;

    public static class DataBean {
        @SerializedName("user_address")
        public ArrayList<UserAddressBean> userAddress;
    }


    public static class UserAddressBean {
        public double lat;
        @SerializedName("area_id")
        public int areaId;
        @SerializedName("city_id")
        public int cityId;
        public String area;
        public String city;
        public String streetAddress;
        public String apartment;
        public String buildingName;
        public String email;
        public String deviceId;
        public int addressId;
    }
}
