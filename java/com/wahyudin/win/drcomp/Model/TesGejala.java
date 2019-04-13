package com.wahyudin.win.drcomp.Model;

public class TesGejala {
    private String kode;
    private String nama;

    public TesGejala() {
    }

    public TesGejala(String kode, String nama) {
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
