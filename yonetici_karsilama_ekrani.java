package com.example.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

public class yonetici_karsilama_ekrani extends AppCompatActivity {
    private Button yonetici_karsilama_ekrani_psikolog_listeleme;
    private Button yonetici_karsilama_ekrani_bildirimler;
    private Button yonetici_karsilama_ekrani_ayarlar;
    private Button yonetici_karsilama_ekrani_randevulari_goruntuleme;
    private Button yonetici_karsilama_ekrani_cikisyap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_karsilama_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HERA PSİKOLOJİ");


        yonetici_karsilama_ekrani_psikolog_listeleme=findViewById(R.id.yonetici_karsilama_ekrani_psikolog_listeleme);
        yonetici_karsilama_ekrani_bildirimler=findViewById(R.id.yonetici_karsilama_ekrani_bildirimler);
        yonetici_karsilama_ekrani_ayarlar=findViewById(R.id.yonetici_karsilama_ekrani_ayarlar);
        yonetici_karsilama_ekrani_randevulari_goruntuleme=findViewById(R.id.yonetici_karsilama_ekrani_randevulari_goruntuleme);
        yonetici_karsilama_ekrani_cikisyap=findViewById(R.id.psikolog_karsilama_ekrani_cikisyap);
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