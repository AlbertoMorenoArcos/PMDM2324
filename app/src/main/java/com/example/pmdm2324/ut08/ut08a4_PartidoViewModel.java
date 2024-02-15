package com.example.pmdm2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ut08a4_PartidoViewModel  extends ViewModel {
    private static final double DELAY = 2000;

    private MutableLiveData<ut08a4_Partido[]> misPartidos;

    public LiveData<ut08a4_Partido[]> getPartidos() {
        if (misPartidos == null) {
            misPartidos = new MutableLiveData<ut08a4_Partido[]>();
            cargaPartidos();
        }
        return misPartidos;
    }

    public void cargaPartidos() {
        new Thread(
                () -> {
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        ut08a4_Partido[] t = ut08a4_Partido.generatePartidos(ut08a4_Partido.PARTIDOS_INICIALES);
                        misPartidos.postValue(t);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
