package com.example.pmdm2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;

import com.example.pmdm2324.R;

public class ut08a2_suma extends AppCompatActivity {

    TextView tvResultado;
    EditText etNumero1,etNumero2;
    Button btSumar;
    ProgressBar pbCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut08a2_suma);

        etNumero1 = findViewById(R.id.ut08a2_idetNumero1);
        etNumero2 = findViewById(R.id.ut08a2_idetNumero2);
        tvResultado = findViewById(R.id.ut08a2_idtvResultado);
        btSumar = findViewById(R.id.ut08a2_idbtSumar);
        pbCargando = findViewById(R.id.ut08a2_idpbCargando);

        ut08a2_sumaViewModel vm = new ViewModelProvider(this).get(ut08a2_sumaViewModel.class);

        vm.getNumero().observe(this, integer -> {
            // Actualizar la interfaz
            if(integer == ut08a2_sumaViewModel.FAIL){
                tvResultado.setText("Error en el acceso a los datos");
            }else{
                tvResultado.setText("Resultado: "+integer);
            }
            pbCargando.setVisibility(View.INVISIBLE);
            tvResultado.setVisibility(View.VISIBLE);
            btSumar.setEnabled(true);
        });

        btSumar.setEnabled(false);

        btSumar.setOnClickListener((v)->{
            pbCargando.setVisibility(View.VISIBLE);
            tvResultado.setVisibility(View.INVISIBLE);
            btSumar.setEnabled(false);
            int n1 = Integer.parseInt(etNumero1.getText().toString());
            int n2 = Integer.parseInt(etNumero2.getText().toString());
            vm.cargaNumero(n1,n2);
        });
    }
}
