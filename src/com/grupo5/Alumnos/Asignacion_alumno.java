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
public class Asignacion_alumno {
    private int Id_alumno;
    private int Id_curso;
private String fecha;
    
    public Asignacion_alumno(int id_a, int id_c, String f ){
        this.Id_alumno = id_a;
        this.Id_curso = id_c;
        this.setFecha(f);

    }

    /**
     * @return the Id_alumno
     */
    public int getId_alumno() {
        return Id_alumno;
    }

    /**
     * @param Id_alumno the Id_alumno to set
     */
    public void setId_alumno(int Id_alumno) {
        this.Id_alumno = Id_alumno;
    }

    /**
     * @return the Id_curso
     */
    public int getId_curso() {
        return Id_curso;
    }

    /**
     * @param Id_curso the Id_curso to set
     */
    public void setId_curso(int Id_curso) {
        this.Id_curso = Id_curso;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
