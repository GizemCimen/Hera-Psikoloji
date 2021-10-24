package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class hamile_terapisi extends AppCompatActivity {
    private TextView hamile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamile_terapisi);
        hamile=findViewById(R.id.hamile);
    }
}