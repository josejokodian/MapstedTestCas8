package com.test.jose.testcase8.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class Session_Infos {

    @SerializedName("building_id")
    @Expose
    private String building_id;

    @SerializedName("purchases")
    @Expose
    private Purchases purchases;

    @Override
    public String toString() {
        return "Session_Infos{" +
                "building_id='" + building_id + '\'' +
                ", purchases=" + purchases +
                '}';
    }

    public Purchases getPurchases() {
        return purchases;
    }

    public void setPurchases(Purchases purchases) {
        this.purchases = purchases;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }




}
