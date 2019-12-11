package com.test.jose.testcase8.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Purchases {
    @SerializedName("item_id")
    @Expose
    private int item_id;
    @SerializedName("item_category_id")
    @Expose
    private int item_category_id;
    @SerializedName("cost")
    @Expose
    private float cost;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_category_id() {
        return item_category_id;
    }

    public void setItem_category_id(int item_category_id) {
        this.item_category_id = item_category_id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }


}
