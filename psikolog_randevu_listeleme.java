package com.example.psikolog_gizem.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.adapter.randevu_adapter;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.randevular;
import com.example.psikolog_gizem.yonetici.yonetici_randevu_listeleme_ekrani;

import java.util.ArrayList;

public class psikolog_randevu_listeleme extends AppCompatActivity {
    private ListView psikolog_randevu_listele;
    private ArrayList<randevular> randevularArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_randevu_listeleme);
        psikolog_randevu_listele=findViewById(R.id.psikolog_randevu_listele);
        final VeriTabani veriTabani=new VeriTabani(psikolog_randevu_listeleme.this);
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

        psikolog_randevu_listele.setAdapter(randevuAdapter);
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