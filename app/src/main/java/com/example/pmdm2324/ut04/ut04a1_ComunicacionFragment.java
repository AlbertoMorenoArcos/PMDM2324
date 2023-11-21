package com.example.pmdm2324.ut04;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm2324.R;

public class ut04a1_ComunicacionFragment extends AppCompatActivity {


    ImageButton tick;
    ut04f1_ComunicacionFragment fragment;
    TextView color;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut04a1_comunicacion_fragment);
        tick = findViewById(R.id.u4a1idimbttick);
        color = findViewById(R.id.u4a1idtvcolor);

        //getFragmentManager().getFragments() // Esto devuelve list
        fragment = (ut04f1_ComunicacionFragment) getSupportFragmentManager().findFragmentById(R.id.ut0401idfragment1);

        tick.setOnClickListener((View)->{
            fragment.setColor(0x77, 0xFF, 00, 0xFF);
            fragment.setText("Truco de magia con esta cadena mágica");
        });

        fragment.setColorChangeListener(
                (int c)-> color.setText("Funciona asqueroso " + String.valueOf(c))
        );
    }
}