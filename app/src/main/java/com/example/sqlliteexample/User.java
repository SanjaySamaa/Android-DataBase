package com.example.sqlliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class User extends AppCompatActivity {
    Button btn;
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = name.getText().toString();
                String upassword = password.getText().toString();

                DbHelper myDB = new DbHelper(User.this);
                myDB.insertUsers(uname,upassword);
            }
        });

    }
}