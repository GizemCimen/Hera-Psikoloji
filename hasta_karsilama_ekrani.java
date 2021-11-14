package com.example.psikolog_gizem.hasta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.psikolog_gizem.R;

public class hasta_karsilama_ekrani extends AppCompatActivity {
    private Button hasta_karsilama_ekrani_randevu_al;
    private Button hasta_karsilama_ekrani_hizmetler;
    private Button hasta_karsilama_ekrani_test;
    private Button hasta_karsilama_ekrani_blog;
    private Button hasta_karsilama_ekrani_profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_karsilama_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HERA PSİKOLOJİ");

        String gelen=getIntent().getStringExtra("key");

        hasta_karsilama_ekrani_randevu_al=findViewById(R.id.hasta_karsilama_ekrani_randevu_al);
        hasta_karsilama_ekrani_hizmetler=findViewById(R.id.hasta_karsilama_ekrani_hizmetler);
        hasta_karsilama_ekrani_blog=findViewById(R.id.hasta_karsilama_ekrani_blog);
        hasta_karsilama_ekrani_profil=findViewById(R.id.hasta_karsilama_ekrani_profil);

        hasta_karsilama_ekrani_randevu_al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hasta_karsilama_ekrani.this,hasta_randevu_alma_ekrani.class);
                intent.putExtra("name",gelen);
                startActivity(intent);
            }
        });
        hasta_karsilama_ekrani_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri blog_linki=Uri.parse("https://herapsikoloji.com/blog-sayfasi/");
                Intent intent =new Intent(Intent.ACTION_VIEW,blog_linki);
                startActivity(intent);
            }
        });
        hasta_karsilama_ekrani_hizmetler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hasta_karsilama_ekrani.this,hasta_hizmetler_goruntuleme_sayfasi.class);
                startActivity(intent);
            }
        });

        hasta_karsilama_ekrani_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hasta_karsilama_ekrani.this,hasta_profil_sayfasi.class);
                intent.putExtra("name2",gelen);
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