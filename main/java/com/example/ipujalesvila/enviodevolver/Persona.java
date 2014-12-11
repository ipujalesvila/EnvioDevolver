package com.example.ipujalesvila.enviodevolver;

import java.io.Serializable;

/**
 * Created by ipujalesvila on 7/11/14.
 */
public class Persona implements Serializable{
    private String nombre;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String telefono) {
        this.setNombre(nombre);
        this.setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString(){
        return nombre+": "+telefono;
    };

}
