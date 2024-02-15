package com.example.pmdm2324.ut08;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class ut08a3_ParesNonesViewModel extends ViewModel {
    private static final double DELAY = 2000;
    public static final String FAIL = "ERROR";

    String rPartida = "";
    public static final int numJugador = 0;
    public static final int numMaquina = 0;
    public static final String opcion = "";
    private MutableLiveData<String> misDatos;

    public LiveData<String> getNumero() {
        if (misDatos == null) {
            misDatos = new MutableLiveData<String>();
            cargaRespuesta(numJugador, numMaquina, opcion);
        }
        return misDatos;
    }

    public void cargaRespuesta(int nJugador, int nMaquina, String opcionJugador) {

        new Thread(
                () -> {
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        // He recibido los datos (simulando petición remota)
                        // ¿?

                        int resultado = nJugador + nMaquina;
                        String rFinal = "";

                        if (resultado % 2 == 0) {
                            rFinal = "Pares";
                        } else {
                            rFinal = "Nones";
                        }


                        if (!Objects.equals(opcionJugador, rFinal) && rPartida.equals("")) {
                            rPartida = "";
                        } else if (!Objects.equals(opcionJugador, rFinal) && !rPartida.equals("")) {
                            rPartida = "Ha ganado la máquina.";
                        } else {
                            rPartida = "¡Has ganado!";
                        }
                        misDatos.postValue(rPartida);
                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                        //throw new RuntimeException(e);
                    }
                }
        ).start();
    }
}