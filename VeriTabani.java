package com.example.psikolog.veritabani;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.psikolog.yonetici.yonetici_psikolog_ekleme_sayfasi;

import java.util.ArrayList;

public class VeriTabani extends SQLiteOpenHelper {

    // Veritabanı versiyonu
    private static final int VERITABANI_VERSION = 1;


    // Veritabanı ismi
    private static final String VERITABANI_ADI = "psikolog.db";

    // Tablo isimleri
    private static final String TABLO_doktorlar = "doktor_listesi";
    private static final String TABLO_hizmetler = "hizmet_listesi";
    private static final String Tablo_randevular= "randevu_listesi";
    private static final String Tablo_hastalar= "hasta_listesi";

    // doktor tablosu sütun isimleri
    private static final String SUTUN_DOKTOR_ID = "doktor_id";
    private static final String SUTUN_DOKTOR_ADI_SOYADI = "doktor_adi_soyadi";
    private static final String SUTUN_DOKTOR_E_POSTA = "doktor_e_posta";
    private static final String SUTUN_DOKTOR_SIFRE = "doktor_sifre";
    private static final String SUTUN_DOKTOR_HIZMETLER = "doktor_hizmetler";


    // hizmet tablosu sütun isimleri
    private static final String SUTUN_HIZMET_ID = "hizmet_id";
    private static final String SUTUN_HIZMET_AD = "hizmet_ad";

    // randevu tablosu sütun isimleri
    private static final String SUTUN_RANDEVU_ID = "randevu_id";
    private static final String SUTUN_RANDEVU_TARIHI = "randevu_tarihi";
    private static final String SUTUN_RANDEVU_SAATI = "randevu_saati";

    // hasta tablosu sütun isimleri
    private static final String SUTUN_HASTA_ID = "hasta_id";
    private static final String SUTUN_HASTA_ADI_SOYADI = "hasta_adi_soyadi";
    private static final String SUTUN_HASTA_SIFRE = "hasta_sifre";
    private static final String SUTUN_HASTA_SIKAYET = "hasta_sikayet";


    //doktor tablosu oluşturma sorgusu
    private static final String DOKTOR_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_doktorlar + "(" +
            SUTUN_DOKTOR_ID + " INTEGER PRIMARY KEY, " +
            SUTUN_DOKTOR_ADI_SOYADI + " TEXT NOT NULL, " +
            SUTUN_DOKTOR_E_POSTA + " TEXT NOT NULL, " +
            SUTUN_DOKTOR_SIFRE + " NUMERIC NOT NULL, " +
            SUTUN_DOKTOR_HIZMETLER + " TEXT)";

    // hizmet tablosunun oluşturma sorgusu
    private static final String HIZMET_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_hizmetler + "(" +
            SUTUN_HIZMET_ID + " TEXT PRIMARY KEY NOT NULL, " +
            SUTUN_HIZMET_AD + " TEXT NOT NULL " + ")";

    // randevu tablosunun oluşturma sorgusu
    private static final String RANDEVU_TABLOSU_OLUSTUR = "CREATE TABLE " + Tablo_randevular + "(" +
            SUTUN_RANDEVU_ID+ " TEXT PRIMARY KEY NOT NULL, " +
            SUTUN_RANDEVU_SAATI+ " TEXT NOT NULL, " +
            SUTUN_RANDEVU_TARIHI + " TEXT NOT NULL " + ")";

    //hasta tablosu oluşturma sorgusu
    private static final String HASTA_TABLOSU_OLUSTUR = "CREATE TABLE " + Tablo_hastalar + "(" +
            SUTUN_HASTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
            SUTUN_HASTA_ADI_SOYADI + " TEXT NOT NULL ," +
            SUTUN_HASTA_SIFRE + " NUMERİC NOT NULL ," +
            SUTUN_HASTA_SIKAYET+")";

    public VeriTabani(Context context) {
        super(context, VERITABANI_ADI, null, VERITABANI_VERSION);
    }



    // doktor tablosunun silme sorgusu
    private static final String DOKTOR_TABLOSU_SIL = "DROP TABLE IF EXISTS " + TABLO_doktorlar;

