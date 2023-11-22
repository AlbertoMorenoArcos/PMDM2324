package com.example.pmdm2324.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut03.Monstruo;

public class ut04a2_ConfiguraMonstruo extends AppCompatActivity {

    EditText etNombre, etExtremidades,etColor;
    Button btCrear;
    ut04f2_ConfiguraMonstruo monstruo1, monstruo2, monstruo3, monstruo4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut04a2_configura_monstruo);
        etNombre = findViewById(R.id.ut4a2idetNombre);
        etExtremidades = findViewById(R.id.ut4a2idetExtremidades);
        etColor = findViewById(R.id.ut4a2idetColor);
        btCrear = findViewById(R.id.ut4a2idbtCrear);
        monstruo1 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo1);
        monstruo2 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo2);
        monstruo3 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo3);
        monstruo4 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo4);

        btCrear.setOnClickListener(view-> {
            String nombre = etNombre.getText().toString();
            String color = etColor.getText().toString();
            String etExtrem = etExtremidades.getText().toString();
            int extremidades = Integer.parseInt(etExtrem);
            Monstruo miMonstruo = new Monstruo(nombre,extremidades, color);
            monstruo1.setText(miMonstruo.toString());
            monstruo1.setColor(color);
            monstruo2.setText(miMonstruo.toString());
            monstruo2.setColor(color);
            monstruo3.setText(miMonstruo.toString());
            monstruo3.setColor(color);
            monstruo4.setText(miMonstruo.toString());
            monstruo4.setColor(color);
        });
    }
}