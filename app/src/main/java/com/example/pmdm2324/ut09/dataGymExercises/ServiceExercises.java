package com.example.pmdm2324.ut09.dataGymExercises;

import com.example.pmdm2324.ut09.dataRickAndMorty.RickAndMortyRepo;
import com.example.pmdm2324.ut09.dataRickAndMorty.ServiceRickAndMorty;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceExercises {
    private static ServiceExercises instancia;
    private static ExercisesRepo repo;
    private ServiceExercises(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.api-ninjas.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(ExercisesRepo.class);
    }
    public static ExercisesRepo getRepo(){
        return repo;
    }
    public static ServiceExercises getInstancia(){
        if(instancia == null){
            instancia = new ServiceExercises();
        }
        return instancia;
    }
}
