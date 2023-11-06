package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pmdm2324.R;

public class u3a7cMetalSlug extends AppCompatActivity {

    public static final String ELECCIONARMA = "ARMA";
    ImageButton imgbtArma1, imgbtArma2, imgbtArma3;
    Button btLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7c_metal_slug);

        imgbtArma1 = findViewById(R.id.u3a7aidimgbtArma1);
        imgbtArma2 = findViewById(R.id.u3a7aidimgbtArma2);
        imgbtArma3 = findViewById(R.id.u3a7aidimgbtArma3);
        btLimpiar = findViewById(R.id.u3a7cidbtLimpiar);

        imgbtArma1.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONARMA, R.drawable.arma1);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        imgbtArma2.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONARMA, R.drawable.arma_2);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        imgbtArma3.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONARMA, R.drawable.arma_3);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        btLimpiar.setOnClickListener(view -> {
            Intent data = new Intent();
            setResult(Activity.RESULT_FIRST_USER, data);
            finish();
        });
    }
}