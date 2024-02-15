package com.example.pmdm2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;

import com.example.pmdm2324.R;

public class ut08a3_ParesNones extends AppCompatActivity {

    TextView tvNMaquina,tvResultado;
    EditText etNumeroJugador;
    RadioButton rbPares, rbNones;
    Button btJugar;
    ProgressBar pbCargando;
    public static final int MAX_NUM = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut08a3_paresnones);

        etNumeroJugador = findViewById(R.id.ut08a3_idetNJugador);
        tvResultado = findViewById(R.id.ut08a3_idtvResultado);
        tvNMaquina = findViewById(R.id.ut08a3_idtvNMaquina);
        btJugar = findViewById(R.id.ut08a3_idbtJugar);
        pbCargando = findViewById(R.id.ut08a3_idpbCargando);
        rbPares = findViewById(R.id.ut08a3_idrbPares);
        rbNones = findViewById(R.id.ut08a3_idrbNones);

        ut08a3_ParesNonesViewModel vm = new ViewModelProvider(this).get(ut08a3_ParesNonesViewModel.class);

        vm.getNumero().observe(this, string -> {
            // Actualizar la interfaz
            if(string == ut08a3_ParesNonesViewModel.FAIL){
                tvResultado.setText("Error en el acceso a los datos");
            }else{
                tvResultado.setText("Resultado: "+string);
                tvResultado.setVisibility(View.VISIBLE);
                tvNMaquina.setVisibility(View.VISIBLE);
            }
            pbCargando.setVisibility(View.INVISIBLE);
            btJugar.setEnabled(true);
        });

        tvResultado.setVisibility(View.INVISIBLE);
        tvNMaquina.setVisibility(View.INVISIBLE);
        btJugar.setEnabled(false);


        btJugar.setOnClickListener((v)->{
            pbCargando.setVisibility(View.VISIBLE);
            tvResultado.setVisibility(View.INVISIBLE);
            tvNMaquina.setVisibility(View.INVISIBLE);
            btJugar.setEnabled(false);
            int nJugador = Integer.parseInt(etNumeroJugador.getText().toString());
            int nMaquina = (int) (Math.random() * MAX_NUM);
            String opcion = "";
            if(rbPares.isChecked()){
                opcion = (String) rbPares.getText();
            }else if(rbNones.isChecked()){
                opcion = (String) rbNones.getText();
            }
            tvNMaquina.setText("La maquina ha sacado: " + String.valueOf(nMaquina));
            vm.cargaRespuesta(nJugador, nMaquina,opcion);
        });
    }

}
