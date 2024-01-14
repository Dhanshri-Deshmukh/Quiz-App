package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginAct extends AppCompatActivity {



    private EditText emailEdit;
    private EditText password;
    private EditText fullName;
    private Button blogin;
    private EditText textView1;
    private Button bregister;


    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEdit = findViewById(R.id.emailEdit);
        password = findViewById(R.id.password);
       blogin=findViewById(R.id.blogin);
        bregister = findViewById(R.id.user);
        auth = FirebaseAuth.getInstance();


        bregister.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String pass = password.getText().toString();

                if (!email.endsWith("@gmail.com") || !email.contains("@")) {
                    Toast.makeText(LoginAct.this, "Invalid Email Id format", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches("\\d{8}")) {
                    Toast.makeText(LoginAct.this, "password must be 8 digits", Toast.LENGTH_SHORT).show();

                } else {

                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                try {
                                    Intent intent = new Intent(LoginAct.this, Category.class);

                                    intent.putExtra("USERNAME", (CharSequence) fullName);
                                    startActivity(intent);
                                    finish();
                                }catch (Exception e) {
                                    Toast.makeText(LoginAct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(LoginAct.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            }
        });








        // Registration is successful, you can add your registration logic here

        //   Intent intent = new Intent(LoginAct.this, selectquiz.class);
        //  startActivity(intent);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the LoginActivity
                Intent intent = new Intent(LoginAct.this, Register.class);
                startActivity(intent);
            }
        } );

//
        // return 0;
    }
}














