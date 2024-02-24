package com.example.pmdm2324.Practicas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm2324.Practicas.RecyclerPeliculas.PeliculasAdapter;
import com.example.pmdm2324.Practicas.RecyclerPeliculas.PeliculasViewModel;
import com.example.pmdm2324.Practicas.consumoApi.Actores;
import com.example.pmdm2324.Practicas.consumoApi.Peliculas;
import com.example.pmdm2324.Practicas.consumoApi.ServicePeliculas;
import com.example.pmdm2324.R;
import com.example.pmdm2324.ut06.ut06a2_Estadio;
import com.example.pmdm2324.ut06.ut06a2b_MostrarEstadio;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActividadPeliculas extends AppCompatActivity {

    RecyclerView rvPeliculas;
    Button botonPelis;
    PeliculasAdapter adapter;
    ProgressBar pbCargando;
    EditText seleccion;
    TextView tvError;
    private PeliculasViewModel peliculasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_peliculas);

        rvPeliculas = (RecyclerView) findViewById(R.id.recyclerPeliculas);
        pbCargando = findViewById(R.id.pbCargandoPelis);
        seleccion = findViewById(R.id.seleccionPelicula);
        tvError = findViewById(R.id.tvError);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        rvPeliculas.setLayoutManager(layoutManager);


        botonPelis = findViewById(R.id.botonPeliculas);

        peliculasViewModel = new ViewModelProvider(this).get(PeliculasViewModel.class);

        peliculasViewModel.getCargando().observe(this, cargando -> {
            if (cargando) {
                pbCargando.setVisibility(View.VISIBLE);
            } else {
                pbCargando.setVisibility(View.GONE);
            }
        });
        botonPelis.setOnClickListener((v)->{

            String pelicula = seleccion.getText().toString();
            if(pelicula == null | pelicula.equals("")) {
                tvError.setText("Introduce un id de pelicula.");
            }else{
                peliculasViewModel.setCargando(true);
                ServicePeliculas ser = ServicePeliculas.getInstancia();
                Call<JsonObject> llamada = ser.getAPI().getPelicula(Integer.parseInt(pelicula));

                llamada.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject listaPeliculas = response.body();
                            List<Peliculas> listPelis = parseJson(listaPeliculas);


                            adapter = new PeliculasAdapter(listPelis);
                            rvPeliculas.setAdapter(adapter);

                            adapter.setOnItemClickListener(new PeliculasAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(Peliculas pelicula) {
                                    Intent i = new Intent(ActividadPeliculas.this, MostrarContenidoPelis.class);
                                    i.putExtra(Peliculas.CLAVE_PELICULAS, pelicula);
                                    startActivity(i);
                                }
                            });

                        }
                        peliculasViewModel.setCargando(false);
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.e("Fallo", "No se puede acceder a la api");
                        peliculasViewModel.setCargando(false);
                    }
                });
            }

        });

    }
    private List<Peliculas> parseJson(JsonObject listaPeliculas){
        List<Peliculas> listaPelis = new ArrayList<>();

        String nombrePeli = listaPeliculas.get("nombre").getAsString();
        String descripcion = listaPeliculas.get("descripcion").getAsString();
        Integer estrellas = listaPeliculas.get("estrellas").getAsInt();
        JsonArray listaActores = listaPeliculas.get("actores").getAsJsonArray();

        List<Actores> actoresList = new ArrayList<>();
        for (JsonElement element : listaActores) {
            JsonObject actoresObject = element.getAsJsonObject();
            String url = actoresObject.get("url").getAsString();
            String nombre = actoresObject.get("nombre").getAsString();
            String pelicula = actoresObject.get("pelicula").getAsString();

            Actores actor = new Actores(url, nombre, pelicula);
            actoresList.add(actor);
        }

        listaPelis.add(new Peliculas(nombrePeli,descripcion,estrellas,actoresList));

        return listaPelis;

    }
}
