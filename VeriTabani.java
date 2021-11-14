package com.example.psikolog_gizem.veritabani;

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

import java.util.ArrayList;

public class VeriTabani extends SQLiteOpenHelper {


    // Veritabanı versiyonu
    private static final int VERITABANI_VERSION   = 9;

    // Veritabanı ismi
    private static final String VERITABANI_ADI    = "psikolog.db";


    // Tablo isimleri
    private static final String TABLO_doktorlar   = "doktor_listesi";
    private static final String TABLO_hastalar    = "hasta_listesi";
    private static final String TABLO_randevular  = "randevu_listesi";
    private static final String TABLO_hizmetler   = "hizmet_listesi";


    // Doktor tablosu sütun isimleri
    private static final String SUTUN_DOKTOR_ID         = "doktor_id";
    private static final String SUTUN_DOKTOR_ADI_SOYADI = "doktor_adi_soyadi";
    private static final String SUTUN_DOKTOR_E_POSTA    = "doktor_e_posta";
    private static final String SUTUN_DOKTOR_SIFRE      = "doktor_sifre";
    private static final String SUTUN_DOKTOR_HIZMETLER  = "doktor_hizmetler";

    // Hasta tablosu sütun isimleri
    private static final String SUTUN_HASTA_ID        = "hasta_id";
    private static final String SUTUN_HASTA_ADI       = "hasta_adi";
    private static final String SUTUN_HASTA_SOYADI    = "hasta_soyadi";
    private static final String SUTUN_HASTA_TELEFON   = "hasta_telefonu";
    private static final String SUTUN_HASTA_E_POSTA   = "hasta_e_posta";
    private static final String SUTUN_HASTA_SIFRE     = "hasta_sifre";
    private static final String SUTUN_HASTA_SIKAYET   = "hasta_sikayet";

    // Randevu tablosu sütun isimleri
    private static final String SUTUN_RANDEVU_ID     = "randevu_id";
    private static final String SUTUN_RANDEVU_HIZMET     = "randevu_hizmet";
    private static final String SUTUN_RANDEVU_HASTASI     = "randevu_hastasi";
    private static final String SUTUN_RANDEVU_DOKTORU     = "randevu_doktoru";
    private static final String SUTUN_RANDEVU_TARIHI = "randevu_tarihi";
    private static final String SUTUN_RANDEVU_SAATI  = "randevu_saati";

    // Hizmet tablosu sütun isimleri
    private static final String SUTUN_HIZMET_ID = "hizmet_id";
    private static final String SUTUN_HIZMET_AD = "hizmet_ad";
    private static final String SUTUN_HIZMET_ACIKLAMA = "hizmet_aciklama";


    // Doktor tablosu oluşturma sorgusu
    private static final String DOKTOR_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_doktorlar + "(" +
            SUTUN_DOKTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," +
            SUTUN_DOKTOR_ADI_SOYADI + " TEXT NOT NULL ," +
            SUTUN_DOKTOR_E_POSTA + " TEXT NOT NULL ," +
            SUTUN_DOKTOR_SIFRE + " NUMERİC NOT NULL ," +
            SUTUN_DOKTOR_HIZMETLER + ")";

    // Hasta tablosu oluşturma sorgusu
    private static final String HASTA_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_hastalar + "(" +
            SUTUN_HASTA_ID + " INTEGER PRIMARY KEY NOT NULL, " +
            SUTUN_HASTA_ADI + " TEXT NOT NULL ," +
            SUTUN_HASTA_SOYADI + " TEXT NOT NULL ," +
            SUTUN_HASTA_TELEFON + " TEXT NOT NULL ," +
            SUTUN_HASTA_E_POSTA + " TEXT NOT NULL ," +
            SUTUN_HASTA_SIFRE + " TEXT NOT NULL ," +
            SUTUN_HASTA_SIKAYET+" TEXT "+")";

    // Randevu tablosunun oluşturma sorgusu
    private static final String RANDEVU_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_randevular + "(" +
            SUTUN_RANDEVU_ID+ " INTEGER PRIMARY KEY NOT NULL, " +
            SUTUN_RANDEVU_HASTASI+ " TEXT NOT NULL, " +
            SUTUN_RANDEVU_DOKTORU+ " TEXT NOT NULL, " +
            SUTUN_RANDEVU_HIZMET+ " TEXT NOT NULL, " +
            SUTUN_RANDEVU_TARIHI+ " TEXT NOT NULL, " +
            SUTUN_RANDEVU_SAATI + " TEXT NOT NULL " + ")";

    // Hizmet tablosunun oluşturma sorgusu
    private static final String HIZMET_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_hizmetler + "(" +
            SUTUN_HIZMET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            SUTUN_HIZMET_AD + " TEXT NOT NULL , " +
            SUTUN_HIZMET_ACIKLAMA + " TEXT  " + ")";


