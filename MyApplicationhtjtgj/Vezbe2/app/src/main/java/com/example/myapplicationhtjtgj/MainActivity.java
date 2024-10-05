package com.example.myapplicationhtjtgj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Intent i = new Intent(this, MainActivity2.class);
        Button dugmePrijaviSe = findViewById(R.id.potvrda1);

        dugmePrijaviSe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                i.putExtra("ime", ((EditText) findViewById(R.id.ime1)).getText().toString());
                i.putExtra("lozinka", ((EditText) findViewById(R.id.lozinka1)).getText().toString());
                startActivity(i);
            }
        });

        findViewById(R.id.odustani1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
