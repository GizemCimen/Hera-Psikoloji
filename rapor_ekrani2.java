package com.example.herapsikoloji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class rapor_ekrani2 extends AppCompatActivity {
    private TextView rapor;
    private Button kaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapor_ekrani2);

        kaydet=findViewById(R.id.kaydet);
        rapor=findViewById(R.id.rapor);
    }
}