package com.example.trevt.navigationbar.ModelWisata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wisata {
    @SerializedName("id_wisata")
    @Expose
    private Integer idWisata;
    @SerializedName("id_pengelola")
    @Expose
    private Integer idPengelola;
    @SerializedName("NamaWisata")
    @Expose
    private String namaWisata;
    @SerializedName("FotoWisata")
    @Expose
    private String fotoWisata;
    @SerializedName("Photo360")
    @Expose
    private String photo360;
    @SerializedName("AlamatWisata")
    @Expose
    private String alamatWisata;

    public Integer getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(Integer idWisata) {
        this.idWisata = idWisata;
    }

    public Integer getIdPengelola() {
        return idPengelola;
    }

    public void setIdPengelola(Integer idPengelola) {
        this.idPengelola = idPengelola;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getFotoWisata() {
        return fotoWisata;
    }

    public void setFotoWisata(String fotoWisata) {
        this.fotoWisata = fotoWisata;
    }


    public String getPhoto360() {
        return photo360;
    }

    public void setPhoto360(String fotoWisata) {
        this.photo360 = photo360;
    }



    public String getAlamatWisata() {
        return alamatWisata;
    }

    public void setAlamatWisata(String alamatWisata) {
        this.alamatWisata = alamatWisata;
    }

}
