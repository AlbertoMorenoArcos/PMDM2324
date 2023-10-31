package com.example.pmdm2324.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a6aAnalisisLetras extends AppCompatActivity {

    public static final String CLAVE_TEXTO = "Texto";
    TextView tvResultado;
    EditText etTexto;

    Button btAnalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a6a_analisis_letras);
        tvResultado = findViewById(R.id.u3a6aidtvResultado);
        etTexto = findViewById(R.id.u3a6aidetTexto);
        btAnalizar = findViewById(R.id.u3a6abtAnalizar);

        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent datosRecibidos = result.getData();

                    if (result.getResultCode() == Activity.RESULT_OK) {


                    }
                }
        );

        btAnalizar.setOnClickListener(view->{
            Intent i = new Intent(this, u3a5bFibonacci.class);
            i.putExtra(CLAVE_TEXTO, etTexto.getText().toString());
            lanzador.launch(i);
        });

    }
}