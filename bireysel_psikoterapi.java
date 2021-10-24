package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class bireysel_psikoterapi extends AppCompatActivity {

    private TextView bireysel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bireysel_psikoterapi);
        bireysel=findViewById(R.id.bireysel);
    }
}