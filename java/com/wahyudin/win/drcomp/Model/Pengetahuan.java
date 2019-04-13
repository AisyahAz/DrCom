package com.wahyudin.win.drcomp.Model;

public class Pengetahuan {
    public String answer_n;
    public String answer_y;
    public String gejala;
    public String pertanyaan;

    public Pengetahuan() {
    }

    public Pengetahuan(String answer_n, String answer_y, String gejala, String pertanyaan) {
        this.answer_n = answer_n;
        this.answer_y = answer_y;
        this.gejala = gejala;
        this.pertanyaan = pertanyaan;
    }

    public String getAnswer_n() {
        return answer_n;
    }

    public void setAnswer_n(String answer_n) {
        this.answer_n = answer_n;
    }

    public String getAnswer_y() {
        return answer_y;
    }

    public void setAnswer_y(String answer_y) {
        this.answer_y = answer_y;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }
}
