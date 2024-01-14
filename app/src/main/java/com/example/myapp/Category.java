package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_category);
            // MainActivity.java

            // Assuming you have a button with the ID "btnOpenRules" in your activity_main.xml




            findViewById(R.id.bpython).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // new Rules();
                    Intent i = new Intent(Category.this, pythonquiz.class);

                    startActivity(i);
                }
            });

            findViewById(R.id.bmath).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // new Rules();
                    Intent i = new Intent(Category.this,Mathsquiz.class);
                    startActivity(i);
                }
            });
            findViewById(R.id.bphp).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // new Rules();
                    Intent i = new Intent(Category.this, PHPquiz.class);
                    startActivity(i);
                }
            });
            findViewById(R.id.bandroid).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // new Rules();
                    Intent i = new Intent(Category.this, androidquiz.class);
                    startActivity(i);
                }
            });

            //return 0;
        }
    }




