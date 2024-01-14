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


public class androidquiz extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "1. Which company bought android?",
            " 2.Web browser available in android is based on\n",
            "3.Android is based on which kernel? " ,
            "4. Is Android available in ROM?",
            "5.Android is based on which language.",
            "6.What is android?",
            "7.Which of the following Dialog boxes are supported by Android? 1) AlertDialog 2) ProgressDialog ",
            "8. If you want to increase the whitespace between widgets, you will need to use the ____________ property",
            "9.In ___________, sender specifies type of receiver.",
            "10. ADB stands for"

    };
    String answers[] = {"Google","Open-source Webkit","Linux kernel","No","Java","Mobile Operating System","all of the above","Android:padding ","Implicit intent","Android Debug Bridge"};
    String opt[] = {
            "Google","Apple","Nokia","No Company",
            "chrome","firefox","Open-source Webkit","none of above",
            "Hybrid kernel","MAC kernel","Linux kernel","Open-source Webkit",
            "No","Yes","Both","none",
            "Java","python","C","html",
            "Databases","Desktop Operating System","Mobile Operating System","Programming Language",
            "1"," 1 and 2","all of the above","None of the mentioned",
            "Android:padding"," Android:autoText","Android:digits","Android:margin",
            "Implicit intent ","Explicit intent"," a and b","None of the mentioned",
            "Android data bridge","Android Debug Bridge ","Android Debug Bridgeses ","Application Debug Bridge"
    };


    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidquiz);

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
                    Intent in = new Intent(getApplicationContext(),androidresult.class);
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
