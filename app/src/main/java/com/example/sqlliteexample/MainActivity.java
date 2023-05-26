package com.example.sqlliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> name , password, id;
    RecylicerViewAdapter radapter;
    RecyclerView rv;
    DbHelper db;

    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DbHelper(MainActivity.this);
        rv = findViewById(R.id.recyclerView);

        btn = findViewById(R.id.add_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,User.class);
                startActivity(intent);
            }
        });
        id = new ArrayList<>();
        name = new ArrayList<>();
        password = new ArrayList<>();
        populateData();
        radapter = new RecylicerViewAdapter(id,password,name,MainActivity.this,db);
        rv.setAdapter(radapter);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    void populateData(){
        Cursor cursor =  db.getAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "NoData", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));

                password.add(cursor.getString(2));
            }
        }
    }
}