package com.example.tracker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView Question, Answer;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        Question = itemView.findViewById(R.id.question);
        Answer = itemView.findViewById(R.id.answer);
    }
}
