package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class cift_aile_terapisi extends AppCompatActivity {

    private TextView cift_aile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cift_aile_terapisi);
        cift_aile=findViewById(R.id.cift_aile);
    }
}