package com.example.recyclerviewchangerordre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewchangerordre.databinding.ActivityMainBinding;

import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerView rv;
    PersonAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //rv = binding.rv;
        setContentView(binding.getRoot());
        InitRecycler();
        RemplirRecycler();

    }

    private void RemplirRecycler() {
        Person personne1 = new Person();
        personne1.Nom = "Jean";
        Person personne2 = new Person();
        personne2.Nom = "Alain";
        Person personne3 = new Person();
        personne3.Nom = "Paul";
        Person personne4 = new Person();
        personne4.Nom = "John";
        Collections.addAll(Adapter.list,personne1,personne2,personne3,personne4);
        Adapter.notifyDataSetChanged();
    }

    private void InitRecycler() {
        rv = binding.rv;
        rv.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        Adapter = new PersonAdapter();
        rv.setAdapter(Adapter);
        //essayer d'ajouter un line devider lors de l'initialisation de chaque vue du recycler
        //rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));

    }
}