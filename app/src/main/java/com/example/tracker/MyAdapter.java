package com.example.tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<item> questionClickInterface;
    Context context;
    List<item> item;

    public MyAdapter(Context context, List<com.example.tracker.item> item) {
        this.context = context;
        this.item = item;
         ArrayList<item> itemArrayList;
         this.questionClickInterface = questionClickInterface;

        int lastPos = -1;




    }

    @NonNull
    @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Answer.setText(item.get(position).getAnswer());
        holder.Question.setText(item.get(position).getQuestion());
    }


    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView Question;
        private final TextView Answer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Question = itemView.findViewById(R.id.question);
            Answer = itemView.findViewById(R.id.answer);
}
}
}
