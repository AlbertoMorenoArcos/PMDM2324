package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a2aHelatron extends AppCompatActivity {

    EditText etVainilla, etChocolate, etFresa;
    Spinner spRecipiente;
    Button btElegir;
    public static final String INFO_CHOCO = "chocolate";
    public static final String INFO_FRESA = "fresa";
    public static final String INFO_VAINILLA = "vainilla";
    public static final String INFO_SPINNER = "spinner";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a2a_helatron);

        etChocolate = findViewById(R.id.u3a2idetBolasVaini);
        etFresa = findViewById(R.id.u3a2idetBolasFresa);
        etVainilla = findViewById(R.id.u3a2idetBolasVaini);
        spRecipiente = findViewById(R.id.u3a2idspRecipiente);
        btElegir = findViewById(R.id.u3a2idbtElegir);
        Intent i = new Intent(this, u3a1bResultado.class);

        btElegir.setOnClickListener(view -> {



                startActivity(i);
            }
        });



    }
}