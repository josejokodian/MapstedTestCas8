package com.test.jose.testcase8.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Usagestatictics {

    public Session_Infos getSession_infos() {
        return session_infos;
    }

    public void setSession_infos(Session_Infos session_infos) {
        this.session_infos = session_infos;
    }

    @SerializedName("session_infos")
    @Expose
    private Session_Infos session_infos;

    @Override
    public String toString() {
        return "Usagestatictics{" +
                "session_infos=" + session_infos +
                '}';
    }




}
