package com.example.recyclerviewchangerordre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {
    List<Person> list;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv;
        public ImageButton boutonUp;
        public ImageButton boutonDown;
        public Context context;
        public MyViewHolder(LinearLayout v) {
            super(v);
            tv = v.findViewById(R.id.tvNom);
            boutonUp = v.findViewById(R.id.btnUp);
            boutonDown = v.findViewById(R.id.btnDown);
            context = v.getContext();
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public PersonAdapter() {
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Person personneCourante = list.get(position);
        holder.tv.setText(personneCourante.Nom);

        holder.boutonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "pipo", Toast.LENGTH_SHORT).show();
                list.remove(personneCourante);


                notifyDataSetChanged();
            }
        });

        //la logique des cliques
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
