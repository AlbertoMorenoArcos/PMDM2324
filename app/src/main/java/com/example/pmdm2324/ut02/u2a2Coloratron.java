package com.example.pmdm2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.pmdm2324.R;

public class u2a2Coloratron extends AppCompatActivity {

    EditText etEntrada;
    TextView tvSalida;
    TextView cambioColorTexto;
    Button btGenerar;
    SeekBar sbColorRojo;
    ToggleButton tbColorTexto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a2_coloratron);

        etEntrada = findViewById(R.id.u2a2idetIntroducir);
        tvSalida = findViewById(R.id.u2a2idtvMostrarTexto);
        cambioColorTexto = findViewById(R.id.u2a2idtvTextoBlancoNegro);
        btGenerar = findViewById(R.id.u2a2idbtGenerar);
        sbColorRojo = findViewById(R.id.u2a2idsbColorRojo);
        tbColorTexto = findViewById(R.id.u2a2idtbColorTexto);

        btGenerar.setOnClickListener((View v)->{
            String texto = etEntrada.getText().toString();
            tvSalida.setText(texto);

            if(tbColorTexto.isChecked()){
                tvSalida.setTextColor(000000);
            }else{
                tvSalida.setTextColor(FFFFFF);
            }

        });
    }
}