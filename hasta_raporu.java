package com.example.psikolog_gizem.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.psikolog_gizem.R;

public class hasta_raporu extends AppCompatActivity {



    private TextView rapor_karsilama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_raporu);

        rapor_karsilama=findViewById(R.id.rapor_karsilama);

        Intent intent = getIntent();
        String rapor_alinan = intent.getStringExtra("rapor");

        rapor_karsilama.setText(rapor_alinan);
    }
}