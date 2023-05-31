package com.example.sqlliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    String id,name,password;
    EditText uname,upassword;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        populateUI();
        populateData();
    }
    public void populateData(){
        id = getIntent().getStringExtra("uid");
        name = getIntent().getStringExtra("uname");
        password = getIntent().getStringExtra("upassword");
        uname.setText(name);
        upassword.setText(password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper db = new DbHelper(Update.this);
//                db.updateUsers("updated user","updated password",id);
                db.updateUsers(String.valueOf(uname.getText()),String.valueOf(upassword.getText()),id);
            }
        });


    }
    public void populateUI(){
         uname = findViewById(R.id.update_name);
         upassword = findViewById(R.id.update_password);
         btn=findViewById(R.id.btnupdate);
    }

}