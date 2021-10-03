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

public class psikolog_ekrani extends AppCompatActivity {
    private EditText psikolog_ekran_e_posta;
    private EditText psikolog_ekran_sifre;
    private TextView psikolog_ekran_sifre_unuttum;
    private Button psikolog_ekran_giris_yap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("DOKTOR GİRİŞİ");


        psikolog_ekran_e_posta=findViewById(R.id.psikolog_ekran_e_posta);
        psikolog_ekran_sifre=findViewById(R.id.psikolog_ekran_sifre);
        psikolog_ekran_sifre_unuttum=findViewById(R.id.psikolog_ekran_sifre_unuttum);
        psikolog_ekran_giris_yap=findViewById(R.id.psikolog_ekran_giris_yap);

        psikolog_ekran_giris_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giris=new Intent(psikolog_ekrani.this, psikolog_karsilama_ekrani.class);
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
