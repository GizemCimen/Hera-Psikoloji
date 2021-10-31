package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.psikolog.R;
import com.example.psikolog.cift_aile_terapisi;
import com.example.psikolog.cocuk_psikolojisi;
import com.example.psikolog.bireysel_psikoterapi;
import com.example.psikolog.emdr_terapi;
import com.example.psikolog.ergen_terapisi;
import com.example.psikolog.hamile_terapisi;
import com.example.psikolog.hasta.hasta_randevu_al;
import com.example.psikolog.ogrenci_koclugu;
import com.example.psikolog.sinav_kaygi;
import com.example.psikolog.yonetici.yonetici_karsilama_ekrani;
import com.example.psikolog.yonetici.yonetici_psikolog_ekleme_sayfasi;

public class hizmetler_ekrani extends AppCompatActivity {

    private Button hizmet_cocuk;
    private Button hizmet_cocuk2;
    private Button hizmet_cocuk3;
    private Button hizmet_cocuk4;
    private Button hizmet_cocuk5;
    private Button hizmet_cocuk6;
    private Button hizmet_cocuk7;
    private Button hizmet_cocuk8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hizmetler_ekrani);

        hizmet_cocuk=findViewById(R.id.hizmet_cocuk);
        hizmet_cocuk2 =findViewById(R.id.hizmet_cocuk2);
        hizmet_cocuk3=findViewById(R.id.hizmet_cocuk3);
        hizmet_cocuk4=findViewById(R.id.hizmet_cocuk4);
        hizmet_cocuk5=findViewById(R.id.hizmet_cocuk5);
        hizmet_cocuk6=findViewById(R.id.hizmet_cocuk6);
        hizmet_cocuk7=findViewById(R.id.hizmet_cocuk7);
        hizmet_cocuk8=findViewById(R.id.hizmet_cocuk8);

        hizmet_cocuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, cocuk_psikolojisi.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, bireysel_psikoterapi.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk3 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, cift_aile_terapisi.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk4 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, emdr_terapi.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk7 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, ogrenci_koclugu.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk6 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, ergen_terapisi.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk5 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, sinav_kaygi.class);
                startActivity(giris);
            }
        });
        hizmet_cocuk8 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hizmetler_ekrani.this, hamile_terapisi.class);
                startActivity(giris);
            }
        });

    }
}