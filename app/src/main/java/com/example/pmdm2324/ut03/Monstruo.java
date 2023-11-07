package com.example.pmdm2324.ut03;

import java.io.Serializable;

public class Monstruo implements Serializable {
private String nombre;
private int Extremidades;
private String Color;

    public void setNombre(String nuevoNombre)
    {
        nombre = nuevoNombre;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setExtremidades(int nuevasExtremidades)
    {
        Extremidades = nuevasExtremidades;
    }
    public int getExtremidades()
    {
        return Extremidades;
    }
    public void setColorMonstruo(String nuevoColor){
        Color = nuevoColor;
    }
    public String getColorMonstruo()
    {
        return Color;
    }

}
