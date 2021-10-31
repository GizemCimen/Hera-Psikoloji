package com.example.psikolog.veritabani;
import java.util.Calendar;

public class randevular {
    private String randevu_id;
    private String randevu_tarihi;
    private String randevu_saati;


    public randevular() {
    }

    public randevular(String randevu_id, String randevu_tarihi,String randevu_saati) {
        this.randevu_id = randevu_id;
        this.randevu_tarihi = randevu_tarihi;
        this.randevu_saati = randevu_saati;

    }

    public String getrandevu_id() { return randevu_id;}
    public void setrandevu_id(String randevu_id) {
        this.randevu_id = randevu_id;
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
