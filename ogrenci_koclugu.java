package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ogrenci_koclugu extends AppCompatActivity {

    private TextView ogrenci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_koclugu);
        ogrenci=findViewById(R.id.ogrenci);
    }
}