package com.example.pmdm2324.Practicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.Practicas.consumoApi.Peliculas;
import com.example.pmdm2324.R;
import com.example.pmdm2324.ut06.ut06a2_Estadio;

public class MostrarContenidoPelis extends AppCompatActivity {

    TextView tvContenido;
    Button btVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contenido_pelis);
        tvContenido = findViewById(R.id.textoContenido);
        btVolver = findViewById(R.id.btVolver);

        Intent intent = getIntent();
        Peliculas pelicula = (Peliculas) intent.getSerializableExtra(Peliculas.CLAVE_PELICULAS);

        tvContenido.setText(pelicula.toString());

        btVolver.setOnClickListener((View v)-> finish());

    }
}