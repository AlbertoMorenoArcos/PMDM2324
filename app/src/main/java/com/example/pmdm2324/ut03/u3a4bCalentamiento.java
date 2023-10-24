package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm2324.R;

public class u3a4bCalentamiento extends AppCompatActivity {


    EditText etNombre;
    Button btAceptar, btCancelar, btLimpiar;
    public static final String CLAVE_NOMBRE = "Nombre";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a4b_calentamiento);

        etNombre = findViewById(R.id.u3a4bidetNombre);
        btAceptar = findViewById(R.id.u3a4bidbtAceptar);
        btCancelar = findViewById(R.id.u3a4bidbtCancelar);
        btLimpiar = findViewById(R.id.u3a4bidbtLimpiar);
        Intent data = new Intent();
        btAceptar.setOnClickListener(view->{
            data.putExtra(CLAVE_NOMBRE, etNombre.getText().toString());
            setResult(Activity.RESULT_OK, data);
            finish();
        });

        btCancelar.setOnClickListener(view->{
            setResult(Activity.RESULT_CANCELED, data);
            finish();
        });

        btLimpiar.setOnClickListener(view->{
            data.putExtra(CLAVE_NOMBRE, "");
            setResult(Activity.RESULT_FIRST_USER, data);
            finish();
        });
    }

}