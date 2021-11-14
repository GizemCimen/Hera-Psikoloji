package com.example.psikolog_gizem.yonetici;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.adapter.doktor_adapter;
import com.example.psikolog_gizem.adapter.randevu_adapter;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.randevular;

import java.util.ArrayList;

public class yonetici_randevu_listeleme_ekrani extends AppCompatActivity {
        private ListView randevu_listview;
    private ArrayList<randevular> randevularArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_randevu_listeleme_ekrani);
        randevu_listview=findViewById(R.id.randevu_listview);
        final VeriTabani veriTabani=new VeriTabani(yonetici_randevu_listeleme_ekrani.this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("RANDEVU LİSTESİ");
        randevularArrayList=veriTabani.butunRandevularıGetir();
        int length = randevularArrayList.size();
        String[] hasta = new String[length];
        String[] doktor = new String[length];
        String[] hizmet = new String[length];
        String[] tarih = new String[length];
        String[] saat = new String[length];

        for (int i = 0; i < length; i++) {
            hasta[i] = randevularArrayList.get(i).getrandevu_hastasi();
            doktor[i] = randevularArrayList.get(i).getrandevu_doktoru();
            hizmet[i] = randevularArrayList.get(i).getrandevu_hizmet();
            tarih[i] = randevularArrayList.get(i).getrandevu_tarihi();
            saat[i] = randevularArrayList.get(i).getrandevu_saati();
        }
        randevu_adapter randevuAdapter = new randevu_adapter(this, hasta, doktor, hizmet,tarih,saat);

        randevu_listview.setAdapter(randevuAdapter);


    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}