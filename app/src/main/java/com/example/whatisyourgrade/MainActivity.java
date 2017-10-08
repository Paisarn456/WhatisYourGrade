package com.example.whatisyourgrade;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText,mScoreEditText;
    private Button mFindGradeButtton,mExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name_edit_text);
        mScoreEditText = (EditText) findViewById(R.id.score_edit_text);
        mFindGradeButtton = (Button) findViewById(R.id.findgrade_button);
        mExitButton = (Button) findViewById(R.id.exit_button);

        mFindGradeButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEditText.getText().toString();
                String scoreText = mScoreEditText.getText().toString();
                if(name.length() == 0){
                    mNameEditText.setError("ป้อนชื่อ");
                }else if(scoreText.length() == 0){
                    mScoreEditText.setError("ป้อนคะแนน");
                }
                int score = Integer.parseInt(scoreText.toString());
                String result = getGradeText(score);

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("Name",name);
                intent.putExtra("Score",result);
                startActivity(intent);
            }
        });
        /*mExitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("");
            }
        });*/


    }
    private String getGradeText(int score){
        String GradeText = " ";
        if(score < 49){
            GradeText = "F";
        }else if(score <= 59){
            GradeText = "D";
        }else if(score <= 69) {
            GradeText = "C";
        }else if(score <= 79){
            GradeText = "B";
        }else {
            GradeText = "A";
        }
        return GradeText;
        }
    }

