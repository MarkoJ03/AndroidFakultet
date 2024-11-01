package com.example.fragmenti;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PredmetiAdapter extends RecyclerView.Adapter<PredmetiAdapter.ViewHolder> {

    private List<String> predmeti;

    public PredmetiAdapter(List<String> predmeti) {
        this.predmeti = predmeti;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Dinamički kreira TextView za svaki predmet
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setPadding(16, 16, 16, 16);
        textView.setTextSize(18); // Možeš prilagoditi stil
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Postavlja naziv predmeta za trenutni red
        String predmet = predmeti.get(position);
        holder.textView.setText(predmet);
    }

    @Override
    public int getItemCount() {
        return predmeti.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView; // Pošto je itemView zapravo TextView
        }
    }
}
