package com.example.pmdm2324.Practicas.consumoApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicePeliculas {
    private static ServicePeliculas instancia;
    private static ApiInterface API;
    private ServicePeliculas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.231:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API = retrofit.create(ApiInterface.class);
    }
    public static ApiInterface getAPI(){
        return API;
    }
    public static ServicePeliculas getInstancia(){
        if(instancia == null){
            instancia = new ServicePeliculas();
        }
        return instancia;
    }
}
