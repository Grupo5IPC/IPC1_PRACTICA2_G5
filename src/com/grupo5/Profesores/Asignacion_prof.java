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
public class Asignacion_prof {
    private int Id_prof;
    private int Id_curso;
    private String Fecha;
    
    public Asignacion_prof(int id_p, int id_c, String fecha){
        this.Id_prof = id_p;
        this.Id_curso = id_c;
        this.setFecha(fecha);
    }


    public int getId_prof() {
        return Id_prof;
    }


    public void setId_prof(int Id_prof) {
        this.Id_prof = Id_prof;
    }


    public int getId_curso() {
        return Id_curso;
    }


    public void setId_curso(int Id_curso) {
        this.Id_curso = Id_curso;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
