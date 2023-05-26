package com.example.sqlliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylicerViewAdapter extends RecyclerView.Adapter<RecylicerViewAdapter.MyClass> {
    private ArrayList id,password,uname;
    private Context context;
    private DbHelper db;
    public RecylicerViewAdapter(ArrayList id,ArrayList password,ArrayList uname,Context context,DbHelper db){
        this.id = id;
        this.password = password;
        this.uname = uname;
        this.context = context;
        this.db = db;
    }
    @NonNull
    @Override
    public RecylicerViewAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item,parent,false);
        return new MyClass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylicerViewAdapter.MyClass holder, int position) {
        holder.tid.setText(String.valueOf(id.get(position)));
        holder.tname.setText(String.valueOf(uname.get(position)));
        holder.tpassword.setText(String.valueOf(password.get(position)));
        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = holder.getAdapterPosition();
                db.deleteUsers(String.valueOf(id.get(i)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyClass extends RecyclerView.ViewHolder {
        TextView tid,tname,tpassword;
        ConstraintLayout cl;

        public MyClass(@NonNull View itemView) {
            super(itemView);
            tname = itemView.findViewById((R.id.Name));
            tid = itemView.findViewById((R.id.id));
            tpassword = itemView.findViewById((R.id.password));
            cl = itemView.findViewById(R.id.layout_item);
        }

    }
}
