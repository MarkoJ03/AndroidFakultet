package com.example.fragmenti;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.fragmenti.R;


public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Postavi početni fragment za fakultete u 'fakultetiContainer'
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fakultetiContainter, new Fakulteti())
                    .commit();
        }

        // Metoda za prikaz predmeta u 'predmetiContainer'
        public void displayPredmeti(String fakultet) {
            Predmeti predmetiFragment = new Predmeti();
            Bundle args = new Bundle();
            args.putString("fakultet", fakultet);
            predmetiFragment.setArguments(args);

            // Zameni sadržaj 'predmetiContainer' sa Predmeti fragmentom
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.predmetiContainter, predmetiFragment) // Ovde koristiš predmetiContainer
                    .commit();
        }
    }





