package com.example.myapplicationhtjtgj;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent i = new Intent(this, MainActivity4.class);
        String ime1= getIntent().getStringExtra("ime1");
        String lozinka1= getIntent().getStringExtra("lozinka1");
        String ime2= getIntent().getStringExtra("ime2");
        String lozinka2= getIntent().getStringExtra("lozinka2");

        findViewById(R.id.potvrda3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("ime1",ime1);
                i.putExtra("lozinka1",lozinka1);
                i.putExtra("ime2",ime2);
                i.putExtra("lozinka2",lozinka2);
                i.putExtra("ime3",((EditText) findViewById(R.id.ime3)).getText().toString());
                i.putExtra("email1",((EditText) findViewById(R.id.email1)).getText().toString());
                i.putExtra("prezime1",((EditText) findViewById(R.id.prezime1)).getText().toString());
                startActivity(i);
                finish();
            }
        });

        findViewById(R.id.odustani3).setOnClickListener(view ->{
            finish();
        });
    }
}