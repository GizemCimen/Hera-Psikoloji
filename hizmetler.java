package com.example.psikolog_gizem.veritabani;

public class hizmetler {
    private String hizmet_id;
    private String hizmet_ad;
    private String hizmet_aciklama;


    public hizmetler() {
    }

    public hizmetler(String hizmet_id,String hizmet_ad,String hizmet_aciklama){
        this.hizmet_id=hizmet_id;
        this.hizmet_ad=hizmet_ad;
        this.hizmet_aciklama=hizmet_aciklama;
    }

    public hizmetler(String hizmet_ad, String hizmet_aciklama) {
        this.hizmet_ad = hizmet_ad;
        this.hizmet_aciklama = hizmet_aciklama;

    }

    public String gethizmet_id() { return hizmet_id;}
    public void sethizmet_id(String hizmet_id) {
        this.hizmet_id = hizmet_id;
    }

    public String gethizmet_ad() {
        return hizmet_ad;
    }
    public void sethizmet_ad(String hizmet_ad) {
        this.hizmet_ad = hizmet_ad;
    }

    public String gethizmet_aciklama() {
        return hizmet_aciklama;
    }
    public void sethizmet_aciklama(String hizmet_aciklama) {
        this.hizmet_aciklama = hizmet_aciklama;
    }

}