    // Doktor tablosunun silme sorgusu
    private static final String DOKTOR_TABLOSU_SIL  = "DROP TABLE IF EXISTS " + TABLO_doktorlar;

    // Hasta tablosunun silme sorgusu
    private static final String HASTA_TABLOSU_SIL   = "DROP TABLE IF EXISTS " + TABLO_hastalar;

    // Randevu tablosunun silme sorgusu
    private static final String RANDEVU_TABLOSU_SIL = "DROP TABLE IF EXISTS " + TABLO_randevular;

    // Hizmet tablosunun silme sorgusu
    private static final String HIZMET_TABLOSU_SIL  = "DROP TABLE IF EXISTS " + TABLO_hizmetler;


    // APK için değiştirme ve güncelleme
    public VeriTabani(Context context) {
        super(context, VERITABANI_ADI, null, VERITABANI_VERSION);
    }

    // Veritabanı oluşturma
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DOKTOR_TABLOSU_OLUSTUR);
        db.execSQL(HIZMET_TABLOSU_OLUSTUR);
        db.execSQL(RANDEVU_TABLOSU_OLUSTUR);
        db.execSQL(HASTA_TABLOSU_OLUSTUR);

    }

    // Veritabanı güncelleme
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DOKTOR_TABLOSU_SIL);
        db.execSQL(HIZMET_TABLOSU_SIL);
        db.execSQL(RANDEVU_TABLOSU_SIL);
        db.execSQL(HASTA_TABLOSU_SIL);
        onCreate(db);
    }


    /**
     *
     *  Ekleme işlemleriyle ilgili metotlar
     *
     */

    // Yeni doktor ekler
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

    // Yeni hasta ekler
    public long HastaEkle(hastalar hasta){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SUTUN_HASTA_ADI, hasta.gethasta_adi());
        values.put(SUTUN_HASTA_SOYADI, hasta.gethasta_soyadi());
        values.put(SUTUN_HASTA_TELEFON, hasta.gethasta_telefon());
        values.put(SUTUN_HASTA_E_POSTA, hasta.gethasta_e_posta());
        values.put(SUTUN_HASTA_SIFRE, hasta.gethasta_sifre());

        // degisenSatir -1 ise hata oluşmuştur.
        long hataKontrolu = db.insert(TABLO_hastalar, null, values);
        db.close();
        return hataKontrolu;
    }

    // Yeni randevu ekler
    public long RandevuEkle(randevular randevu){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_RANDEVU_HASTASI,randevu.getrandevu_hastasi());
        values.put(SUTUN_RANDEVU_DOKTORU,randevu.getrandevu_doktoru());
        values.put(SUTUN_RANDEVU_HIZMET,randevu.getrandevu_hizmet());
        values.put(SUTUN_RANDEVU_TARIHI, randevu.getrandevu_tarihi());
        values.put(SUTUN_RANDEVU_SAATI, randevu.getrandevu_saati());



        // degisenSatir -1 ise hata oluşmuştur.
        long hataKontrolu = db.insert(TABLO_randevular, null, values);
        db.close();
        return hataKontrolu;
    }

    // Yeni hizmet ekler
    public long HizmetEkle(hizmetler urun){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SUTUN_HIZMET_AD, urun.gethizmet_ad());
        values.put(SUTUN_HIZMET_ACIKLAMA, urun.gethizmet_aciklama());


        // degisenSatir -1 ise hata oluşmuştur
        long degisenSatir = db.insert(TABLO_hizmetler, null, values);
        db.close();
        return degisenSatir;
    }

    /**
     *
     *  Silme işlemleriyle ilgili metotlar
     *
     */

    // Gelen doktoru siler
    public void DoktorSil(doktorlar doktor){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLO_doktorlar, SUTUN_DOKTOR_ID + " = ?", new String[]{String.valueOf(doktor.getdoktor_id())
        });
        db.close();
    }

    // Gelen hastayı siler
    public void HastaSil(hastalar hasta){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLO_hastalar, SUTUN_HASTA_ID + " = ?", new String[]{hasta.gethasta_id()
        });
        db.close();
    }

    // Gelen randevuyu siler
    public void RandevuSil(randevular randevu){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLO_randevular, SUTUN_RANDEVU_ID + " = ?", new String[]{randevu.getrandevu_id()
        });
        db.close();
    }

    // Gelen hizmeti siler
    public void HizmetSil(String hizmet_id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLO_hizmetler, SUTUN_HIZMET_ID + " = ?", new String[]{String.valueOf(hizmet_id)});
        db.close();
    }

    /**
     *
     *  Getirme işlemleriyle ilgili metotlar
     *
     */

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
                doktor.setdoktor_id((c.getColumnIndex(SUTUN_DOKTOR_ID)));
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

    // Bütün hastaları getirir
    @SuppressLint("Range")
    public ArrayList<hastalar> butunHastalarıGetir(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<hastalar> hastalars = new ArrayList<>();
        String query = "SELECT * FROM " + TABLO_hastalar;

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                hastalar hasta = new hastalar();
                hasta.sethasta_adi(c.getString(c.getColumnIndex(SUTUN_HASTA_ADI)));
                hasta.sethasta_soyadi(c.getString(c.getColumnIndex(SUTUN_HASTA_SOYADI)));
                hasta.sethasta_telefon(c.getString(c.getColumnIndex(SUTUN_HASTA_TELEFON)));
                hasta.sethasta_e_posta(c.getString(c.getColumnIndex(SUTUN_HASTA_E_POSTA)));
                hasta.sethasta_sifre(c.getString(c.getColumnIndex(SUTUN_HASTA_SIFRE)));



                hastalars.add(hasta);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return hastalars;
    }

    // Bütün randevuları getirir
    @SuppressLint("Range")
    public ArrayList<randevular> butunRandevularıGetir(){
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<randevular> randevulars = new ArrayList<>();
        String query = "SELECT * FROM " + TABLO_randevular;

        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                randevular randevu = new randevular();
                randevu.setrandevu_hastasi(c.getString(c.getColumnIndex(SUTUN_RANDEVU_HASTASI)));
                randevu.setrandevu_doktoru(c.getString(c.getColumnIndex(SUTUN_RANDEVU_DOKTORU)));
                randevu.setrandevu_hizmet(c.getString(c.getColumnIndex(SUTUN_RANDEVU_HIZMET)));
                randevu.setrandevu_tarihi(c.getString(c.getColumnIndex(SUTUN_RANDEVU_TARIHI)));
                randevu.setrandevu_saati(c.getString(c.getColumnIndex(SUTUN_RANDEVU_SAATI)));


                randevulars.add(randevu);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return randevulars;
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
                hizmet.sethizmet_ad(c.getString(c.getColumnIndex(SUTUN_HIZMET_AD)));
                hizmet.sethizmet_aciklama(c.getString(c.getColumnIndex(SUTUN_HIZMET_ACIKLAMA)));


                hizmetlers.add(hizmet);
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return hizmetlers;
    }

    /**
     *
     *  Güncelleme işlemleriyle ilgili metotlar
     *
     */

    // Gelen doktoru günceller
    public void DoktorGuncelle(doktorlar doktor){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_DOKTOR_ADI_SOYADI, doktor.getdoktor_adi_soyadi());
        values.put(SUTUN_DOKTOR_E_POSTA, doktor.getdoktor_e_posta());
        values.put(SUTUN_DOKTOR_SIFRE, doktor.getdoktor_sifre());
        values.put(SUTUN_DOKTOR_HIZMETLER, doktor.getdoktor_hizmetler());

        db.update(TABLO_doktorlar, values, SUTUN_DOKTOR_E_POSTA + " = ?",
                new String[]{String.valueOf(doktor.getdoktor_e_posta())});
        db.close();

    }

    // Gelen hastayı günceller
    public void HastaGuncelle(hastalar hasta){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUTUN_HASTA_ADI, hasta.gethasta_adi());
        values.put(SUTUN_HASTA_SOYADI, hasta.gethasta_soyadi());
        values.put(SUTUN_HASTA_TELEFON, hasta.gethasta_telefon());
        values.put(SUTUN_HASTA_E_POSTA, hasta.gethasta_e_posta());
        values.put(SUTUN_HASTA_SIFRE, hasta.gethasta_sifre());

        db.update(TABLO_hastalar, values, SUTUN_HASTA_E_POSTA + " = ?",
                new String[]{String.valueOf(hasta.gethasta_e_posta())});
        db.close();

    }

    /**
     *
     *  Kontrol işlemleriyle ilgili metotlar
     *
     */

    // Doktor e-posta ve şifrenin doğruluğunu kontrol eder
    public boolean DoktorGirisBilgileriniKontrolEt(doktorlar doktor) {
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

    // Hasta e-posta ve şifrenin doğruluğunu kontrol eder
    public boolean HastaGirisBilgileriniKontrolEt(hastalar hasta) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] sutunlar = {SUTUN_HASTA_E_POSTA};
        String  secim = SUTUN_HASTA_E_POSTA + " = ?" + " AND " + SUTUN_HASTA_SIFRE + " = ?";
        String[] secimOlcutleri = {hasta.gethasta_e_posta(), hasta.gethasta_sifre()};

        Cursor cursor = db.query(TABLO_hastalar,       // işlem için kullanılacak tablo
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



}
