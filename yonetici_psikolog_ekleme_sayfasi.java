package com.example.psikolog_gizem.yonetici;

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

public class yonetici_psikolog_ekleme_sayfasi extends AppCompatActivity {
    private EditText edittext_doktor_ekle_ad_soyad;
    private EditText edittext_doktor_ekle_e_posta;
    private EditText edittext_doktor_ekle_sifre;
    private EditText edittext_doktor_ekle_hizmet;
    private Button button_doktor_ekle_kaydet;
    int sayac=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_psikolog_ekleme_sayfasi2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("PSİKOLOG EKLE");

        final VeriTabani vt=new VeriTabani(yonetici_psikolog_ekleme_sayfasi.this);
        edittext_doktor_ekle_ad_soyad=findViewById(R.id.edittext_doktor_ekle_ad_soyad);
        edittext_doktor_ekle_e_posta=findViewById(R.id.edittext_doktor_ekle_e_posta);
        edittext_doktor_ekle_sifre=findViewById(R.id.edittext_doktor_ekle_sifre);
        edittext_doktor_ekle_hizmet=findViewById(R.id.edittext_doktor_ekle_hizmet);
        button_doktor_ekle_kaydet=findViewById(R.id.button_doktor_ekle_kaydet);

        button_doktor_ekle_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edittext_doktor_ekle_ad_soyad.getText().toString().trim().equals("") ||
                        edittext_doktor_ekle_e_posta.getText().toString().trim().equals("") ||
                        edittext_doktor_ekle_sifre.getText().toString().trim().equals("") ||
                        edittext_doktor_ekle_hizmet.getText().toString().trim().equals("") ){
                    Toast.makeText(getApplicationContext(),"Boş Alan Bırakılamaz !!", Toast.LENGTH_LONG).show();
                }
              else{
                    doktorlar doktor=new doktorlar(edittext_doktor_ekle_ad_soyad.getText().toString(),edittext_doktor_ekle_e_posta.getText().toString(),edittext_doktor_ekle_sifre.getText().toString(),edittext_doktor_ekle_hizmet.getText().toString());
                    vt.DoktorEkle(doktor);
                    ArrayList<doktorlar> addedDoctor = vt.butunDoktorlarıGetir();
                    Toast.makeText(getApplicationContext(), "KAYIT BAŞARILI", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(yonetici_psikolog_ekleme_sayfasi.this,yonetici_karsilama_ekrani.class);
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