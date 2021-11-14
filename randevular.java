package com.example.psikolog_gizem.veritabani;
import java.util.Calendar;

public class randevular {
    private String randevu_id;
    private String randevu_hizmet;
    private String randevu_hastasi;
    private String randevu_doktoru;
    private String randevu_tarihi;
    private String randevu_saati;


    public randevular() {
    }

    public randevular(String randevu_id, String randevu_tarihi,String randevu_saati) {
        this.randevu_id = randevu_id;
        this.randevu_tarihi = randevu_tarihi;
        this.randevu_saati = randevu_saati;

    }
    public randevular(String randevu_hastasi,String randevu_doktoru,String randevu_hizmet,String randevu_tarihi, String randevu_saati){
        this.randevu_hastasi=randevu_hastasi;
        this.randevu_doktoru=randevu_doktoru;
        this.randevu_hizmet=randevu_hizmet;
        this.randevu_tarihi=randevu_tarihi;
        this.randevu_saati=randevu_saati;

            }

    public String getrandevu_id() { return randevu_id;}
    public void setrandevu_id(String randevu_id) {
        this.randevu_id = randevu_id;
    }

    public String getrandevu_hizmet() { return randevu_hizmet;}
    public void setrandevu_hizmet(String randevu_hizmet) {
        this.randevu_hizmet = randevu_hizmet;
    }

    public String getrandevu_hastasi() { return randevu_hastasi;}
    public void setrandevu_hastasi(String randevu_hastasi) {
        this.randevu_hastasi = randevu_hastasi;
    }

    public String getrandevu_doktoru() { return randevu_doktoru;}
    public void setrandevu_doktoru(String randevu_doktoru) {
        this.randevu_doktoru = randevu_doktoru;
    }

    public String getrandevu_tarihi() {
        return randevu_tarihi;
    }
    public void setrandevu_tarihi(String randevu_tarihi) {
        this.randevu_tarihi = randevu_tarihi;
    }

    public String getrandevu_saati() {
        return randevu_saati;
    }
    public void setrandevu_saati(String randevu_saati) {
        this.randevu_saati = randevu_saati;
    }

}
