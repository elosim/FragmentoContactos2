package com.example.ivan.fragmentocontactos2.utiles;

import java.io.Serializable;
import java.util.ArrayList;

public class Contacto implements Serializable, Comparable<Contacto> {
    private String nombre;
    private ArrayList<String> numeros;
    private long id;

    public Contacto(){
        this("",new ArrayList());
    }

    public Contacto(String nombre, ArrayList<String> numeros) {
        this.nombre = nombre;
        this.numeros = numeros;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.numeros = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<String> numeros) {
        this.numeros = numeros;
    }

    public void setId(long id) { this.id = id; }

    public long getId() { return id; }

    public void aniadirTelefono(int num) {
        numeros.add(Integer.toString(num));
    }
    public boolean isEmpty(){
        return numeros.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        return nombre.equals(contacto.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return "nombre " + nombre + " numeros " + numeros + " id=" + id;
    }

    private static int o;
    public static void orden(int a){
        o=a;
    }

    @Override
    public int compareTo(Contacto c) {
        int res = this.nombre.compareTo(c.nombre);
        if(res == 0){
            res = (int) (this.id-c.id);
        }
        return res;
    }
}
