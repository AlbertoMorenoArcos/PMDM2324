package com.example.pmdm2324.ut06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut03.Monstruo;

public class ut06a2b_MostrarEstadio extends AppCompatActivity {

    TextView tvEstadio;
    Button btVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut06a2b_mostrar_estadio);
        tvEstadio = findViewById(R.id.ut06a2b_tvEstadio);
        btVolver = findViewById(R.id.ut06a2b_btVolver);

        Intent intent = getIntent();
        ut06a2_Estadio estadio = (ut06a2_Estadio) intent.getSerializableExtra(ut06a2_Estadio.CLAVE_ESTADIO);
        tvEstadio.setText(estadio.toString());

        btVolver.setOnClickListener((View v)-> finish());
    }
}