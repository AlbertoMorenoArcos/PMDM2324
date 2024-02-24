package com.example.pmdm2324.Practicas.consumoApi;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.List;

public class Peliculas implements Serializable {
    public String nombre;
    public String descripcion;
    public Integer estrellas;
    public List<Actores> listActores;
    public static final String CLAVE_PELICULAS = "peliculas";

    public Peliculas(String nom, String desc, Integer est, List<Actores> listAct){
        this.nombre = nom;
        this.descripcion = desc;
        this.estrellas = est;
        this.listActores = listAct;
    }
    public String toString() {
        StringBuilder actores = new StringBuilder();

        actores.append("Pelicula : " + nombre + "\n");
        actores.append("Descripcion : " + descripcion + "\n");
        actores.append("Estrellas : " + estrellas + "\n");
        actores.append("\n");
        if (!listActores.isEmpty()) {
            // Iteramos sobre la lista de actores
            for (Actores actor : listActores) {
                // Obtenemos los datos del actor actual
                String urlActor = actor.getUrl();
                String nombreActor = actor.getNombre();
                String peliculaActor = actor.getPelicula();

                // Añadimos la información del actor actual al StringBuilder
                actores.append("URL del actor: " + urlActor + "\n");
                actores.append("Nombre del actor: " + nombreActor + "\n");
                actores.append("Película del actor: " + peliculaActor + "\n");
                actores.append("\n"); // Añadimos un salto de línea entre cada actor
            }
        } else {
            actores.append("No hay datos de actores disponibles.\n");
        }

        return actores.toString();
    }


}
