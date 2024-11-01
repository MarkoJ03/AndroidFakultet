package com.example.fragmenti;

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
 * Use the {@link Fakulteti#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fakulteti extends Fragment {

    private RecyclerView recyclerView;
    private FakultetiAdapter adapter;
    private List<String> fakultetiList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate fragment layout
        View view = inflater.inflate(R.layout.fragment_fakulteti, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewFakulteti);

        // Set LayoutManager (LinearLayoutManager for vertical scrolling)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Dummy data for faculties
        fakultetiList = Arrays.asList("Fakultet 1", "Fakultet 2", "Fakultet 3");

        // Initialize adapter and handle item click
        adapter = new FakultetiAdapter(fakultetiList, new FakultetiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String fakultet) {
                // Call method in MainActivity to display courses for the selected faculty
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity)getActivity()).displayPredmeti(fakultet);
                }
            }
        });

        // Set adapter to RecyclerView
        recyclerView.setAdapter(adapter);

        return view; // Return the view
    }
}
