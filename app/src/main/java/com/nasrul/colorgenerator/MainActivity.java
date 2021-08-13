package com.nasrul.colorgenerator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nasrul.colorgenerator.adapter.WarnaAdapter;
import com.nasrul.colorgenerator.model.GenWarna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements WarnaAdapter.OnCardClickListener {

    private RecyclerView recyclerView;
    private WarnaAdapter adapter;
    private ArrayList<GenWarna> warna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        warna = new ArrayList<>();

        adapter = new WarnaAdapter(warna);
        adapter.setListener(this);
        recyclerView = findViewById(R.id.recview);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            warna.add(new GenWarna());
            adapter.notifyItemChanged(warna.size());
        });
    }

    @Override
    public void onClick(View v, int posisi) {
        GenWarna warnatext = warna.get(posisi);
        Toast.makeText(this, warnatext.getTextwarna(),Toast.LENGTH_SHORT).show();
    }
}