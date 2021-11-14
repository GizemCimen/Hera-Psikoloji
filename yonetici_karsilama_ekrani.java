package com.example.psikolog_gizem.yonetici;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.psikolog_gizem.R;

public class yonetici_karsilama_ekrani extends AppCompatActivity {
    private Button yonetici_karsilama_ekrani_psikolog_listeleme;
    private Button yonetici_karsilama_ekrani_bildirimler;

    private Button yonetici_karsilama_ekrani_randevulari_goruntuleme;
    private Button button_yonetici_psikolog_ekle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_karsilama_ekrani);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("HERA PSİKOLOJİ");


        yonetici_karsilama_ekrani_psikolog_listeleme=findViewById(R.id.yonetici_karsilama_ekrani_psikolog_listeleme);
        yonetici_karsilama_ekrani_bildirimler=findViewById(R.id.yonetici_karsilama_ekrani_bildirimler);

        yonetici_karsilama_ekrani_randevulari_goruntuleme=findViewById(R.id.yonetici_karsilama_ekrani_randevulari_goruntuleme);
        button_yonetici_psikolog_ekle=findViewById(R.id.button_yonetici_psikolog_ekle);

        yonetici_karsilama_ekrani_bildirimler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(yonetici_karsilama_ekrani.this, yonetici_bildirimler_ekrani.class);
            startActivity(intent);
            }
        });

        yonetici_karsilama_ekrani_psikolog_listeleme.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(yonetici_karsilama_ekrani.this,yonetici_psikolog_listeleme_ekrani.class);
               startActivity(intent);
           }
       });

        yonetici_karsilama_ekrani_randevulari_goruntuleme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(yonetici_karsilama_ekrani.this,yonetici_randevu_listeleme_ekrani.class);
                startActivity(intent);
            }
        });
        button_yonetici_psikolog_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(yonetici_karsilama_ekrani.this, yonetici_psikolog_ekleme_sayfasi.class);
                startActivity(intent);
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