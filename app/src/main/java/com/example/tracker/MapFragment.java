package com.example.tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class MapFragment extends Fragment  {

    GridView coursesGV;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);


        coursesGV = view.findViewById(R.id.idlocations);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel("Muhammadu buhari gate", R.drawable.ic_round_school_24));
        courseModelArrayList.add(new CourseModel("Fnas", R.drawable.ic_round_school_24));
        courseModelArrayList.add(new CourseModel("Famss", R.drawable.ic_round_school_24));
        courseModelArrayList.add(new CourseModel("library", R.drawable.ic_round_school_24));
        courseModelArrayList.add(new CourseModel("admin complex", R.drawable.ic_round_school_24));
        courseModelArrayList.add(new CourseModel("school clinic", R.drawable.ic_round_school_24));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);


        return view;
    }

}