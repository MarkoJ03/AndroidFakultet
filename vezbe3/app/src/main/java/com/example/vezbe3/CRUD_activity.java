package com.example.vezbe3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CRUD_activity extends AppCompatActivity {

    private int contactIndex = -1;  // Po defaultu, -1 znači da dodajemo novi kontakt

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crud);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText imeEditText = findViewById(R.id.imeInput);
        EditText prezimeEditText = findViewById(R.id.prezimeInput);
        EditText brojEditText = findViewById(R.id.brojInput);

        Intent intent = getIntent();
        if (intent.hasExtra("ime")) {
            imeEditText.setText(intent.getStringExtra("ime"));
            prezimeEditText.setText(intent.getStringExtra("prezime"));
            brojEditText.setText(intent.getStringExtra("broj"));

            // Ako uređujemo postojeći kontakt, preuzimamo i index
            if (intent.hasExtra("index")) {
                contactIndex = intent.getIntExtra("index", -1);
            }
        }

        // Dugme za čuvanje unosa
        findViewById(R.id.potvrdiButton).setOnClickListener(v -> {
            // Prikupimo nove ili izmenjene podatke
            String novoIme = imeEditText.getText().toString();
            String novoPrezime = prezimeEditText.getText().toString();
            String noviBroj = brojEditText.getText().toString();

            // Pripremamo rezultat koji šaljemo nazad
            Intent resultIntent = new Intent();
            resultIntent.putExtra("ime", novoIme);
            resultIntent.putExtra("prezime", novoPrezime);
            resultIntent.putExtra("broj", noviBroj);

            if (contactIndex != -1) {
                // Ako uređujemo kontakt, vraćamo i index
                resultIntent.putExtra("index", contactIndex);
            }

            setResult(RESULT_OK, resultIntent);  // Postavi rezultat koji će MainActivity primiti
            finish();  // Zatvori ovu aktivnost i vrati se nazad u MainActivity
        });
    }
}
