package com.example.pmdm2324.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
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

    ActivityResultLauncher<Intent> lanzador;
    public static final String FRASE = "fraseaenviar";
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

        tvResultado = findViewById(R.id.u3a6aidtvResultado);
        etTexto = findViewById(R.id.u3a6aidetTexto);
        btAnalizar = findViewById(R.id.u3a6abtAnalizar);

        btAnalizar.setOnClickListener(view ->{
            Intent i = new Intent(this, u3a6bAnalisisLetras.class);
            i.putExtra(u3a6aAnalisisLetras.FRASE, etTexto.getText().toString());
            lanzador.launch(i);
        });

        lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent dato = result.getData();
                        if(result.getResultCode() == Activity.RESULT_OK){
                            tvResultado.setText(dato.getStringExtra(u3a6bAnalisisLetras.CLAVE_ANALISIS));
                        }
                    }
                });


    }
}