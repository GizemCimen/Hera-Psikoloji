package com.example.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class hasta_ekrani extends AppCompatActivity {
    private EditText hasta_giris_e_posta;
    private EditText hasta_giris_sifre;
    private TextView hasta_giris_sifre_unuttum;
    private Button hasta_giris_giris_yap_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HASTA GİRİŞİ");

        hasta_giris_e_posta=findViewById(R.id.hasta_giris_e_posta);
        hasta_giris_sifre=findViewById(R.id.hasta_giris_sifre);
        hasta_giris_sifre_unuttum=findViewById(R.id.hasta_giris_sifre_unuttum);
        hasta_giris_giris_yap_buton=findViewById(R.id.hasta_giris_giris_yap_buton);

        hasta_giris_giris_yap_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(hasta_ekrani.this, hasta_karsilama_ekrani.class);
                startActivity(giris);
            }
        });
    }

    //BU FONKSİYON BACK TUŞUNU AKTİFLEŞTİRİYOR.
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}