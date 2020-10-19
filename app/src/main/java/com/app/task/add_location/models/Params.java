package com.app.task.add_location.models;

import com.google.gson.annotations.SerializedName;

public class Params {
    @SerializedName("lat")
    private double lat;

    @SerializedName("long")
    private double lng;

    @SerializedName("building_name")
    private String buildingName;

    @SerializedName("apartment")
    private String apartment;

    @SerializedName("street_address")
    private String streetAddress;

    @SerializedName("area_id")
    private int areaId;

    @SerializedName("city_id")
    private int cityId;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("lang")
    private String lang;

    public Params(double lat, double lng, String buildingName,
                  String apartment, String streetAddress, int areaId, int cityId, String deviceId, String lang) {
        this.lat = lat;
        this.lng = lng;
        this.buildingName = buildingName;
        this.apartment = apartment;
        this.streetAddress = streetAddress;
        this.areaId = areaId;
        this.cityId = cityId;
        this.deviceId = deviceId;
        this.lang = lang;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
