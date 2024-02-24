package com.example.pmdm2324.Practicas.RecyclerPeliculas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm2324.Practicas.consumoApi.Peliculas;
import com.example.pmdm2324.ut08.ut08a4_Partido;

public class PeliculasViewModel extends ViewModel {
    private static final double DELAY = 2000;

    private MutableLiveData<Boolean> cargando;

    public LiveData<Boolean> getCargando() {
        if (cargando == null) {
            cargando = new MutableLiveData<Boolean>();
            setCargando(false);
        }
        return cargando;
    }

    public void setCargando(boolean estado) {
        cargando.setValue(estado);
    }
}
