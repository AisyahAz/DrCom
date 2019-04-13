package com.wahyudin.win.drcomp.Model;

public class Gejala {
    public String kode;
    public String nama;

    public Gejala() {
    }

    public Gejala(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
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
}
