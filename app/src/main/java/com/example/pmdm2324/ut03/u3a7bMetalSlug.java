package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pmdm2324.R;

public class u3a7bMetalSlug extends AppCompatActivity {

    public static final String ELECCIONJUGADOR = "ELECCION";
    ImageButton imgbtEri, imgbtMarco, imgbtTarma, imgbtFio;
    Button btLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7b_metal_slug);

        imgbtEri = findViewById(R.id.u3a7aidimgbtEri);
        imgbtFio = findViewById(R.id.u3a7aidimgbtFio);
        imgbtMarco = findViewById(R.id.u3a7aidimgbtMarco);
        imgbtTarma = findViewById(R.id.u3a7aidimgbtTarma);
        btLimpiar = findViewById(R.id.u3a7bidbtLimpiar);

        imgbtEri.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONJUGADOR, R.drawable.eri);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        imgbtFio.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONJUGADOR, R.drawable.fio);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        imgbtMarco.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONJUGADOR, R.drawable.marco);
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        imgbtTarma.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(ELECCIONJUGADOR, R.drawable.tarma);
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