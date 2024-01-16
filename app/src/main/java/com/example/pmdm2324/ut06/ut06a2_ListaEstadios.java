package com.example.pmdm2324.ut06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.R;

public class ut06a2_ListaEstadios  extends AppCompatActivity {

    RecyclerView rcv;
    ut06a2_EstadioAdapter a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut06a2_lista_estadios);

        rcv = findViewById(R.id.ut06a2_ListaContenedorEstadios);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        a = new ut06a2_EstadioAdapter(ut06a2_Estadio.generador());
        rcv.setAdapter(a);

        a.setClickListener(new ut06a2_EstadioAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, ut06a2_Estadio estadio) {
                ut06a2_Estadio miEstadio = new ut06a2_Estadio(estadio.getNombre(), estadio.getN_Aficionados(), estadio.getNacion(), estadio.getEquipo(), estadio.getCiudad());

                Intent i = new Intent(ut06a2_ListaEstadios.this, ut06a2b_MostrarEstadio.class);
                i.putExtra(ut06a2_Estadio.CLAVE_ESTADIO, miEstadio);
                startActivity(i);
            }
        });
    }
}
