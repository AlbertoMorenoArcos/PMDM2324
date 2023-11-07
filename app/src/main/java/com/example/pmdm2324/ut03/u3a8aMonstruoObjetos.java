package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm2324.R;

import java.io.Serializable;
import com.example.pmdm2324.ut03.Monstruo;


public class u3a8aMonstruoObjetos extends AppCompatActivity{
    EditText etNombre, etExtremidades, etColor;
    Button btCrear;

    Monstruo miMonstruo = new Monstruo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a8a_monstruo_objetos);
        etNombre = findViewById(R.id.u3a8aidetNombre);
        etExtremidades = findViewById(R.id.u3a8aidetExtremidades);
        etColor = findViewById(R.id.u3a8aidetColor);
        btCrear = findViewById(R.id.u3a8aidbtCrear);

        miMonstruo.setNombre(etNombre.toString());
    }
}
