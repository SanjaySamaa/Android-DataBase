package com.example.sqlliteexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecylicerViewAdapter extends RecyclerView.Adapter<RecylicerViewAdapter.MyClass> {

    @NonNull
    @Override
    public RecylicerViewAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item,parent,false);
        return new MyClass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylicerViewAdapter.MyClass holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyClass extends RecyclerView.ViewHolder {
        TextView tid,tname,tpassword;

        public MyClass(@NonNull View itemView) {
            super(itemView);
            tname = itemView.findViewById((R.id.name));
            tid = itemView.findViewById((R.id.id));
            tpassword = itemView.findViewById((R.id.password));
        }

    }
}
