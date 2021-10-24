package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class cocuk_psikolojisi extends AppCompatActivity {

    private TextView metin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocuk_psikolojisi);

        metin=findViewById(R.id.metin);
    }
}