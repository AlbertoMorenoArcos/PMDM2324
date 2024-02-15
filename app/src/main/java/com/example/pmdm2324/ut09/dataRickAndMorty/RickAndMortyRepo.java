package com.example.pmdm2324.ut09.dataRickAndMorty;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RickAndMortyRepo {
    @GET("/api/character/{id}")
    Call<Personaje> getCharacter(@Path("id") String id);
}
