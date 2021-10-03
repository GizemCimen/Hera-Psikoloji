package com.example.psikolog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class hasta_kayit_ekrani extends AppCompatActivity {

    private EditText hasta_kayit_ad;
    private EditText hasta_kayit_soyad;
    private EditText hasta_kayit_telefon;
    private EditText hasta_kayit_e_posta;
    private Button hasta_kayit_kaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_kayit_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("KAYIT OL");

        hasta_kayit_ad=findViewById(R.id.hasta_kayit_ad);
        hasta_kayit_soyad=findViewById(R.id.hasta_kayit_soyad);
        hasta_kayit_telefon=findViewById(R.id.hasta_kayit_telefon);
        hasta_kayit_e_posta=findViewById(R.id.hasta_kayit_e_posta);
        hasta_kayit_kaydet=findViewById(R.id.hasta_kayit_kaydet);
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