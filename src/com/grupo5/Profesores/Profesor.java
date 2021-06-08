/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo5.Profesores;

/**
 *
 * @author Ludwin
 */
public class Profesor {
    


    private int Id;
    private int Registro;
    private String Nombre;
    private String Fecha_nacimiento;
    private String Fecha_contratacion;
    private String Genero;
    
    public Profesor(int id, int registro,String nombre,String fecha_nacimiento,String fecha_contratacion, String genero){
        this.setId(id);
        this.setRegistro(registro);
        this.setNombre(nombre);
        this.setFecha_nacimiento(fecha_nacimiento);
        this.setFecha_contratacion(fecha_contratacion);
        this.setGenero(genero);

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getRegistro() {
        return Registro;
    }

    public void setRegistro(int registro) {
        Registro = registro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_contratacion() {
        return Fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        Fecha_contratacion = fecha_contratacion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
