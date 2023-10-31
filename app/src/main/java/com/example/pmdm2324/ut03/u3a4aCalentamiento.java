package com.example.pmdm2324.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a4aCalentamiento extends AppCompatActivity {

    TextView tvNombre,tvMensaje;
    Button btObtenerNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a4a_calentamiento);
        tvNombre = findViewById(R.id.u3a4aidtvNombre);
        tvMensaje = findViewById(R.id.u3a4atvMensaje);
        btObtenerNombre = findViewById(R.id.u3a4abtObtenerNombre);

        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        String nombre = data.getStringExtra(u3a4bCalentamiento.CLAVE_NOMBRE);
                        if(!nombre.equals("")){
                            tvNombre.setText(nombre);
                            tvMensaje.setText("El usuario ha aceptado el nombre");
                            tvMensaje.setTextColor(Color.GREEN);
                        }else{
                            tvMensaje.setText("Has aceptado el nombre dejandolo en blanco.");
                            tvMensaje.setTextColor(Color.RED);
                        }



                    } else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        tvMensaje.setText("El usuario ha cancelado cancelado");
                        tvMensaje.setTextColor(Color.RED);
                    }else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        tvNombre.setText("Anonimo");
                        tvMensaje.setText("El usuario ha limpiado el nombre");
                        tvMensaje.setTextColor(Color.GREEN);
                    } else {
                        tvMensaje.setText("No obtenemos código");
                        tvMensaje.setTextColor(Color.RED);
                    }
                }
        );

        btObtenerNombre.setOnClickListener(view->{
            Intent i = new Intent(this, u3a4bCalentamiento.class);
            lanzador.launch(i);
        });
    }

}