package com.example.psikolog_gizem.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;

import java.util.ArrayList;

public class psikolog_profil_sayfasi extends AppCompatActivity {
    private EditText txt_doktor_adi;
    private EditText txt_doktor_e_posta;
    private EditText txt_doktor_sifre;
    private EditText txt_doktor_hizmet;
    private Button button_doktor_guncelle;

    private ArrayList<doktorlar> doktorlarArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_profil_sayfasi);
        txt_doktor_adi=findViewById(R.id.txt_doktor_adi);
        txt_doktor_e_posta=findViewById(R.id.txt_doktor_e_posta);
        txt_doktor_sifre=findViewById(R.id.txt_doktor_sifre);
        txt_doktor_hizmet=findViewById(R.id.txt_doktor_hizmet);
        button_doktor_guncelle=findViewById(R.id.button_doktor_guncelle);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("PROFİL ");

        VeriTabani veriTabani=new VeriTabani(psikolog_profil_sayfasi.this);
        String gelen=getIntent().getStringExtra("e_posta2");

        doktorlarArrayList=veriTabani.butunDoktorlarıGetir();
        int length=doktorlarArrayList.size();
        String[] adsoyad=new String[length];
        String[] eposta = new String[length];
        String[] sifre=new String[length];
        String[] hizmet=new String[length];


        for (int i=0; i<length; i++){
            adsoyad[i]=doktorlarArrayList.get(i).getdoktor_adi_soyadi();
          eposta[i]=doktorlarArrayList.get(i).getdoktor_e_posta();
            sifre[i]=doktorlarArrayList.get(i).getdoktor_sifre();
            hizmet[i]=doktorlarArrayList.get(i).getdoktor_hizmetler();

            if(eposta[i].equals(gelen)){
                txt_doktor_adi.setText(adsoyad[i]);
                txt_doktor_e_posta.setText(eposta[i]);
                txt_doktor_sifre.setText(sifre[i]);
                txt_doktor_hizmet.setText(hizmet[i]);

            }
        }




        button_doktor_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_doktor_adi.getText().equals("")||
                        txt_doktor_e_posta.getText().equals("")||
                        txt_doktor_sifre.getText().equals("")||
                        txt_doktor_hizmet.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"ALANLAR BOŞ BIRAKILAMAZ !",Toast.LENGTH_SHORT).show();
                }
                else{
                    doktorlar doktor=new doktorlar(txt_doktor_adi.getText().toString(),txt_doktor_e_posta.getText().toString(),txt_doktor_sifre.getText().toString(),txt_doktor_hizmet.getText().toString());
                    veriTabani.DoktorGuncelle(doktor);
                    Toast.makeText(getApplicationContext(),"GÜNCELLEME BAŞARILI !",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(psikolog_profil_sayfasi.this,psikolog_karsilama_ekrani.class);
                    startActivity(intent);
                    finish();
                }

            }
        });




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