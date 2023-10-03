package com.example.pmdm2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.pmdm2324.R;

public class u2a2Coloratron extends AppCompatActivity {

    EditText etEntrada;
    TextView tvSalida, tvColores, tvBlanco;
    Button btGenerar;
    SeekBar sbColorRojo, sbColorVerde, sbColorAzul;
    ToggleButton tbColorTexto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a2_coloratron);

        etEntrada = findViewById(R.id.u2a2idetIntroducir);
        tvSalida = findViewById(R.id.u2a2idtvMostrarTexto);
        tvBlanco = findViewById(R.id.u2a2idtvBlanco);
        tvColores = findViewById(R.id.u2a2idtvColores);
        btGenerar = findViewById(R.id.u2a2idbtGenerar);
        sbColorRojo = findViewById(R.id.u2a2idsbColorRojo);
        sbColorVerde = findViewById(R.id.u2a2idsbColorVerde);
        sbColorAzul = findViewById(R.id.u2a2idsbColorAzul);
        tbColorTexto = findViewById(R.id.u2a2idtbColorTexto);



        sbColorRojo.setBackgroundColor(Color.RED);
        sbColorVerde.setBackgroundColor(Color.GREEN);
        sbColorAzul.setBackgroundColor(Color.BLUE);

        tbColorTexto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvSalida.setTextColor(Color.WHITE);
                } else {
                    tvSalida.setTextColor(Color.BLACK);
                }
            }
        });
       
        btGenerar.setOnClickListener((View v)->{
            int rojo = sbColorRojo.getProgress();
            int verde = sbColorVerde.getProgress();
            int azul = sbColorAzul.getProgress();

            String texto = etEntrada.getText().toString();
            tvSalida.setText(texto);
            tvSalida.setBackgroundColor(Color.rgb(rojo,verde,azul));


        });
    }
}