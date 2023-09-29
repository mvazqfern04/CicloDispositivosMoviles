package com.example.ejerciciosettings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Ajustes {
    private String nombre, correo, edad;
    private boolean publi;

    private SharedPreferences pf;

    private final static String CLAVE_NOMB = "idNombre";
    private final static String CLAVE_CORR = "idCorreo";
    private final static String CLAVE_EDAD = "idEdad";
    private final static String CLAVE_PUBLI = "publicidad";


    //Implementa SINGLETONE
    private static Ajustes instancia=null;
    public static Ajustes getInstance(Activity activity){
        if(instancia==null)
            instancia=new Ajustes(activity);
        return instancia;
    }

    //Un SINGLETONE contructor privado con un parametro
    //así ya no existe un constructor por defecto vacio
    private  Ajustes(Activity activity){
        pf=activity.getPreferences(Context.MODE_PRIVATE);
        nombre=pf.getString(CLAVE_NOMB,"");
        correo=pf.getString(CLAVE_CORR,"");
        edad=pf.getString(CLAVE_EDAD,"");
        publi=pf.getBoolean(CLAVE_PUBLI,false);
    }



    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public int getEdad(int hayEdad) {
        int edad;
        try{edad=Integer.parseInt(this.edad);}
        catch (NumberFormatException ex){return hayEdad;}
        return edad;
    }
    public boolean isPubli() {
        return publi;
    }
    //Esto comprueba que se puedan guardar los datos y los guarda.
    public boolean set(String nombre, String correo, String edad, boolean publi){
        if(nombre.trim().equals("")) return  false;
        if(!correo.equals("")) return  false;
        if(!edad.equals("")) return false;

        this.nombre=nombre;
        this.correo=correo;
        this.edad=edad;
        this.publi=publi;

        pf.edit()
                .putString(CLAVE_NOMB,nombre)
                .putString(CLAVE_CORR,correo)
                .putString(CLAVE_EDAD,edad)
                .putBoolean(CLAVE_PUBLI,publi)
                .apply();

        return true;
    }
}
