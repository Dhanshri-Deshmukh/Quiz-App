package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class Mathsquiz extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "1. Find the sum of 111 + 222 + 333",
            " 2. Complete the sequence 13, 16, ……, 22.",
            "3. What is 50 divided by 5?" ,
            "4.What is cube of 5?",
            "5. What is 1/4 written as a decimal?",
            "6.Find the Missing Term in Multiples of 6 : 6, 12, 18, 24, _, 36, 42, _ 54, 60.",
            "7.What is the Next Prime Number after 7 ?",
            "8.Solve 3 + 6 × ( 5 + 4) ÷ 3 - 7",
            "9.Priya had 16 Red Balls, 2 Green Balls, 9  Blue Balls, and 1 Multicolor Ball. If He Lost 9 Red Balls, 1 Green Ball, and 3 Blue Balls. How Many Balls would be Left?",
            "10. How Many Months Have 120 Days?",

    };
    String answers[] = {"666","19","10","125","0.25","30, 48","11","14","15","4"};
    String opt[] = {
            " 700","66","666","0",
            "10","7","12","19",
            "10","20","6","5",
            "100","125","25","5999",
            "0","0.18","0.25","0.20",
            "30, 48","12,2","3,5","23,9",
            "11","12","13","None of the mentioned",
            "5","0","10","14",
            "45","15","3","89",
            "5","2","8","4"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathsquiz);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final TextView score = (TextView) findViewById(R.id.textView4);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();




        textView.setText("Welcome");

        // Now you can use the username as needed in your quiz activity
        // Toast.makeText(pythonquiz.this, "Welcome, " + fullName+ "!", Toast.LENGTH_SHORT).show();

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    // Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    //Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), mathres.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Category.class);
                startActivity(intent);
            }
        });
    }

}

