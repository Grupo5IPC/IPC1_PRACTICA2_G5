package com.grupo5.Cursos;

public class Curso {
    
    private int Id;
    private int Codigo;
    private String Nombre;
    
    public Curso(int id, int codigo, String nombre){
        this.Id = id;
        this.setCodigo(codigo);
        this.Nombre = nombre;
    }


    public int getId() {
        return Id;
    }


    public void setId(int Id) {
        this.Id = Id;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }
}
