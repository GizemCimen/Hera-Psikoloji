package com.example.psikolog.yonetici;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.psikolog.R;

public class yonetici_ayarlar extends AppCompatActivity {

    private Button sistem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonetici_ayarlar);

        sistem=findViewById(R.id.sistem);
    }
}