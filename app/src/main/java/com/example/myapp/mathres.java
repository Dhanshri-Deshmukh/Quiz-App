package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;
//import android.support.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class mathres extends AppCompatActivity {
    TextView tv, tv2, tv3,ans;
    Button btnRestart,Home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathres);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.Restart);
        Home=(Button)findViewById(R.id.Home);
        ans=findViewById(R.id.ans);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + Mathsquiz.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " +  Mathsquiz.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " +  Mathsquiz.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Mathsquiz.correct=0;
        Mathsquiz.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Category.class);
                startActivity(in);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), mathcorrectans.class);
                startActivity(in);
            }
        });
    }

}
