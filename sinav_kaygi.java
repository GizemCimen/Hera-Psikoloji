package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class sinav_kaygi extends AppCompatActivity {

    private TextView sinav_kaygi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinav_kaygi);

        sinav_kaygi=findViewById(R.id.sinav_kaygi);
    }
}