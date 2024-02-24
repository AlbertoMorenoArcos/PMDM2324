package com.example.pmdm2324.Practicas.consumoApi;



import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/api/peliculas_related/{id}")
    Call<JsonObject> getPelicula(@Path("id") int id);
}
