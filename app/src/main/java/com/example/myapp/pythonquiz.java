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



    public class pythonquiz extends AppCompatActivity {


        TextView tv;
        Button submitbutton, quitbutton;
        RadioGroup radio_g;
        RadioButton rb1, rb2, rb3, rb4;

        String questions[] = {
                "1)Who developed Python Programming Language?",
                " 2)Which type of Programming does Python support?",
                "3)Which of the following is the correct extension of the Python file?",
                "4)All keywords in Python are in _________",
                "5)Which keyword is used for function in Python language? ",
                "6)Python is a compiled language True or False?",
                "7)What are the two main types of functions in Python?",
                "8)What is the maximum length of a Python identifier?",
                "9)Python is object-oriented language True or False?",
                "10)Python is a high level language True or False?",

        };
        String answers[] = {"Guido van Rossum", "all of the mentioned", ".py", "lower case", "def", "False", "Built-in function and User defined function", "79", "True","True"};
        String opt[] = {
                " Wick van Rossum", "Rasmus Lerdorf", "Guido van Rossum", "Niene Stom",
                "object-oriented programming", "structured programming", "functional programming", "all of the mentioned",
                ".python", ".py", ".pythonb", ".pl",
                "Capitalized", "lower case", "UPPER CASE", "None of the mentioned",
                "Function", "def", "fun", "define",
                "True", "False", "Both", "none of above",
                "System function", "Custom function", "Built-in function and User defined function", "User function",
                "32", "79", "128", "No fixed length is specified",
                "True", "False", "Both", "none of above",
                "True", "False", "Both", "none of above"
        };
        int flag = 0;
        public static int marks = 0, correct = 0, wrong = 0;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pythonquiz);

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
                        Intent in = new Intent(getApplicationContext(), pythonresult.class);
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

