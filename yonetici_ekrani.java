package com.example.psikolog_gizem.yonetici;

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
import android.widget.Toast;

import com.example.psikolog_gizem.R;

public class yonetici_ekrani extends AppCompatActivity {
    private EditText yonetici_ekrani_e_posta;
    private EditText yonetici_ekrani_sifre;
    private Button yonetici_ekrani_giris_yap;
    private String DefaultID="mirac";
    private String DefaultPassword="3543";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_ekrani);

        getSupportActionBar().setTitle("YÖNETİCİ GİRİŞİ");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        yonetici_ekrani_e_posta=findViewById(R.id.yonetici_ekrani_e_posta);
        yonetici_ekrani_sifre=findViewById(R.id.yonetici_ekrani_sifre);
        yonetici_ekrani_giris_yap=findViewById(R.id.yonetici_ekrani_giris_yap);

        yonetici_ekrani_giris_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=yonetici_ekrani_e_posta.getText().toString();
                String sifre=yonetici_ekrani_sifre.getText().toString();

                if(yonetici_ekrani_e_posta.getText().toString().equals("")||
                        yonetici_ekrani_sifre.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(),"ALANLAR BOŞ BIRAKILAMAZ !", Toast.LENGTH_SHORT).show();

                }

                else if(DefaultID.equals(id)&&DefaultPassword.equals(sifre)){
                    Intent giris=new Intent(yonetici_ekrani.this, yonetici_karsilama_ekrani.class);
                    startActivity(giris);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"KULLANICI ADI VEYA ŞİFRE HATALI", Toast.LENGTH_LONG).show();

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