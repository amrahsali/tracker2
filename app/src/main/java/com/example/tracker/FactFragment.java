package com.example.tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FactFragment extends Fragment {

    private FloatingActionButton addQuestionBtn;
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ProgressBar loadingPB;
    private ArrayList<item> courseRVModalArrayList;
    private MyAdapter  myAdapter;


    public FactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fact, container, false);

        // initializing all our variables.
        loadingPB = view.findViewById(R.id.idPBLoading);
        addQuestionBtn = view.findViewById(R.id.addQandA);
        firebaseDatabase = FirebaseDatabase.getInstance();
        courseRVModalArrayList = new ArrayList<>();


        //on below line we are getting database reference.

        // Add the following lines to create RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.rvNumbers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RandomNumListAdapter(1234));

        addQuestionBtn = view.findViewById(R.id.addQandA);



        addQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), AddQuestionsActivity.class);
                startActivity(i);

            }
        });

// on below line initializing our adapter class.
        myAdapter = new MyAdapter(getContext(), courseRVModalArrayList);
        // setting layout malinger to recycler view on below line.
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        // setting adapter to recycler view on below line.
        recyclerView.setAdapter(myAdapter);
        // on below line calling a method to fetch courses from database.
        getFact();

        //return inflater.inflate(R.layout.fragment_fact, container, false);
        return view;

    }
    private void getFact(){
        // on below line clearing our list.
        courseRVModalArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // on below line we are hiding our progress bar.
                loadingPB.setVisibility(View.GONE);
                // adding snapshot to our array list on below line.
                courseRVModalArrayList.add(snapshot.getValue(item.class));
                // notifying our adapter that data has changed.
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadingPB.setVisibility(View.GONE);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                myAdapter.notifyDataSetChanged();
                loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myAdapter.notifyDataSetChanged();
                loadingPB.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


}
}