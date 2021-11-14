package com.example.psikolog_gizem.yonetici;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.adapter.doktor_adapter;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;

import java.util.ArrayList;

public class yonetici_psikolog_listeleme_ekrani extends AppCompatActivity {

    private ListView doktor_listview;
    private ArrayList<doktorlar> doktorlarArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_psikolog_listeleme_ekrani);
        final VeriTabani veriTabani=new VeriTabani(yonetici_psikolog_listeleme_ekrani.this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("DOKTOR LİSTESİ");

        doktor_listview = findViewById(R.id.doktor_listview);

        doktorlarArrayList = veriTabani.butunDoktorlarıGetir();
        int length = doktorlarArrayList.size();
        String[] adsoyad = new String[length];
        String[] eposta = new String[length];
        String[] hizmet = new String[length];

        for (int i = 0; i < length; i++) {
            adsoyad[i] = doktorlarArrayList.get(i).getdoktor_adi_soyadi();
            eposta[i] = doktorlarArrayList.get(i).getdoktor_e_posta();
            hizmet[i] = doktorlarArrayList.get(i).getdoktor_hizmetler();
        }

        doktor_adapter psikologAdapter = new doktor_adapter(this, adsoyad, eposta, hizmet);

        doktor_listview.setAdapter(psikologAdapter);

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