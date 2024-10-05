package com.example.myapplicationhtjtgj;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String ime1= getIntent().getStringExtra("ime1");
        String lozinka1= getIntent().getStringExtra("lozinka1");
        String ime2= getIntent().getStringExtra("ime2");
        String lozinka2= getIntent().getStringExtra("lozinka2");
        String ime3= getIntent().getStringExtra("ime3");
        String prezime1= getIntent().getStringExtra("prezime1");
        String email1= getIntent().getStringExtra("email1");





        findViewById(R.id.potvrda4).setOnClickListener(view -> {
            String potvrdaLozinke = ((EditText) findViewById(R.id.lozinka4)).getText().toString();

            if (potvrdaLozinke.equals(lozinka1) && potvrdaLozinke.equals(lozinka2)) {
                Toast.makeText(this, "Registracija uspešna", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Lozinke se ne podudaraju", Toast.LENGTH_LONG).show();
            }
        });

       findViewById(R.id.odustani4).setOnClickListener(view-> {
           finish();
       });
    }
}