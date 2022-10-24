package com.example.exercice01recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.exercice01recyclerview.databinding.ActivityMainBinding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<Tirage> listeTirage = Collections.emptyList();
    TirageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //initialiser les vues des recycleurs
        initRecycler();
        remplirRecycler();

    }

    private void remplirRecycler() {
//        for (int i=1;i<5;i++){
//            adapter.listeTirage.add(new Tirage(i));
//        }
//        Tirage t = new Tirage();
//        t.id = 1;
//        adapter.listet
//        adapter.notifyDataSetChanged();
    }

    private void initRecycler() {
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setHasFixedSize(true);

        //linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //specifie un adapter
        adapter = new TirageAdapter();
        recyclerView.setAdapter(adapter);
    }
}