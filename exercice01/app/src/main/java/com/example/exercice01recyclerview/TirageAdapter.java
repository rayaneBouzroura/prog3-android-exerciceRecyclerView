package com.example.exercice01recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercice01recyclerview.databinding.TirageItemBinding;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TirageAdapter extends RecyclerView.Adapter<TirageAdapter.ViewHolder> {
    public  static List<Tirage> listeTirage;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Context context;
        public TextView tvTirage;
        public TextView tvLettre;
        public TextView tvNumeroTirer;
        public Random r;

        public ViewHolder(LinearLayout v) {
            super(v);

            tvTirage = v.findViewById(R.id.tirageTv);
            tvLettre = v.findViewById(R.id.lettreBingoTv);
            tvNumeroTirer = v.findViewById(R.id.numTirerTv);
            context = v.getContext();
        }

//        public TextView getTextView() {
//            return textView;
//        }
    }


    public TirageAdapter() {
        listeTirage = Collections.emptyList();
    }


    // Create new views (invoked by the layout manager)
    @Override
    public TirageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tirage_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i("DEBOGAGE", "appel a onCreateViewHolder");
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //generer un tri
        Tirage tirageCourant = listeTirage.get(position);
        int tri = viewHolder.r.nextInt(75);
        tirageCourant.numTirer = tri;
        char Lettre = convertirChiffreLettre(tri);
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvTirage.setText("Tirage #"+tirageCourant.id);
        viewHolder.tvLettre.setText(Lettre);
        viewHolder.tvNumeroTirer.setText("Numero tiré :"+tirageCourant.numTirer);

    }

    private char convertirChiffreLettre(int tri) {

        if(tri >= 1 && tri <= 15) return  'B';
        if(tri >= 16 && tri <= 30) return  'I';
        if(tri >= 31 && tri <= 45) return  'N';
        if(tri >= 46 && tri <= 60) return  'G';
        if(tri >= 61 && tri <= 75) return  'O';
        else return 'F';

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listeTirage.size();
    }
}