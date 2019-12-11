package com.test.jose.testcase8.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnalyticsDataList {
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("market_name")
    @Expose
    private String market_name;
    @SerializedName("codename")
    @Expose
    private String codename;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("usagestatictics")
    @Expose
    private Usagestatictics usagestatictics;

    @Override
    public String toString() {
        return "AnalyticsDataList{" +
                "manufacturer='" + manufacturer + '\'' +
                ", market_name='" + market_name + '\'' +
                ", codename='" + codename + '\'' +
                ", model='" + model + '\'' +
                ", usagestatictics=" + usagestatictics +
                '}';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Usagestatictics getUsagestatictics() {
        return usagestatictics;
    }

    public void setUsagestatictics(Usagestatictics usagestatictics) {
        this.usagestatictics = usagestatictics;
    }


}
