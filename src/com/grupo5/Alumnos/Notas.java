package com.grupo5.Alumnos;

public class Notas {
    private int idAlumno;
    private int idCurso;
    private double nota;

    public Notas(int Alumno, int Curso, double Nota){
        this.setIdAlumno(Alumno);
        this.setIdCurso(Curso);
        this.setNota(Nota);
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
