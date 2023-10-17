package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a1bResultado extends AppCompatActivity {

    TextView tvSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a1b_resultado);

        tvSalida = findViewById(R.id.u3a1idtvSalida);


        Bundle info = getIntent().getExtras();

        String numero1 = info.getString(u3a1aLanzaCalculadora.INFO_NUMERO1);
        String numero2 = info.getString(u3a1aLanzaCalculadora.INFO_NUMERO2);
        String operacion = info.getString(u3a1aLanzaCalculadora.INFO_OPERACION);
        int resultado;

        int n1 = Integer.parseInt(numero1);
        int n2 = Integer.parseInt(numero2);


        if (operacion.equals("Sumar")){
            resultado = n1+n2;
            String res= Integer.toString(resultado);
            tvSalida.setText(n1 + "+" + n2 + "=" + res);
        } else if (operacion.equals("Restar")) {
            resultado = n1-n2;
            String res= Integer.toString(resultado);
            tvSalida.setText(n1 + "-" + n2 + "=" + res);
        }
        else if (operacion.equals("Multiplicar")) {
            resultado = n1*n2;
            String res= Integer.toString(resultado);
            tvSalida.setText(n1 + "*" + n2 + "=" + res);
        }
        else if (operacion.equals("Dividir")) {
            resultado = n1/n2;
            String res= Integer.toString(resultado);
            tvSalida.setText(n1 + "/" + n2 + "=" + res);
        }

    }
}