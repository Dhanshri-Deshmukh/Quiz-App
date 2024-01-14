package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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


public class PHPquiz extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "1.What does PHP stand for?",
            "2.How do you write \"Hello World\" in PHP?",
            "3.All variables in PHP start with which symbol?\n",
            "4.What is the correct way to end a PHP statement?",
            "5.In PHP you can use both single quotes ( ' ' ) and double quotes ( \" \" ) for strings:\n" +
                    "\n",
            "6.What is the correct way to include the file \"time.inc\" ?",
            "7.What is the correct way to create a function in PHP?",
            "8.What is the correct way to add 1 to the $count variable?",
            "9.Which one of these variables has an illegal name?\n" +
                    "\n",
            "10.php file save in which extension\n" +
                    "\n?"
    };
    String answers[] = {"PHP: Hypertext Preprocessor" ,"echo \"Hello World\"","$",";","True","<?php include \"time.inc\";?>","function myFunction()","$count++;","$my-Var" +
            "",".php"
    };

    String opt[] = {
            "persnal page","PHP: Hypertext Preprocessor","Hypertext Preprocessor page","Hypertext Page",
            "echo \"Hello World\"","none","echo \"hello\"",".",
            "/","+","@","$",
            ",",";","[]","-",
            "false","both","True","none of above",
            "<?php include \"time.inc\"; ?>","<?php include \"time.inc\" ?>","<php include \"time.inc\"; ?>","<?php include \"time.inc\">",
            "Function myFunction()","fun myFunction()","function myFunction()","function myFunction();",
            "$count++","$count++;","$count","None of the mentioned",
            "@my-Var","1my-Var","my-Var","$my-Var",
            ".php",".ph","..php",".html"

    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phpquiz);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        //String name= intent.getStringExtra("myname");

        //if (name.trim().equals(""))
        textView.setText("Welcome");
        // else
        //textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
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

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    //Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    //Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),phpres.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Category.class);
                startActivity(intent);
            }
        });
    }

}
