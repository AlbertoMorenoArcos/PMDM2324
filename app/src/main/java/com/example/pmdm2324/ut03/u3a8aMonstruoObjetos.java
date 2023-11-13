package com.example.pmdm2324.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm2324.R;

import java.io.Serializable;
import com.example.pmdm2324.ut03.Monstruo;


public class u3a8aMonstruoObjetos extends AppCompatActivity{

    EditText etNombre, etExtremidades, etColor;
    Button btCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a8a_monstruo_objetos);
        etNombre = findViewById(R.id.u3a8aidetNombre);
        etColor = findViewById(R.id.u3a8aidetColor);
        btCrear = findViewById(R.id.u3a8aidbtCrear);




        btCrear.setOnClickListener(view->{
            String nombre = etNombre.getText().toString();
            String color = etColor.getText().toString();
            Monstruo miMonstruo = new Monstruo(nombre,color);
            Intent i = new Intent(this, u3a8bMonstruoObjetos.class);
            i.putExtra(Monstruo.CLAVE_MONSTRUO, miMonstruo);
            startActivity(i);
        });
    }
}
