package com.test.jose.testcase8.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by praka on 12/24/2017.
 */

public class DatasetsList {
    @SerializedName("building_id")
    private Integer building_id;
    @SerializedName("building_name")
    private String building_name;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;

    public DatasetsList(Integer building_id, String building_name, String city, String state, String country) {
        this.building_id = building_id;
        this.building_name = building_name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Integer getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Integer building_id) {
        this.building_id = building_id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
