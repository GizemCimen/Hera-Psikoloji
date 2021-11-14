package com.example.psikolog_gizem.veritabani;



public class doktorlar {
    private int doktor_id;
    private String doktor_adi_soyadi;
    private String doktor_e_posta;
    private String doktor_sifre;
    private String doktor_hizmetler;

    public doktorlar() {
    }

    public doktorlar(int doktor_id){
        this.doktor_id=doktor_id;
    }

    public doktorlar(String doktor_e_posta,String doktor_sifre){
        this.doktor_e_posta=doktor_e_posta;
        this.doktor_sifre=doktor_sifre;
    }

    public doktorlar(int doktor_id, String doktor_adi_soyadi, String doktor_e_posta,String doktor_sifre,String doktor_hizmetler) {
        this.doktor_id=doktor_id;
        this.doktor_adi_soyadi=doktor_adi_soyadi;
        this.doktor_e_posta=doktor_e_posta;
        this.doktor_sifre=doktor_sifre;
        this.doktor_hizmetler=doktor_hizmetler;

    }
    public doktorlar(String doktor_adi_soyadi, String doktor_e_posta,String doktor_sifre,String doktor_hizmetler) {
        this.doktor_adi_soyadi=doktor_adi_soyadi;
        this.doktor_e_posta=doktor_e_posta;
        this.doktor_sifre=doktor_sifre;
        this.doktor_hizmetler=doktor_hizmetler;

    }


    public int getdoktor_id() {
        return doktor_id;
    }
    public void setdoktor_id(int doktor_id) {
        this.doktor_id = doktor_id;
    }

    public String getdoktor_adi_soyadi() {
        return doktor_adi_soyadi;
    }
    public void setdoktor_adi_soyadi(String doktor_adi_soyadi) {this.doktor_adi_soyadi = doktor_adi_soyadi;}

    public String getdoktor_sifre() {
        return doktor_sifre;
    }
    public void setdoktor_sifre(String doktor_sifre) {
        this.doktor_sifre = doktor_sifre;
    }

    public String getdoktor_hizmetler() {return doktor_hizmetler;}
    public void  setdoktor_hizmetler(String doktor_hizmetler) {this.doktor_hizmetler = doktor_hizmetler;}

    public String getdoktor_e_posta() {return doktor_e_posta;}
    public void  setdoktor_e_posta(String doktor_e_posta) {this.doktor_e_posta = doktor_e_posta;}


}
