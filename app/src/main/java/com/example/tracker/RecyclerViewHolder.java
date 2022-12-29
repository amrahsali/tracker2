package com.example.tracker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    private TextView payer_name, amount;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        payer_name = itemView.findViewById(R.id.question);
        amount = itemView.findViewById(R.id.answer);


    }

    public TextView getPayer_name(){
        return payer_name;
    }

    public TextView getAmount(){
        return amount;
    }

}
