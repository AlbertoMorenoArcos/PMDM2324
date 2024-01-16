package com.example.pmdm2324.ut06;

import java.io.Serializable;
import java.util.ArrayList;

public class ut06a2_Estadio  implements Serializable{
    public static final String CLAVE_ESTADIO = "estadio";
    private String nombre;
    private int n_aficionados;
    private String nacion;
    private String equipo;
    private String ciudad;




    public ut06a2_Estadio(String nombre, int n_aficionados, String nacion, String equipo, String ciudad) {
        this.nombre = nombre;
        this.n_aficionados = n_aficionados;
        this.nacion = nacion;
        this.equipo = equipo;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getN_Aficionados() {
        return n_aficionados;
    }
    public void setN_Aficionados(int n_aficionados) {
        this.n_aficionados = n_aficionados;
    }
    public String getNacion() {
        return nacion;
    }
    public void setNacion(String nacion) {
        this.nacion = nacion;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.nacion = ciudad;
    }


    /*
     * */
    public static ArrayList<ut06a2_Estadio> generador() {
        ArrayList<ut06a2_Estadio> estadios = new ArrayList<ut06a2_Estadio>();
        estadios.add(new ut06a2_Estadio("Bernabeu", 85000, "España","Real Madrid", "Madrid"));
        estadios.add(new ut06a2_Estadio("Camp Nou", 99000, "España", "FC Barcelona", "Barcelona"));
        estadios.add(new ut06a2_Estadio("Wanda Metropolitano", 68000, "España","Atletico de Madrid", "Madrid"));
        estadios.add(new ut06a2_Estadio("Stamford Bridge", 40000,"Reino Unido","Chelsea", "Londres"));
        estadios.add(new ut06a2_Estadio("Old Trafford", 76000, "Reino Unido","Manchester United", "Manchester"));
        estadios.add(new ut06a2_Estadio("Emirates Stadium", 60000,"Reino Unido", "Arsenal", "Londres"));
        estadios.add(new ut06a2_Estadio("Signal Iduna Park", 82000,"Alemania", "Borussia Dortmund", "Dortmund"));
        estadios.add(new ut06a2_Estadio("Allianz Arena", 75000,"Alemania", "Bayern de Múnich", "Múnich"));
        estadios.add(new ut06a2_Estadio("Giusseppe Meazza", 80000,"Italia","Inter de Milán","Milán"));
        estadios.add(new ut06a2_Estadio("Olímpico de Roma", 72000,"Italia","AS Roma", "Roma"));
        return estadios;
    }

    public String toString() {
        StringBuilder estadio = new StringBuilder();

        estadio.append("Estadio: "+nombre+"\n");
        estadio.append("Nº de Aficionados: "+n_aficionados+"\n");
        estadio.append("Nación: "+nacion+"\n");
        estadio.append("Equipo: "+equipo+"\n");
        estadio.append("Ciudad: "+ciudad+"\n");
        return estadio.toString();
    }
}
