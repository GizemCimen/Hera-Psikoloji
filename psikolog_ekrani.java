package com.example.psikolog_gizem.psikolog;

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
import com.example.psikolog_gizem.hasta.hasta_ekrani;
import com.example.psikolog_gizem.hasta.hasta_karsilama_ekrani;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;

import java.util.ArrayList;

public class psikolog_ekrani extends AppCompatActivity {
    private EditText psikolog_ekran_e_posta;
    private EditText psikolog_ekran_sifre;



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
        psikolog_ekran_giris_yap=findViewById(R.id.psikolog_ekran_giris_yap);

        psikolog_ekran_giris_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=psikolog_ekran_e_posta.getText().toString();
                String password=psikolog_ekran_sifre.getText().toString();

                doktorlar doktor=new doktorlar();
                doktor.setdoktor_e_posta(username);
                doktor.setdoktor_sifre(password);

                VeriTabani veriTabani=new VeriTabani(psikolog_ekrani.this);
                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(),"ALANLAR BOŞ BIRAKILAMAZ", Toast.LENGTH_LONG).show();

                }
                else if(!veriTabani.DoktorGirisBilgileriniKontrolEt(doktor)){
                    Toast.makeText(getApplicationContext(),"KULLANICI ADI VEYA ŞİFRE HATALI", Toast.LENGTH_LONG).show();

                }
                else{
                    Intent giris=new Intent(psikolog_ekrani.this, psikolog_karsilama_ekrani.class);
                    giris.putExtra("e_posta",psikolog_ekran_e_posta.getText().toString());
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