package com.example.fragmenti;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FakultetiAdapter extends RecyclerView.Adapter<FakultetiAdapter.ViewHolder> {

    private List<String> fakulteti;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String fakultet);
    }

    public FakultetiAdapter(List<String> fakulteti, OnItemClickListener listener) {
        this.fakulteti = fakulteti;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Dinamički kreira TextView umesto inflatiranja iz XML-a
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setPadding(16, 16, 16, 16);
        textView.setTextSize(18); // Možeš prilagoditi tekstualni stil ovde
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String fakultet = fakulteti.get(position);
        holder.textView.setText(fakultet); // Postavlja tekst za trenutni fakultet

        holder.textView.setOnClickListener(v -> listener.onItemClick(fakultet));
    }

    @Override
    public int getItemCount() {
        return fakulteti.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView; // Pošto je itemView zapravo TextView
        }
    }
}


