package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private EditText username;
    private EditText mobile1;
    private EditText emailEdit;
    private EditText password;
    private Button btn1;
    private Button btn2;

    private FirebaseAuth mAuth;

    private DatabaseReference mydb;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        mobile1=findViewById(R.id.mobile1);
        emailEdit=findViewById(R.id.emailEdit);
        password=findViewById(R.id.password);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        mydb=FirebaseDatabase.getInstance().getReference().child("users");
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = username.getText().toString();
                String mobile = mobile1.getText().toString();
                String email = emailEdit.getText().toString();
                String pass = password.getText().toString();

                if (fullName.matches("[a-zA-Z]+")) {
                    Toast.makeText(Register.this, " Enter First and last Name", Toast.LENGTH_SHORT).show();
                } else if (!mobile.matches("\\d{10}")) {
                    Toast.makeText(Register.this, "Mobile Number must be 10 digits", Toast.LENGTH_SHORT).show();

                } else if (!email.endsWith("@gmail.com") || !email.contains("@")) {
                    Toast.makeText(Register.this, "Invalid Email Id format", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches("\\d{8}")) {
                    Toast.makeText(Register.this, "password must be 8 digits", Toast.LENGTH_SHORT).show();

                } else {
                    FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        String userId = mAuth.getCurrentUser().getUid();
                                        Toast.makeText(Register.this, "UID :" + userId, Toast.LENGTH_SHORT).show();


                                        RegModel reg = new RegModel(fullName, mobile, email, pass);
                                        mydb.child(userId).setValue(reg).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(Register.this, "Record inserted Successfully", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnCanceledListener(new OnCanceledListener() {
                                            @Override
                                            public void onCanceled() {
                                                Toast.makeText(Register.this, "Error Occurred..", Toast.LENGTH_SHORT).show();

                                            }
                                        });
                                    } else {
                                        Toast.makeText(Register.this, "Error Occured", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the LoginActivity
                Intent intent = new Intent(Register.this, LoginAct.class);
                startActivity(intent);
            }
        });


        // return 0;
    }
}
