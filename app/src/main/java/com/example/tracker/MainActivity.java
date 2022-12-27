package com.example.tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);


        List<item> item = new ArrayList<item>();
        item.add(new item("what is your name", "my name is amrah"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), item));

        BottomNavigationView NavigationView;



        NavigationView = findViewById(R.id.NavigationView);
        NavigationView.setOnNavigationItemSelectedListener(this);

        NavigationView.setSelectedItemId(R.id.fact);

    }

    FactFragment fact = new FactFragment();
    MapFragment map = new MapFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.fact:
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, fact).commit();
                return true;

            case R.id.map:
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, map).commit();
                return true;

        }

        return false;


    }

}
