package com.wahyudin.win.drcomp.Model;

public class Masalah {
    public String kode;
    public String nama;
    public String saran;

    public Masalah() {
    }

    public Masalah(String kode, String nama, String saran) {
        this.kode = kode;
        this.nama = nama;
        this.saran = saran;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }
}
