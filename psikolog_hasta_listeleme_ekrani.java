package com.example.psikolog_gizem.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.adapter.hasta_adapter;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.hastalar;

import java.util.ArrayList;

public class psikolog_hasta_listeleme_ekrani extends AppCompatActivity {
private ListView hasta_listele_listview;
private ArrayList<hastalar> hastalarArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_hasta_listeleme_ekrani);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HASTA LİSTESİ");

        final VeriTabani veriTabani=new VeriTabani(psikolog_hasta_listeleme_ekrani.this);
        hasta_listele_listview=findViewById(R.id.hasta_listele_listview);
        hastalarArrayList=veriTabani.butunHastalarıGetir();
        int length=hastalarArrayList.size();
        String[] ad = new String[length];
        String[] soyad = new String[length];
        String[] telefon = new String[length];
        String[] eposta = new String[length];

        for (int i=0; i<length; i++){
            ad[i]=hastalarArrayList.get(i).gethasta_adi();
            soyad[i]=hastalarArrayList.get(i).gethasta_soyadi();
            telefon[i]=hastalarArrayList.get(i).gethasta_telefon();
            eposta[i]=hastalarArrayList.get(i).gethasta_e_posta();
        }
        hasta_adapter hastaAdapter=new hasta_adapter(this,ad,soyad,telefon,eposta);
        hasta_listele_listview.setAdapter(hastaAdapter);
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