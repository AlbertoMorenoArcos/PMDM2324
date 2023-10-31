package com.example.pmdm2324.ut03;

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

public class u3a5aFibonacci extends AppCompatActivity {

    TextView tvNumero1, tvNumero2;
    Button btSiguiente;
    public static final String CLAVE_NUMERO1 = "Numero 1";
    public static final String CLAVE_NUMERO2 = "Numero 2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a5a_fibonacci);
        tvNumero1 = findViewById(R.id.u3a5aidtvNumero1);
        tvNumero2 = findViewById(R.id.u3a5aidtvNumero2);
        btSiguiente = findViewById(R.id.u3a5aidbtSiguiente);


        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent datosRecibidos = result.getData();

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        String suma = datosRecibidos.getStringExtra(u3a5bFibonacci.CLAVE_SUMA);
                        String n2 = tvNumero2.getText().toString();
                        tvNumero2.setText(suma);
                        tvNumero1.setText(n2);
                    }
                }
        );

        btSiguiente.setOnClickListener(view->{
            Intent i = new Intent(this, u3a5bFibonacci.class);
            i.putExtra(CLAVE_NUMERO1, tvNumero1.getText().toString());
            i.putExtra(CLAVE_NUMERO2, tvNumero2.getText().toString());
            lanzador.launch(i);
        });

    }
}