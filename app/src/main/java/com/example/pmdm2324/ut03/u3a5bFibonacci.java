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

public class u3a5bFibonacci extends AppCompatActivity {

    public static final String CLAVE_SUMA = "Suma";
    TextView tvSuma;
    Button btOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a5b_fibonacci);
        tvSuma = findViewById(R.id.u3a5bidtvSuma);
        btOK = findViewById(R.id.u3a5bidbtOK);


        String numero1 = getIntent().getStringExtra(u3a5aFibonacci.CLAVE_NUMERO1);
        String numero2 = getIntent().getStringExtra(u3a5aFibonacci.CLAVE_NUMERO2);
        int suma;
        int n1 = Integer.parseInt(numero1);
        int n2 = Integer.parseInt(numero2);
        suma = n1 + n2;

        String stringSuma = String.valueOf(suma);
        tvSuma.setText(stringSuma);

        btOK.setOnClickListener(view->{
            Intent i= new Intent();
            i.putExtra(CLAVE_SUMA, tvSuma.getText().toString());
            setResult(Activity.RESULT_OK,i);
            finish();
        });

    }
}