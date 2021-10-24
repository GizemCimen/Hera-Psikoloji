package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class emdr_terapi extends AppCompatActivity {
    private TextView emdr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emdr_terapi);
        emdr=findViewById(R.id.emdr);
    }
}