package com.example.psikolog.yonetici;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.psikolog.R;

public class ergen_terapisi extends AppCompatActivity {
    private TextView ergen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergen_terapisi);
        ergen=findViewById(R.id.ergen);
    }
}