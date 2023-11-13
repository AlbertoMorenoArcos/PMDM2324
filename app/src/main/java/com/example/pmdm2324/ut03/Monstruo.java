package com.example.pmdm2324.ut03;

import java.io.Serializable;
import java.util.Random;

public class Monstruo implements Serializable {
    public static final String CLAVE_MONSTRUO = "monstruo";
    private String nombre;
    private int manos;
    private int piernas;
    private String color;

    public Monstruo(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.manos = generarNumeroAleatorio(1, 10); // Número aleatorio entre 1 y 4 para las manos
        this.piernas = generarNumeroAleatorio(1, 10); // Número aleatorio entre 1 y 4 para las piernas
    }
    public String getColor() {
        return color;
    }

    private int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public String toString() {
        StringBuilder monstruo = new StringBuilder();

        monstruo.append("Nombre: ").append(nombre).append("\n");
        monstruo.append("Color: ").append(color).append("\n");
        monstruo.append("Manos: ").append(manos).append("\n");
        monstruo.append("Piernas: ").append(piernas).append("\n");

        monstruo.append("   *\n");

        for (int i = 0; i < piernas; i++) {
            monstruo.append("// ");
        }
        monstruo.append("\n");

        for (int i = 0; i < piernas; i++) {
            monstruo.append("///");
        }
        monstruo.append(" \\\\\n");

        return monstruo.toString();
    }
}
