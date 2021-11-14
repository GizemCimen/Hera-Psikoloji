package com.example.psikolog_gizem.hasta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.adapter.doktor_adapter;
import com.example.psikolog_gizem.adapter.hizmet_adapter;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.hizmetler;
import com.example.psikolog_gizem.yonetici.yonetici_psikolog_listeleme_ekrani;

import java.util.ArrayList;

public class hasta_hizmetler_goruntuleme_sayfasi extends AppCompatActivity {
    private ListView list_hasta_hizmet_goruntule;
    private ArrayList<hizmetler> hizmetlerArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_hizmetler_goruntuleme_sayfasi);
        final VeriTabani veriTabani=new VeriTabani(hasta_hizmetler_goruntuleme_sayfasi.this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HİZMETLERİMİZ...");

        ListView list_hasta_hizmet_goruntule=(ListView) findViewById(R.id.list_hasta_hizmet_goruntule);
        hizmetlerArrayList = veriTabani.butunHizmetleriGetir();
        int length = hizmetlerArrayList.size();
        String[] ad = new String[length];
        String[] aciklama = new String[length];


        for (int i = 0; i < length; i++) {
            ad[i] = hizmetlerArrayList.get(i).gethizmet_ad();
            aciklama[i] = hizmetlerArrayList.get(i).gethizmet_aciklama();

        }
        hizmet_adapter hizmetAdapter = new hizmet_adapter(this, ad, aciklama);

        list_hasta_hizmet_goruntule.setAdapter(hizmetAdapter);








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