    // hizmet tablosunun silme sorgusu
    private static final String HIZMET_TABLOSU_SIL = "DROP TABLE IF EXISTS " + TABLO_hizmetler;

    // randevu tablosunun silme sorgusu
    private static final String RANDEVU_TABLOSU_SIL = "DROP TABLE IF EXISTS " + Tablo_randevular;

    // hasta tablosunun silme sorgusu
    private static final String HASTA_TABLOSU_SIL = "DROP TABLE IF EXISTS " + Tablo_hastalar;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DOKTOR_TABLOSU_OLUSTUR);
        db.execSQL(HIZMET_TABLOSU_OLUSTUR);
        db.execSQL(RANDEVU_TABLOSU_OLUSTUR);
        db.execSQL(HASTA_TABLOSU_OLUSTUR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DOKTOR_TABLOSU_SIL);
        db.execSQL(HIZMET_TABLOSU_SIL);
        db.execSQL(RANDEVU_TABLOSU_SIL);
        db.execSQL(HASTA_TABLOSU_SIL);
        onCreate(db);
    }


    public long DoktorEkle(doktorlar doktor){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_DOKTOR_ADI_SOYADI, doktor.getdoktor_adi_soyadi());
        values.put(SUTUN_DOKTOR_E_POSTA,doktor.getdoktor_e_posta());
        values.put(SUTUN_DOKTOR_SIFRE, doktor.getdoktor_sifre());
        values.put(SUTUN_DOKTOR_HIZMETLER, doktor.getdoktor_hizmetler());


        // degisenSatir -1 ise hata oluşmuştur.
        long hataKontrolu = db.insert(TABLO_doktorlar, null, values);
        db.close();
        return hataKontrolu;
    }



    public long RandevuEkle(randevular randevu){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_RANDEVU_ID, randevu.getrandevu_id());
        values.put(SUTUN_RANDEVU_TARIHI, randevu.getrandevu_tarihi());
        values.put(SUTUN_RANDEVU_SAATI, randevu.getrandevu_saati());



        // degisenSatir -1 ise hata oluşmuştur.
        long hataKontrolu = db.insert(Tablo_randevular, null, values);
        db.close();
        return hataKontrolu;
    }

    public long HastaEkle(hastalar hasta){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_HASTA_ID, hasta.gethasta_id());
        values.put(SUTUN_HASTA_ADI_SOYADI, hasta.gethasta_adi_soyadi());
        values.put(SUTUN_HASTA_SIFRE, hasta.gethasta_sifre());
        values.put(SUTUN_HASTA_SIKAYET, hasta.gethasta_sikayet());


        // degisenSatir -1 ise hata oluşmuştur.
        long hataKontrolu = db.insert(Tablo_hastalar, null, values);
        db.close();
        return hataKontrolu;
    }

    public void DoktorSil(doktorlar doktor){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLO_doktorlar, SUTUN_DOKTOR_ID + " = ?", new String[]{String.valueOf(doktor.getdoktor_id())
        });
        db.close();
    }

    public void RandevuSil(randevular randevu){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Tablo_randevular, SUTUN_RANDEVU_ID + " = ?", new String[]{randevu.getrandevu_id()
        });
        db.close();
    }

    public void HastaSil(hastalar hasta){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Tablo_hastalar, SUTUN_HASTA_ID + " = ?", new String[]{hasta.gethasta_id()
        });
        db.close();
    }

    // Gelen doktorun şifresini günceller
    public int DoktorSifreGuncelle(doktorlar doktor){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_DOKTOR_SIFRE, doktor.getdoktor_sifre());

        int degisenSifre = db.update(TABLO_doktorlar, values, SUTUN_DOKTOR_SIFRE + " = ?",
                new String[]{doktor.getdoktor_sifre()});
        db.close();
        return degisenSifre;
    }

    // Doktor adı ve şifrenin doğruluğunu kontrol eder
    public boolean girisBilgileriniKontrolEt(doktorlar doktor) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] sutunlar = {SUTUN_DOKTOR_E_POSTA};
        String  secim = SUTUN_DOKTOR_E_POSTA + " = ?" + " AND " + SUTUN_DOKTOR_SIFRE + " = ?";
        String[] secimOlcutleri = {doktor.getdoktor_e_posta(), doktor.getdoktor_sifre()};

        Cursor cursor = db.query(TABLO_doktorlar,       // işlem için kullanılacak tablo
                sutunlar,                               // geri dönecek sütunlar
                secim,                                  // WHERE için sütunlar
                secimOlcutleri,                         // WHERE için değerler
                null,
                null,
                null);

        int cursorSayisi = cursor.getCount();
        cursor.close();
        db.close();

        return cursorSayisi > 0;
    }


    // Bütün randevuları getirir
    @SuppressLint("Range")
    public ArrayList<randevular> butunRandevularıGetir(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<randevular> randevulars = new ArrayList<>();
        String query = "SELECT * FROM " + Tablo_randevular;

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                randevular randevu = new randevular();
                randevu.setrandevu_id(c.getString(c.getColumnIndex(SUTUN_RANDEVU_ID)));
                randevu.setrandevu_saati(c.getString(c.getColumnIndex(SUTUN_RANDEVU_SAATI)));
                randevu.setrandevu_tarihi(c.getString(c.getColumnIndex(SUTUN_RANDEVU_TARIHI)));


                randevulars.add(randevu);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return randevulars;
    }


    /**
     *
     *  hizmet tablosuyla ilgili metotlar
     *
     */


    // Yeni hizmet ekler
    public long HizmetEkle(hizmetler urun){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_HIZMET_ID, urun.gethizmet_id());
        values.put(SUTUN_HIZMET_AD, urun.gethizmet_ad());


        // degisenSatir -1 ise hata oluşmuştur
        long degisenSatir = db.insert(TABLO_hizmetler, null, values);
        db.close();
        return degisenSatir;
    }

    // Gelen hizmeti siler
    public void HizmetSil(String hizmet_id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLO_hizmetler, SUTUN_HIZMET_ID + " = ?", new String[]{String.valueOf(hizmet_id)});
        db.close();
    }


    // Bütün hizmetleri getirir
    @SuppressLint("Range")
    public ArrayList<hizmetler> butunHizmetleriGetir(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<hizmetler> hizmetlers = new ArrayList<>();
        String query = "SELECT * FROM " + TABLO_hizmetler;

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                hizmetler hizmet = new hizmetler();
                hizmet.sethizmet_id(c.getString(c.getColumnIndex(SUTUN_HIZMET_ID)));
                hizmet.sethizmet_ad(c.getString(c.getColumnIndex(SUTUN_HIZMET_ID)));


                hizmetlers.add(hizmet);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return hizmetlers;
    }

    // Bütün hastaları getirir
    @SuppressLint("Range")
    public ArrayList<hastalar> butunHastalarıGetir(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<hastalar> hastalars = new ArrayList<>();
        String query = "SELECT * FROM " + Tablo_hastalar;

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                hastalar hasta = new hastalar();
                hasta.sethasta_id(c.getString(c.getColumnIndex(SUTUN_HASTA_ID)));
                hasta.sethasta_adi_soyadi(c.getString(c.getColumnIndex(SUTUN_HASTA_ADI_SOYADI)));


                hastalars.add(hasta);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return hastalars;
    }

    // Bütün doktorları getirir
    @SuppressLint("Range")
    public ArrayList<doktorlar> butunDoktorlarıGetir(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<doktorlar> doktorlars = new ArrayList<>();
        String query = "SELECT * FROM " + TABLO_doktorlar;

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                doktorlar doktor = new doktorlar();
                doktor.setdoktor_id(c.getInt((c.getColumnIndex(SUTUN_DOKTOR_ID))));
                doktor.setdoktor_adi_soyadi(c.getString(c.getColumnIndex(SUTUN_DOKTOR_ADI_SOYADI)));
                doktor.setdoktor_e_posta(c.getString(c.getColumnIndex(SUTUN_DOKTOR_E_POSTA)));
                doktor.setdoktor_sifre(c.getString(c.getColumnIndex(SUTUN_DOKTOR_SIFRE)));
                doktor.setdoktor_hizmetler(c.getString(c.getColumnIndex(SUTUN_DOKTOR_HIZMETLER)));


                doktorlars.add(doktor);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return doktorlars;
    }



}
