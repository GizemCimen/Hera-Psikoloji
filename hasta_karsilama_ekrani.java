package com.example.psikolog.hasta;

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
import com.example.psikolog.hizmetler.yorum_ekrani;

public class hasta_karsilama_ekrani extends AppCompatActivity {

    private Button hasta_karsilama_ekrani_randevu_al;
    private Button hasta_karsilama_ekrani_hizmetler;
    private Button hasta_karsilama_ekrani_test;
    private Button hasta_karsilama_ekrani_blog;
    private Button hasta_karsilama_ekrani_profil;
    private Button hasta_karsilama_ekrani_yorum;
    private Button hasta_karsilama_ekrani_cikisyap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_karsilama_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HERA PSİKOLOJİ");

        hasta_karsilama_ekrani_randevu_al=findViewById(R.id.hasta_karsilama_ekrani_randevu_al);
        hasta_karsilama_ekrani_hizmetler=findViewById(R.id.hasta_karsilama_ekrani_hizmetler);
        hasta_karsilama_ekrani_test=findViewById(R.id.hasta_karsilama_ekrani_test);
        hasta_karsilama_ekrani_blog=findViewById(R.id.hasta_karsilama_ekrani_blog);
        hasta_karsilama_ekrani_profil=findViewById(R.id.hasta_karsilama_ekrani_profil);
        hasta_karsilama_ekrani_yorum=findViewById(R.id.hasta_karsilama_ekrani_yorum);
        hasta_karsilama_ekrani_cikisyap=findViewById(R.id.hasta_karsilama_ekrani_cikisyap);

        hasta_karsilama_ekrani_cikisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hasta_karsilama_ekrani.this, MainActivity.class);
                startActivity(giris);
            }
        });

        hasta_karsilama_ekrani_yorum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hasta_karsilama_ekrani.this, yorum_ekrani.class);
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