package com.example.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import java.util.PrimitiveIterator;

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