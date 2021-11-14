package com.example.psikolog_gizem.hasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.psikolog_gizem.R;

public class bildirim_karsilama_ekrani extends AppCompatActivity {
    private TextView bildirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirim_karsilama_ekrani);
        bildirim=findViewById(R.id.bildirim);

        Intent intent = getIntent();
        String bildirim_alinan = intent.getStringExtra("bildirim");

        bildirim.setText(bildirim_alinan);

    }
}