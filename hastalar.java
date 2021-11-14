package com.example.psikolog_gizem.veritabani;

public class hastalar {

    private String hasta_id;
    private String hasta_adi;
    private String hasta_soyadi;
    private String hasta_telefon;
    private String hasta_e_posta;
    private String hasta_sifre;
    private String hasta_sikayet;

    public hastalar() {
    }

    public hastalar(String hasta_e_posta,String hasta_sifre){
        this.hasta_e_posta=hasta_e_posta;
        this.hasta_sifre=hasta_sifre;
    }

    public hastalar(String hasta_id, String hasta_adi,String hasta_soyadi,String hasta_telefon,String hasta_e_posta,String hasta_sifre,String hasta_sikayet) {
        this.hasta_id=hasta_id;
        this.hasta_adi=hasta_adi;
        this.hasta_soyadi=hasta_soyadi;
        this.hasta_telefon=hasta_telefon;
        this.hasta_e_posta=hasta_e_posta;
        this.hasta_sifre=hasta_sifre;
        this.hasta_sikayet=hasta_sikayet;

    }

    public hastalar(String hasta_adi,String hasta_soyadi,String hasta_telefon,String hasta_e_posta,String hasta_sifre) {
        this.hasta_adi=hasta_adi;
        this.hasta_soyadi=hasta_soyadi;
        this.hasta_telefon=hasta_telefon;
        this.hasta_e_posta=hasta_e_posta;
        this.hasta_sifre=hasta_sifre;



    }
    public String gethasta_id() {
        return hasta_id;
    }
    public void sethasta_id(String hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String gethasta_adi() {
        return hasta_adi;
    }
    public void sethasta_adi(String hasta_adi) {this.hasta_adi = hasta_adi;}


    public String gethasta_soyadi() {
        return hasta_soyadi;
    }
    public void sethasta_soyadi(String hasta_soyadi) {this.hasta_soyadi = hasta_soyadi;}

    public String gethasta_telefon() {
        return hasta_telefon;
    }
    public void sethasta_telefon(String hasta_telefon) {this.hasta_telefon = hasta_telefon;}

    public String gethasta_e_posta() { return hasta_e_posta; }
    public void sethasta_e_posta(String hasta_e_posta) {this.hasta_e_posta = hasta_e_posta;}

    public String gethasta_sifre() {
        return hasta_sifre;
    }
    public  void sethasta_sifre(String hasta_sifre){this.hasta_sifre=hasta_sifre;}

    public String gethasta_sikayet() {return hasta_sikayet;}
    public void  sethasta_sikayet(String hasta_sikayet) {this.hasta_sikayet = hasta_sikayet;}
}
