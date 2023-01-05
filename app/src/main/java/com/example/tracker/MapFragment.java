package com.example.tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MapFragment extends Fragment  {

    GridView coursesGV;
    private RecyclerView recyclerView;
    private ArrayList<Mapitem> recyclerDataArrayList;
    private FloatingActionButton addMap;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerViewAdapter adapter;


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
        addMap = view.findViewById(R.id.addmap);
        firebaseDatabase = FirebaseDatabase.getInstance();

        addMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), AddMapActivity.class);
                startActivity(i);

            }
        });

        // created new array list..
        recyclerDataArrayList = new ArrayList<>();

        // added data to array list
//        recyclerDataArrayList.add(new RecyclerData("Fnas", R.drawable.ic_round_school_24));
//        recyclerDataArrayList.add(new RecyclerData("Famms", R.drawable.ic_round_school_24));
//        recyclerDataArrayList.add(new RecyclerData("Library", R.drawable.ic_round_school_24));
//        recyclerDataArrayList.add(new RecyclerData("admin complex", R.drawable.ic_round_school_24));
//        recyclerDataArrayList.add(new RecyclerData("clinic", R.drawable.ic_round_school_24));

        // added data from arraylist to adapter class.
        adapter = new RecyclerViewAdapter(recyclerDataArrayList,getActivity());

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        databaseReference = firebaseDatabase.getReference("Locations");
        // on below line calling a method to fetch courses from database.
        getMap();


        return view;
    }

    private void getMap(){
        // on below line clearing our list.
        recyclerDataArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // on below line we are hiding our progress bar.
                //loadingPB.setVisibility(View.GONE);
                // adding snapshot to our array list on below line.
                recyclerDataArrayList.add(snapshot.getValue(Mapitem.class));
                // notifying our adapter that data has changed.
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
               // loadingPB.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                adapter.notifyDataSetChanged();
               // loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                adapter.notifyDataSetChanged();
                //loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}