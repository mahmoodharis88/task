package com.app.task.add_location.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Addresses {


    private DataEntity data;
    private List<String> msg;
    private int code;
    private boolean status;


    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class DataEntity {
        @SerializedName("areas_of_cities")
        private ArrayList<AreasOfCitiesEntity> areasOfCities;

        private ArrayList<CitiesEntity> cities;

        @SerializedName("user_address")
        private ArrayList<UserAdressEntity> userAddress;

        public ArrayList<AreasOfCitiesEntity> getAreasOfCities() {
            return areasOfCities;
        }

        public void setAreasOfCities(ArrayList<AreasOfCitiesEntity> areasOfCities) {
            this.areasOfCities = areasOfCities;
        }

        public ArrayList<CitiesEntity> getCities() {
            return cities;
        }

        public void setCities(ArrayList<CitiesEntity> cities) {
            this.cities = cities;
        }

        public ArrayList<UserAdressEntity> getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(ArrayList<UserAdressEntity> userAddress) {
            this.userAddress = userAddress;
        }
    }

    public static class AreasOfCitiesEntity {
        @SerializedName("area_id")
        private int areaId;
        private int cityId;
        private int shippingCharges;
        private String name;

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public int getShippingCharges() {
            return shippingCharges;
        }

        public void setShippingCharges(int shippingCharges) {
            this.shippingCharges = shippingCharges;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class CitiesEntity {
        private String name;
        @SerializedName("city_id")
        private int cityId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }
    }

    public static class UserAdressEntity {
        private double lat;

        private int areaId;
        private int cityId;
        private String area;
        private String city;
        private String streetAddress;
        private String apartment;
        private String buildingName;
        private String email;
        private String deviceId;
        private int addressId;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getApartment() {
            return apartment;
        }

        public void setApartment(String apartment) {
            this.apartment = apartment;
        }

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }
    }
}
