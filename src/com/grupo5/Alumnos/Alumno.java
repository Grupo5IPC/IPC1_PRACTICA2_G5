/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo5.Alumnos;

/**
 *
 * @author Ludwin
 */
public class Alumno {
    private int Id;
    private int Carnet;
    private String Nombre;
    private String Fecha;
    private char Genero;

    public Alumno(int id, int carnet, String nombre, String fecha, char genero ){
        this.setId(id);
        this.setCarnet(carnet);
        this.setNombre(nombre);
        this.setFecha(fecha);
        this.setGenero(genero);
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCarnet() {
        return Carnet;
    }

    public void setCarnet(int carnet) {
        Carnet = carnet;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public char getGenero() {
        return Genero;
    }

    public void setGenero(char genero) {
        Genero = genero;
    }
}
