package com.example.whatisyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textname;
    TextView textscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String Nametext = intent.getStringExtra("name");
        int score = (int) intent.getDoubleExtra("Score",0);
        textname = (TextView) findViewById(R.id.textView5);
        textscore = (TextView) findViewById(R.id.textView6);
    }
}