package com.example.pmdm2324.Practicas.consumoApi;

import java.io.Serializable;

public class Actores implements Serializable {
    String url;
    String nombre;
    String pelicula;

    public Actores(String url, String nom, String pelicula){
        this.url = url;
        this.nombre = nom;
        this.pelicula = pelicula;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPelicula() {
        return pelicula;
    }
}
