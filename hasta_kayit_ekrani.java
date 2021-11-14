package com.example.psikolog_gizem.hasta;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.psikolog_gizem.MainActivity;
import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.hastalar;
import com.example.psikolog_gizem.yonetici.yonetici_psikolog_ekleme_sayfasi;

import java.util.ArrayList;

public class hasta_kayit_ekrani extends AppCompatActivity {
    private EditText hasta_kayit_ad;
    private EditText hasta_kayit_soyad;
    private EditText hasta_kayit_telefon;
    private EditText hasta_kayit_e_posta;
    private EditText hasta_kayit_sifre;
    private Button   hasta_kayit_kaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_kayit_ekrani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("KAYIT OL");

        final VeriTabani vt=new VeriTabani(hasta_kayit_ekrani.this);
        hasta_kayit_ad=findViewById(R.id.hasta_kayit_ad);
        hasta_kayit_soyad=findViewById(R.id.hasta_kayit_soyad);
        hasta_kayit_telefon=findViewById(R.id.hasta_kayit_telefon);
        hasta_kayit_e_posta=findViewById(R.id.hasta_kayit_e_posta);
        hasta_kayit_sifre=findViewById(R.id.hasta_kayit_sifre);
        hasta_kayit_kaydet=findViewById(R.id.hasta_kayit_kaydet);

        hasta_kayit_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasta_kayit_ad.getText().toString().trim().equals("") ||
                        hasta_kayit_soyad.getText().toString().trim().equals("") ||
                        hasta_kayit_telefon.getText().toString().trim().equals("") ||
                        hasta_kayit_e_posta.getText().toString().trim().equals("") ||
                        hasta_kayit_sifre.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Boş Alan Bırakılamaz !!", Toast.LENGTH_LONG).show();
                }
                else{
                    hastalar hasta=new hastalar(
                            hasta_kayit_ad.getText().toString(),
                            hasta_kayit_soyad.getText().toString(),
                            hasta_kayit_telefon.getText().toString(),
                            hasta_kayit_e_posta.getText().toString(),
                            hasta_kayit_sifre.getText().toString());
                    vt.HastaEkle(hasta);
                    Toast.makeText(getApplicationContext(), "KAYIT BAŞARILI", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(hasta_kayit_ekrani.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

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