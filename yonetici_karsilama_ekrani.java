package com.example.psikolog.yonetici;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.psikolog.MainActivity;
import com.example.psikolog.R;
import com.example.psikolog.hasta.hasta_ekrani;
import com.example.psikolog.hasta.hasta_karsilama_ekrani;
import com.example.psikolog.psikolog.psikolog_karsilama_ekrani;

public class yonetici_karsilama_ekrani extends AppCompatActivity {
    private Button yonetici_karsilama_ekrani_psikolog_listeleme;
    private Button yonetici_karsilama_ekrani_ayarlar;
    private Button yonetici_karsilama_ekrani_randevulari_goruntuleme;
    private Button yonetici_karsilama_ekrani_cikisyap;
    private Button psikolog_ekle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_karsilama_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HERA PSİKOLOJİ");


        yonetici_karsilama_ekrani_psikolog_listeleme=findViewById(R.id.yonetici_karsilama_ekrani_psikolog_listeleme);

        yonetici_karsilama_ekrani_ayarlar=findViewById(R.id.yonetici_karsilama_ekrani_ayarlar);
        yonetici_karsilama_ekrani_randevulari_goruntuleme=findViewById(R.id.yonetici_karsilama_ekrani_randevulari_goruntuleme);
        yonetici_karsilama_ekrani_cikisyap=findViewById(R.id.psikolog_karsilama_ekrani_cikisyap);
        psikolog_ekle=findViewById(R.id.psikolog_ekle);


        psikolog_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(yonetici_karsilama_ekrani.this, yonetici_psikolog_ekleme_sayfasi.class);
                startActivity(giris);
            }
        });

        /*yonetici_karsilama_ekrani_cikisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(yonetici_karsilama_ekrani.this, MainActivity.class);
                startActivity(giris);
            }
        });*/

        yonetici_karsilama_ekrani_ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(yonetici_karsilama_ekrani.this, yonetici_ayarlar.class);
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