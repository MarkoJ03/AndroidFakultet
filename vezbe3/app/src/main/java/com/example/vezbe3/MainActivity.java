package com.example.vezbe3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Kontakt> kontakti;  // Premesti kao polje klase
    private static final int EDIT_CONTACT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        kontakti = new ArrayList<>();  // Inicijalizacija liste kontakata

        // Klik događaj na dugme "Dodaj novi kontakt"
        findViewById(R.id.dodajKontakt).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CRUD_activity.class);
            startActivityForResult(intent, EDIT_CONTACT_REQUEST_CODE);  // Za dodavanje novog kontakta
        });

        // Prikaz kontakata prilikom kreiranja aktivnosti
        displayContacts();
    }

    // Metoda za prikaz kontakata
    private void displayContacts() {
        LinearLayout container = findViewById(R.id.containter);
        container.removeAllViews();  // Očisti postojeće kontakte

        for (int i = 0; i < kontakti.size(); i++) {
            final int index = i;  // Lokalna kopija promenljive 'i'

            LayoutInflater inflater = getLayoutInflater();
            View kontaktView = inflater.inflate(R.layout.kontakt, null);

            TextView imeTextView = kontaktView.findViewById(R.id.ime);
            TextView prezimeTextView = kontaktView.findViewById(R.id.prezime);
            TextView brojTextView = kontaktView.findViewById(R.id.broj);
            ImageView slika = kontaktView.findViewById(R.id.slika);

            Kontakt kontakt = kontakti.get(i);
            imeTextView.setText(kontakt.getIme());
            prezimeTextView.setText(kontakt.getPrezime());
            brojTextView.setText(kontakt.getBroj());

            // Klik događaj za uređivanje kontakta (koristi 'index' umesto 'i')
            kontaktView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, CRUD_activity.class);
                intent.putExtra("ime", kontakt.getIme());
                intent.putExtra("prezime", kontakt.getPrezime());
                intent.putExtra("broj", kontakt.getBroj());
                intent.putExtra("index", index);  // Prosljedi index za ažuriranje
                startActivityForResult(intent, EDIT_CONTACT_REQUEST_CODE);  // Za uređivanje kontakta
            });

            // Klik događaj za "Obriši" (koristi 'index' umesto 'i')
            kontaktView.findViewById(R.id.obrisiButton).setOnClickListener(v -> {
                kontakti.remove(index);  // Ukloni kontakt iz liste
                displayContacts();  // Ponovo prikaži kontakte
            });

            slika.setImageResource(R.drawable.download);
            slika.getLayoutParams().height = 300;
            slika.getLayoutParams().width = 300;

            container.addView(kontaktView);  // Dodaj generisani kontakt u prikaz
        }
    }

    // Dobijanje rezultata iz CRUD_activity (dodavanje ili uređivanje kontakta)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_CONTACT_REQUEST_CODE && resultCode == RESULT_OK) {
            String ime = data.getStringExtra("ime");
            String prezime = data.getStringExtra("prezime");
            String broj = data.getStringExtra("broj");
            int index = data.getIntExtra("index", -1);

            if (index == -1) {
                // Dodavanje novog kontakta
                kontakti.add(new Kontakt(ime, prezime, broj));
            } else {
                // Ažuriranje postojećeg kontakta
                Kontakt kontakt = kontakti.get(index);
                kontakt.setIme(ime);
                kontakt.setPrezime(prezime);
                kontakt.setBroj(broj);
            }

            displayContacts();  // Osvježi prikaz kontakata
        }
    }
}
