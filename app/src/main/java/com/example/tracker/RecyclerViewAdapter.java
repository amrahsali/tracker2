package com.example.tracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<Mapitem> courseDataArrayList;
    private Context mcontext;

    public RecyclerViewAdapter(ArrayList<Mapitem> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlistview, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        //RecyclerData recyclerData = courseDataArrayList.get(position);
        Mapitem mapitem = courseDataArrayList.get(position);
        holder.courseTV.setText(mapitem.getName());
        String longitude = mapitem.getLongitude();
        String latitude = mapitem.getLatitude();
        String location = longitude + ", " + latitude;
        final String image = mapitem.getUri();
        try {
            Glide.with(mcontext).load(image).into(holder.courseIV);
        } catch (Exception e) {

        }

        holder.itemView.setOnClickListener(
                v -> {
                    String uri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + mapitem.getName() + ")";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                    mcontext.startActivity(intent);
                }
        );
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView courseTV;
        private ImageView courseIV;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTV = itemView.findViewById(R.id.idTVCourse);
            courseIV = itemView.findViewById(R.id.idIVcourseIV);
        }
    }
}

