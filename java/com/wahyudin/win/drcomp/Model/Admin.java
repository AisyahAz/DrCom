package com.wahyudin.win.drcomp.Model;

public class Admin {
    private String Nama;
    private String Password;
    private String Phone;


    public Admin() {
    }

    public Admin(String nama, String password) {
        Nama = nama;
        Password = password;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}

