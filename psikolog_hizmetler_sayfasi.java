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
import com.example.psikolog_gizem.veritabani.VeriTabani;
import com.example.psikolog_gizem.veritabani.doktorlar;
import com.example.psikolog_gizem.veritabani.hizmetler;
import com.example.psikolog_gizem.yonetici.yonetici_psikolog_ekleme_sayfasi;

import java.util.ArrayList;

public class psikolog_hizmetler_sayfasi extends AppCompatActivity {
        private EditText hizmet_adi_txt;
        private EditText hizmet_aciklama_txt;
        private Button hizmet_kaydet_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_hizmetler_sayfasi);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("HİZMET EKLE");
        final VeriTabani vt=new VeriTabani(psikolog_hizmetler_sayfasi.this);
        hizmet_adi_txt=findViewById(R.id.hizmet_adi_txt);
        hizmet_aciklama_txt=findViewById(R.id.hizmet_aciklama_txt);
        hizmet_kaydet_button=findViewById(R.id.hizmet_kaydet_button);

        hizmet_kaydet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(hizmet_adi_txt.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"HİZMET ADI BOŞ BIRAKILAMAZ !", Toast.LENGTH_LONG).show();

                }
                else {
                hizmetler hizmet=new hizmetler(
                        hizmet_adi_txt.getText().toString(),
                        hizmet_aciklama_txt.getText().toString());
                vt.HizmetEkle(hizmet);
                    Toast.makeText(getApplicationContext(), "HİZMET EKLENDİ", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(psikolog_hizmetler_sayfasi.this,psikolog_karsilama_ekrani.class);
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