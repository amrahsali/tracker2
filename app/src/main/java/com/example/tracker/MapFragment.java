package com.example.tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class MapFragment extends Fragment  {

    GridView coursesGV;
    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

//
//        coursesGV = view.findViewById(R.id.idlocations);
//        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
//
//        courseModelArrayList.add(new CourseModel("Muhammadu buhari gate", R.drawable.ic_round_school_24));
//        courseModelArrayList.add(new CourseModel("Fnas", R.drawable.ic_round_school_24));
//        courseModelArrayList.add(new CourseModel("Famss", R.drawable.ic_round_school_24));
//        courseModelArrayList.add(new CourseModel("library", R.drawable.ic_round_school_24));
//        courseModelArrayList.add(new CourseModel("admin complex", R.drawable.ic_round_school_24));
//        courseModelArrayList.add(new CourseModel("school clinic", R.drawable.ic_round_school_24));
//
//        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
//        coursesGV.setAdapter(adapter);

        recyclerView = view.findViewById(R.id.idCourseRV);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new RecyclerData("Fnas", R.drawable.ic_round_school_24));
        recyclerDataArrayList.add(new RecyclerData("Famms", R.drawable.ic_round_school_24));
        recyclerDataArrayList.add(new RecyclerData("Library", R.drawable.ic_round_school_24));
        recyclerDataArrayList.add(new RecyclerData("admin complex", R.drawable.ic_round_school_24));
        recyclerDataArrayList.add(new RecyclerData("clinic", R.drawable.ic_round_school_24));

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,getActivity());

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }

}