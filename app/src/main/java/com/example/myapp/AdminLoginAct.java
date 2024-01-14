package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AdminLoginAct extends AppCompatActivity {



    private EditText email1;
    private EditText pass1;
    private Button btnlogin;
    private EditText textView;
    private Button btnregister;
    private Object view;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        email1 = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass);
        btnlogin = findViewById(R.id.seeuser);

        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = email1.getText().toString();
                String pass = pass1.getText().toString();

                if (!email.endsWith("@gmail.com") || !email.contains("@")) {
                    Toast.makeText(com.example.myapp.AdminLoginAct.this, "Invalid Email Id format", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches("\\d{8}")) {
                    Toast.makeText(com.example.myapp.AdminLoginAct.this, "password must be 8 digits", Toast.LENGTH_SHORT).show();

                } else {

                    if(email.equals("admin20@gmail.com")&&pass.equals("00000000"))
                    {
                        Toast.makeText(AdminLoginAct.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(AdminLoginAct.this, AllUser.class);
                       startActivity(intent);
                    }
                    else {
                        Toast.makeText(AdminLoginAct.this, "Email and Password does not match", Toast.LENGTH_SHORT).show();
                    }
                    // Registration is successful, you can add your registration logic here
                    //  Toast.makeText(com.example.quiz_app.AdminLoginAct.this, " Login successful", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}















