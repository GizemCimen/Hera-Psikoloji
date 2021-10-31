package com.example.psikolog.veritabani;

public class hastalar {


    private String hasta_id;
    private String hasta_adi_soyadi;
    private String hasta_sifre;
    private String hasta_sikayet;

    public hastalar() {
    }

    public hastalar(String hasta_id, String hasta_adi_soyadi, String hasta_sifre,String hasta_sikayet) {
        this.hasta_id=hasta_id;
        this.hasta_adi_soyadi=hasta_adi_soyadi;
        this.hasta_sifre=hasta_sifre;
        this.hasta_sikayet=hasta_sikayet;

    }
    public String gethasta_id() {
        return hasta_id;
    }
    public void sethasta_id(String hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String gethasta_adi_soyadi() {
        return hasta_adi_soyadi;
    }
    public void sethasta_adi_soyadi(String hasta_adi_soyadi) {this.hasta_adi_soyadi = hasta_adi_soyadi;}

    public String gethasta_sifre() {
        return hasta_sifre;
    }
    public void sethasta_sifre(String hasta_sifre) {
        this.hasta_sifre = hasta_sifre;
    }

    public String gethasta_sikayet() {return hasta_sikayet;}
    public void  sethasta_sikayet(String hasta_sikayet) {this.hasta_sikayet = hasta_sikayet;}
}
