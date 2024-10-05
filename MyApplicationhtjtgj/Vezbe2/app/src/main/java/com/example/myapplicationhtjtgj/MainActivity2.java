package com.example.myapplicationhtjtgj;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent i = new Intent(this, MainActivity3.class);
        String ime1= getIntent().getStringExtra("ime");
        String lozinka1= getIntent().getStringExtra("lozinka");

        findViewById(R.id.potvrda2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("ime1",ime1);
                i.putExtra("lozinka1",lozinka1);
                i.putExtra("ime2",((EditText) findViewById(R.id.ime2)).getText().toString());
                i.putExtra("lozinka2",((EditText) findViewById(R.id.lozinka2)).getText().toString());
                startActivity(i);
                finish();
            }
        });

    findViewById(R.id.odustani2).setOnClickListener(view ->{
        finish();
    });
    }
}