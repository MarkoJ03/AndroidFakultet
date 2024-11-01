package com.example.fragmenti;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Predmeti#newInstance} factory method to
 * create an instance of this fragment.
 */

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Predmeti extends Fragment {

    private RecyclerView recyclerView;
    private PredmetiAdapter adapter;
    private List<String> predmetiList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate fragment layout
        View view = inflater.inflate(R.layout.fragment_predmeti, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewPredmeti);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get the selected faculty from arguments
        if (getArguments() != null) {
            String fakultet = getArguments().getString("fakultet");

            // Generate list of subjects (predmeti) based on the selected faculty
            predmetiList = getPredmetiForFakultet(fakultet);
        }

        // Provera da li je lista null i inicijalizacija prazne liste ako jeste
        if (predmetiList == null) {
            predmetiList = Arrays.asList(); // Inicijalizacija prazne liste
        }

        // Initialize adapter and set to RecyclerView
        adapter = new PredmetiAdapter(predmetiList);
        recyclerView.setAdapter(adapter);

        return view;
    }


    // Dummy method to get subjects for a selected faculty
    private List<String> getPredmetiForFakultet(String fakultet) {
        switch (fakultet) {
            case "Fakultet 1":
                return Arrays.asList("Predmet 1-1", "Predmet 1-2", "Predmet 1-3");
            case "Fakultet 2":
                return Arrays.asList("Predmet 2-1", "Predmet 2-2", "Predmet 2-3");
            case "Fakultet 3":
                return Arrays.asList("Predmet 3-1", "Predmet 3-2", "Predmet 3-3");
            default:
                return Arrays.asList("Nema predmeta");
        }
    }
}
