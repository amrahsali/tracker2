package com.example.tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FactFragment extends Fragment {

    private RecyclerView recyclerView;


    public FactFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fact, container, false);

        recyclerView = view.findViewById(R.id.rvNumbers);


        List<item> item = new ArrayList<item>();
        item.add(new item("what is your name", "my name is amrah"));


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new MyAdapter(getActivity(), item));




        return inflater.inflate(R.layout.fragment_fact, container, false);
    }
}