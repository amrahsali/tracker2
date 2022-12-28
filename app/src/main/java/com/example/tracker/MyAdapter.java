package com.example.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<item> item;

    public MyAdapter(Context context, List<com.example.tracker.item> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override

    public int getItemViewType(final int position) {
        return R.layout.fact_text;
        }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.fact_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.Question.setText(item.get(position).getQuestion());
        holder.Answer.setText(item.get(position).getAnswer());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
