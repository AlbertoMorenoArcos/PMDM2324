package com.example.pmdm2324.ut03;



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
            String numero1 = etNumero1.getText().toString();
            String numero2 = etNumero2.getText().toString();
            boolean hayErrores = false;

            if (numero1.isEmpty()) {
                eNumero1.setText("Número 1 vacío.");
                hayErrores = true;
            } else {
                eNumero1.setText("");
            }

            if (numero2.isEmpty()) {
                eNumero2.setText("Número 2 vacío.");
                hayErrores = true;
            } else {
                eNumero2.setText("");
            }

            if (!rbSumar.isChecked() && !rbRestar.isChecked() && !rbMultiplicar.isChecked() && !rbDividir.isChecked()) {
                eRadio.setText("Selecciona una operación.");
                hayErrores = true;
            } else {
                eRadio.setText("");
            }

            if (!hayErrores) {
                Intent i = new Intent(this, u3a1bResultado.class);
                i.putExtra(INFO_NUMERO1, numero1);
                i.putExtra(INFO_NUMERO2, numero2);

                if (rbSumar.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbSumar.getText().toString());
                } else if (rbRestar.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbRestar.getText().toString());
                } else if (rbMultiplicar.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbMultiplicar.getText().toString());
                } else if (rbDividir.isChecked()) {
                    i.putExtra(INFO_OPERACION, rbDividir.getText().toString());
                }

                startActivity(i);
            }
        });

    }

}
