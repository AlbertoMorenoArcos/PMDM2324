package com.example.pmdm2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ut08a2_sumaViewModel extends ViewModel {
    private static final double DELAY = 2000;
    public static final Integer FAIL = -1;

    public static final int numero1 = 0;
    public static final int numero2 = 0;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero(){
        if(misDatos == null){
            misDatos = new MutableLiveData<Integer>();
            cargaNumero(numero1,numero2);
        }
        return misDatos;
    }

    public void cargaNumero(int n1, int n2) {
        // Magia de threads!!! Ulver está feliz :)
        new Thread(
                ()->{
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        // He recibido los datos (simulando petición remota)
                        int i = n1 + n2;
                        // ¿?
                        misDatos.postValue(i);
                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                        //throw new RuntimeException(e);
                    }
                }
        ).start();
    }
}