package com.example.pmdm2324.ut08;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ut08a1_numeroaleatorioViewModel extends ViewModel {
    private static final double DELAY = 2000;
    private static final int MAX_NUM = 10000;
    public static final Integer FAIL = -1;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero(){
        if(misDatos == null){
            misDatos = new MutableLiveData<Integer>();
            cargaNumero();
        }
        return misDatos;
    }

    public void cargaNumero() {
        new Thread(
                ()->{
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        int i = (int) (Math.random() * MAX_NUM);
                        misDatos.postValue(i);
                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                    }
                }
        ).start();
    }
}