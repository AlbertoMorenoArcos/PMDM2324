package com.example.pmdm2324.ut06;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm2324.R;

public class ut06_ListaDulces extends AppCompatActivity {

    RecyclerView reyclerViewUser;
    Button add;
    ut06_DulcesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut06a1_lista_partidos);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut06a2_ListaContenedorEstadios);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new ut06_DulcesAdapter(ut06_DulcesNavideños.generateDulces(ut06_DulcesNavideños.DULCES_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.ut06a2_btAñadir);
        add.setOnClickListener(view -> adapter.add(ut06_DulcesNavideños.generateDulces(ut06_DulcesNavideños.DULCES_INICIALES)));

        //adapter.notifyDataSetChanged();
    }
}