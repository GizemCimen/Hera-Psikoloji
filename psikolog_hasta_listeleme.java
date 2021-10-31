package com.example.psikolog.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.psikolog.R;
import com.example.psikolog.veritabani.VeriTabani;
import com.example.psikolog.veritabani.doktorlar;
import com.example.psikolog.yonetici.yonetici_psikolog_listeleme;

import java.util.List;

public class psikolog_hasta_listeleme extends AppCompatActivity {
    private Button yonetici_psikolog_listele_button;
    private ListView yonetici_psikolog_listele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psikolog_hasta_listeleme);
        ListView yonetici_psikolog_liste =  findViewById(R.id.yonetici_psikolog_liste);
        yonetici_psikolog_listele_button=findViewById(R.id.yonetici_psikolog_listele_button);
        VeriTabani vt = new VeriTabani((psikolog_hasta_listeleme.this));
        List<doktorlar> vVeriler = vt.butunDoktorlarıGetir();



        yonetici_psikolog_listele_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}