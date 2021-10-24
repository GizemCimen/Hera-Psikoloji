package com.example.psikolog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class yorum_ekrani extends AppCompatActivity {

    private EditText yorum;
    private Button yorumyap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum_ekrani);
        yorum=findViewById(R.id.yorum);
        yorumyap=findViewById(R.id.yorumyap);
    }
}