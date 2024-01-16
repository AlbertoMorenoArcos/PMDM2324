package com.example.pmdm2324.ut06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pmdm2324.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;

    public class ut06a1_ListaPartidos extends AppCompatActivity {

        RecyclerView reyclerViewUser;
        Button add;
        ut06a1_PartidoAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ut06a1_lista_partidos);

            reyclerViewUser = (RecyclerView) findViewById(R.id.ut06a2_ListaContenedorEstadios);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
            reyclerViewUser.setLayoutManager(layoutManager);

            adapter = new ut06a1_PartidoAdapter(ut06a1_Partido.generatePartidos(ut06a1_Partido.PARTIDOS_INICIALES));
            reyclerViewUser.setAdapter(adapter);

            add = findViewById(R.id.ut06a2_btAñadir);
            add.setOnClickListener(view -> adapter.add(ut06a1_Partido.generatePartidos(ut06a1_Partido.PARTIDOS_INICIALES)));

            //adapter.notifyDataSetChanged();
        }
    }