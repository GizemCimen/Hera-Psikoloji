package com.example.psikolog.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.psikolog.hizmetler.hizmetler_ekrani;
import com.example.psikolog.MainActivity;
import com.example.psikolog.R;

public class psikolog_karsilama_ekrani extends AppCompatActivity {
    private Button psikolog_karsilama_ekrani_hasta_goruntuleme;
    private Button psikolog_karsilama_ekrani_randevu_goruntuleme;
    private Button psikolog_karsilama_ekrani_hizmetler;
    private Button psikolog_karsilama_ekrani_test;
    private Button psikolog_karsilama_ekrani_blog;
    private Button psikolog_karsilama_ekrani_rapor_kayit;
    private Button psikolog_karsilama_ekrani_bildirimler;
    private Button psikolog_karsilama_ekrani_profil;
    private Button psikolog_karsilama_ekrani_cikisyap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_karsilama_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HERA PSİKOLOJİ");

        psikolog_karsilama_ekrani_hasta_goruntuleme=findViewById(R.id.psikolog_karsilama_ekrani_hasta_goruntuleme);
        psikolog_karsilama_ekrani_randevu_goruntuleme=findViewById(R.id.psikolog_karsilama_ekrani_randevu_goruntuleme);
        psikolog_karsilama_ekrani_hizmetler=findViewById(R.id.psikolog_karsilama_ekrani_hizmetler);
        psikolog_karsilama_ekrani_test=findViewById(R.id.psikolog_karsilama_ekrani_test);
        psikolog_karsilama_ekrani_blog=findViewById(R.id.psikolog_karsilama_ekrani_blog);
        psikolog_karsilama_ekrani_rapor_kayit=findViewById(R.id.psikolog_karsilama_ekrani_rapor_kayit);
        psikolog_karsilama_ekrani_bildirimler=findViewById(R.id.psikolog_karsilama_ekrani_bildirimler);
        psikolog_karsilama_ekrani_profil=findViewById(R.id.psikolog_karsilama_ekrani_profil);
        psikolog_karsilama_ekrani_cikisyap=findViewById(R.id.psikolog_karsilama_ekrani_cikisyap);

        psikolog_karsilama_ekrani_rapor_kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(psikolog_karsilama_ekrani.this, psikolog_rapor_ekrani.class);
            startActivity(giris);
            }
        });

        psikolog_karsilama_ekrani_hizmetler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(psikolog_karsilama_ekrani.this, hizmetler_ekrani.class);
                startActivity(giris);
            }
        });



        psikolog_karsilama_ekrani_bildirimler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(psikolog_karsilama_ekrani.this, psikolog_bildirim.class);
                startActivity(intent);
            }
        });

        psikolog_karsilama_ekrani_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(psikolog_karsilama_ekrani.this, psikolog_blog.class);
                startActivity(giris);
            }
        });

        psikolog_karsilama_ekrani_cikisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(psikolog_karsilama_ekrani.this, MainActivity.class);
                startActivity(giris);
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