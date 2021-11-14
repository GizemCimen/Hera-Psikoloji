package com.example.psikolog_gizem.hasta;

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
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.hastalar;

import java.util.ArrayList;

public class hasta_ekrani extends AppCompatActivity {
    private EditText hasta_giris_e_posta;
    private EditText hasta_giris_sifre;

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
        hasta_giris_giris_yap_buton=findViewById(R.id.hasta_giris_giris_yap_buton);


        hasta_giris_giris_yap_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=hasta_giris_e_posta.getText().toString();
                String password=hasta_giris_sifre.getText().toString();

                hastalar hasta=new hastalar();
                hasta.sethasta_e_posta(username);
                hasta.sethasta_sifre(password);
                VeriTabani veriTabani=new VeriTabani(hasta_ekrani.this);


                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(),"ALANLAR BOŞ BIRAKILAMAZ", Toast.LENGTH_LONG).show();

                }
                else if(!veriTabani.HastaGirisBilgileriniKontrolEt(hasta)){
                    Toast.makeText(getApplicationContext(),"KULLANICI ADI VEYA ŞİFRE HATALI", Toast.LENGTH_LONG).show();

                }
                else{


                    Intent giris=new Intent(hasta_ekrani.this, hasta_karsilama_ekrani.class);
                    giris.putExtra("key",hasta_giris_e_posta.getText().toString());

                    startActivity(giris);
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