package com.example.pmdm2324.ut03;

import static java.lang.Double.isNaN;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a1aLanzaCalculadora extends AppCompatActivity {

    Button btCalcular;
    EditText etNumero1, etNumero2;
    RadioButton rbSumar, rbRestar, rbMultiplicar, rbDividir;
    TextView eRadio, eNumero1, eNumero2;
    public static final String INFO_NUMERO1 = "numero1";
    public static final String INFO_NUMERO2 = "numero2";
    public static final String INFO_OPERACION = "operacion";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a1_lanzacalculadora);

        btCalcular = findViewById(R.id.u3a1idbtLanza);
        etNumero1 = findViewById(R.id.u3a1idetNumero1);
        etNumero2 = findViewById(R.id.u3a1idetNumero2);
        rbSumar = findViewById(R.id.u3a1idrbSumar);
        rbRestar = findViewById(R.id.u3a1idrbRestar);
        rbMultiplicar = findViewById(R.id.u3a1idrbMultiplicar);
        rbDividir = findViewById(R.id.u3a1idrbDividir);
        eRadio = findViewById(R.id.u3a1idtvErrorRadio);
        eNumero1 = findViewById(R.id.u3a1idtvErrorN1);
        eNumero2 = findViewById(R.id.u3a1idtvErrorN2);



        btCalcular.setOnClickListener(view -> {


            Intent i = new Intent(this, u3a1bResultado.class);

            String numero1 = etNumero1.getText().toString();
            String numero2 = etNumero2.getText().toString();
            i.putExtra(INFO_NUMERO1, numero1);
            i.putExtra(INFO_NUMERO2, numero2);

            if (!numero1.isEmpty() && !numero2.isEmpty()) {
                eNumero1.setText("");
                eNumero2.setText("");
                if (rbSumar.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbSumar.getText().toString());
                } else if (rbRestar.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbRestar.getText().toString());
                } else if (rbMultiplicar.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbMultiplicar.getText().toString());
                } else if (rbDividir.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbDividir.getText().toString());
                }
            } else {
                if (numero1.isEmpty()) {
                    eNumero1.setText("Numero 1 vacio.");
                }
                if (numero2.isEmpty()) {
                    eNumero2.setText("Numero 2 vacio.");
                }


            }


            startActivity(i);
        });

    }

}