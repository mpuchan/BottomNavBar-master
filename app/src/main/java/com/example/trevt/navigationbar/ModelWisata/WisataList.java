package com.example.trevt.navigationbar.ModelWisata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WisataList {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("wisata")
    @Expose
    private List<Wisata> wisata = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Wisata> getWisata() {
        return wisata;
    }

    public void setWisata(List<Wisata> wisata) {
        this.wisata = wisata;
    }
}
