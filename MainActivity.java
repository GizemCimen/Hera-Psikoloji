package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button hasta_kayit_buton;
    private Button hasta_giris_buton;
    private Button psikolog_giris_buton;
    private Button yonetici_giris_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("HERA PSİKOLOJİ");

        hasta_kayit_buton=findViewById(R.id.hasta_kayit_buton);
        hasta_giris_buton=findViewById(R.id.hasta_giris_buton);
        psikolog_giris_buton=findViewById(R.id.psikolog_giris_buton);
        yonetici_giris_buton=findViewById(R.id.yonetici_giris_buton);

        hasta_kayit_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(MainActivity.this, hasta_kayit_ekrani.class);
                startActivity(giris);
            }
        });

        hasta_giris_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(MainActivity.this, hasta_ekrani.class);
                startActivity(giris);
            }
        });

        psikolog_giris_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(MainActivity.this, psikolog_ekrani.class);
                startActivity(giris);
            }
        });

        yonetici_giris_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(MainActivity.this, yonetici_ekrani.class);
                startActivity(giris);
            }
        });
    }
}