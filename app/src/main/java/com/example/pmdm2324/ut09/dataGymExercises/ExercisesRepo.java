package com.example.pmdm2324.ut09.dataGymExercises;

import com.example.pmdm2324.ut09.dataRickAndMorty.Personaje;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ExercisesRepo {
    @Headers({"X-Api-Key: vL4mPM3Y6nh8Ha90wN8Y9Q==YwgQ69NzQKvy0sxp"})
    @GET("/v1/exercises")
    public Call<JsonArray> getEjercicio(@Query("muscle")String musculo);
}
