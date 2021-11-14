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
import android.widget.Toast;

import com.example.psikolog_gizem.R;
import com.example.psikolog_gizem.psikolog.psikolog_karsilama_ekrani;
import com.example.psikolog_gizem.psikolog.psikolog_profil_sayfasi;
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.hastalar;

import java.util.ArrayList;

public class hasta_profil_sayfasi extends AppCompatActivity {
    private EditText txt_hasta_adi;
    private EditText txt_hasta_soyadi;
    private EditText txt_hasta_telefon;
    private EditText txt_hasta_e_posta;
    private EditText txt_hasta_sifre;
    private Button button_hasta_guncelle;
    private ArrayList<hastalar> hastalarArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_profil_sayfasi);
        String gelen=getIntent().getStringExtra("name2");
        txt_hasta_adi=findViewById(R.id.txt_hasta_adi);
        txt_hasta_soyadi=findViewById(R.id.txt_hasta_soyadi);
        txt_hasta_telefon=findViewById(R.id.txt_hasta_telefon);
        txt_hasta_e_posta=findViewById(R.id.txt_hasta_e_posta);
        txt_hasta_sifre=findViewById(R.id.txt_hasta_sifre);
        button_hasta_guncelle=findViewById(R.id.button_hasta_guncelle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("PROFİL ");
        VeriTabani veriTabani=new VeriTabani(hasta_profil_sayfasi.this);
        hastalarArrayList=veriTabani.butunHastalarıGetir();
        int length=hastalarArrayList.size();
        String[] ad=new String[length];
        String[] soyad=new String[length];
        String[] telefon=new String[length];
        String[] eposta = new String[length];
        String[] sifre=new String[length];


        for (int i=0; i<length; i++){
            ad[i]=hastalarArrayList.get(i).gethasta_adi();
            soyad[i]=hastalarArrayList.get(i).gethasta_soyadi();
            telefon[i]=hastalarArrayList.get(i).gethasta_telefon();
            eposta[i]=hastalarArrayList.get(i).gethasta_e_posta();
            sifre[i]=hastalarArrayList.get(i).gethasta_sifre();


            if(eposta[i].equals(gelen)){
                txt_hasta_adi.setText(ad[i]);
                txt_hasta_soyadi.setText(soyad[i]);
                txt_hasta_telefon.setText(telefon[i]);
                txt_hasta_e_posta.setText(eposta[i]);
                txt_hasta_sifre.setText(sifre[i]);

            }
        }
        button_hasta_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_hasta_adi.getText().equals("")||
                        txt_hasta_soyadi.getText().equals("")||
                        txt_hasta_telefon.getText().equals("")||
                        txt_hasta_e_posta.getText().equals("")||
                        txt_hasta_sifre.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"ALANLAR BOŞ BIRAKILAMAZ !",Toast.LENGTH_SHORT).show();
                }
                else{
                    hastalar hasta=new hastalar(txt_hasta_adi.getText().toString(),txt_hasta_soyadi.getText().toString(),txt_hasta_telefon.getText().toString(),txt_hasta_e_posta.getText().toString(),txt_hasta_sifre.getText().toString());
                    veriTabani.HastaGuncelle(hasta);
                    Toast.makeText(getApplicationContext(),"GÜNCELLEME BAŞARILI !",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(hasta_profil_sayfasi.this, hasta_karsilama_ekrani.class);
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