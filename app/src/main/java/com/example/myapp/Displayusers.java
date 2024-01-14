package com.example.myapp;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Displayusers extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ListView lst;
    //private TextView uname, pass;
    //private EditText emailEdtText, searchEmp;
    //private String empEmail, searchEmpName;
    //private Button btnSearchEmp;
   // private DatabaseReference mydb = FirebaseDatabase.getInstance().getReference("users");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayusers);

        mAuth = FirebaseAuth.getInstance();
//        uname = findViewById(R.id.uname);
//        pass = findViewById(R.id.pass);
//        emailEdtText = findViewById(R.id.emailEdtText);
       // lst = findViewById(R.id.lstUser);
        //lst.setBackgroundColor(Color.WHITE);
        //  Button searchButton = findViewById(R.id.searchButton);
       // loadNamesToSpinner();


        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("users");

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> userList = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    RegModel user = snapshot.getValue(RegModel.class);
                    String name=user.getFullName();
                    userList.add(name);
                }

                // Assuming you have a ListView with the id listView
                ArrayAdapter<String> adapter = new ArrayAdapter<>(Displayusers.this, android.R.layout.simple_list_item_1, userList);
                ListView listView = findViewById(R.id.lstUser);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase", "Error fetching data", databaseError.toException());
            }
        });

//
    }



    }