package com.example.pmdm2324.ut08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pmdm2324.R;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ut08a4_RecyclerConMV extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button add;
    ut08a4_PartidoAdapter adapter;
    TextView tvError;
    ProgressBar pbCargando;
    String añadir = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut08a4_recyclermv_partidos);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut08a4_RecyclerPartidos);
        tvError = findViewById(R.id.ut08a4_idtvError);
        pbCargando = findViewById(R.id.ut08a4_idpbCargando);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new ut08a4_PartidoAdapter(ut08a4_Partido.generatePartidos(ut08a4_Partido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.ut08a4_btAñadir);


        ut08a4_PartidoViewModel vm = new ViewModelProvider(this).get(ut08a4_PartidoViewModel.class);


        vm.getPartidos().observe(this, ArrayList -> {
            // Actualizar la interfaz
            if(añadir == "activado"){
                adapter.add(ArrayList);
            }
            pbCargando.setVisibility(View.INVISIBLE);
            add.setEnabled(true);
        });
        add.setEnabled(false);


        add.setOnClickListener((v) -> {
            pbCargando.setVisibility(View.VISIBLE);
            añadir = "activado";
            add.setEnabled(false);
            vm.cargaPartidos();
        });
        //adapter.notifyDataSetChanged();
    }
}
