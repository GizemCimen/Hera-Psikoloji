package com.example.psikolog.veritabani;

public class hizmetler {

    private String hizmet_id;
    private String hizmet_ad;


    public hizmetler() {
    }

    public hizmetler(String hizmet_id, String hizmet_ad) {
        this.hizmet_id = hizmet_id;
        this.hizmet_ad = hizmet_ad;

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
}
