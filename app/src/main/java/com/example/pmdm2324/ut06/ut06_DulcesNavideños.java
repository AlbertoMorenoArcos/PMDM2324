package com.example.pmdm2324.ut06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ut06_DulcesNavideños {

    public String nombre;
    public String calorias;
    public String fruto_seco;
    public static final int DULCES_INICIALES = 4;
    private static ArrayList<String> dulces = new ArrayList<String>(Arrays.asList(new String[]{"Polvoron", "Mazapan", "Mantecado", "Peladilla", "Turron", "Roscon", "Pestiño", "Fruta escarchada", "Rosco de vino", "Panettone"}));
    public static ut06_DulcesNavideños generateDulce(){
        Collections.shuffle(dulces);
        ut06_DulcesNavideños p = new ut06_DulcesNavideños();
        p.nombre = dulces.get(0);
        if(p.nombre.equals("Polvoron")){
            p.calorias = "150";
            p.fruto_seco = "Si";
        }else
        if(p.nombre.equals("Mazapan")){
            p.calorias = "147";
            p.fruto_seco = "No";
        }else
        if(p.nombre.equals("Mantecado")){
            p.calorias = "107";
            p.fruto_seco = "Si";
        }else
        if(p.nombre.equals("Peladilla")){
            p.calorias = "485";
            p.fruto_seco = "Si";
        }else
        if(p.nombre.equals("Turron")){
            p.calorias = "490";
            p.fruto_seco = "Si";
        }else
        if(p.nombre.equals("Roscon")){
            p.calorias = "350";
            p.fruto_seco = "Si";
        }else
        if(p.nombre.equals("Fruta escarchada")){
            p.calorias = "321";
            p.fruto_seco = "No";
        }else
        if(p.nombre.equals("Rosco de vino")){
            p.calorias = "515";
            p.fruto_seco = "No";
        }else
        if(p.nombre.equals("Panettone")){
            p.calorias = "374";
            p.fruto_seco = "No";
        }
        return p;
    }

    public static ut06_DulcesNavideños[] generateDulces(int n) {
        ut06_DulcesNavideños[] dulcesNavideños = new ut06_DulcesNavideños[n];
        for(int i = 0; i< n; i++){
            dulcesNavideños[i] = ut06_DulcesNavideños.generateDulce();
        }
        return dulcesNavideños;
    }
}
