package com.example.trevt.navigationbar.isidata;

public class Datawisata {
    String namawisata;
    String deskripsi;
    int gambar ;

    public Datawisata(String namawisata,
                      String deskripsi,
                      int gambar)
    {
        this.namawisata=namawisata;
        this.deskripsi=deskripsi;
        this.gambar=gambar;
    }

    public String getNamawisata() {
        return namawisata;
    }

    public void setNamawisata(String namawisata) {
        this.namawisata = namawisata;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
