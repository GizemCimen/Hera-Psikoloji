package com.example.psikolog.hasta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.psikolog.R;

public class hasta_blog extends AppCompatActivity {

    private TextView hasta_blog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_blog);

        hasta_blog=findViewById(R.id.hasta_blog);
    }
}