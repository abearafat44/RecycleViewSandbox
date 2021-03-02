package com.example.recycleviewsandbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter.RecyclerViewClickListener listener;
    private List<ItemTemplate> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListener();
        recyclerView= findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        myList.add(new ItemTemplate("Vic"));
        myList.add(new ItemTemplate("Seb"));
        myList.add(new ItemTemplate("Abe"));
        myList.add(new ItemTemplate("Intern"));

        CustomAdapter adapter = new CustomAdapter(myList, listener);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setOnClickListener() {
        listener = new CustomAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Log.d("MainActivity",myList.get(position).getTitle());
            }
        };
    }
}