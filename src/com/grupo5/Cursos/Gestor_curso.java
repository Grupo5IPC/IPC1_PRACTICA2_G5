/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo5.Cursos;

/**
 *
 * @author Ludwin
 */
public class Gestor_curso {

    Curso[] cursos;

    public Gestor_curso() {
        cursos = new Curso[15];
    }

    public boolean Ins_curso(int id, int codigo, String Nombre) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = new Curso(id,codigo, Nombre);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_curso_id(int id) {
        boolean s = false;
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[0] == null) {
                return true;
            } else {
                if (cursos[i] != null) {
                    if (cursos[i].getId() == id) {
                        s = false;
                        break;
                    } else {
                        s = true;
                    }
                }
            }
        }
        return s;
    }
    public boolean verificar_curso_codigo(int codigo) {
        boolean s = false;
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[0] == null) {
                return true;
            } else {
                if (cursos[i] != null) {
                    if (cursos[i].getCodigo() == codigo) {
                        s = false;
                        break;
                    } else {
                        s = true;
                    }
                }
            }
        }
        return s;
    }

    public void print_cursos() {
        System.out.println("Cursos:");
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null) {

                System.out.print(cursos[i].getId() + ",");
                System.out.println(cursos[i].getNombre() + ",");

            }

        }
    }
    public void print_cursos_codigo() {
        System.out.println("Cursos:");
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null) {

                System.out.print(cursos[i].getCodigo() + ",");
                System.out.println(cursos[i].getNombre() + ",");

            }

        }
    }

    public int buscarCodigo_clase(int id){
        int codigo=0;
        for (int i = 0; i < cursos.length; i++) {

            if (cursos[i] != null) {
                if (cursos[i].getId() == id) {
                    codigo = cursos[i].getCodigo();
                    break;
                }
            }
        }
        return codigo;
    }
    public String buscar_nombre_clase(int id){
        String nombre="";
        for (int i = 0; i < cursos.length; i++) {
            
                if (cursos[i] != null) {
                    if (cursos[i].getId() == id) {
                       nombre = cursos[i].getNombre();
                        break;
                    } 
                }
        }
        return nombre;
    }
    public int verificar_cant(){
        int cantidad = 0;
        for (int i = 0; i < cursos.length;i++) {
            if (cursos[i]!= null) {
                 
                    cantidad++;
                }
            }

        return cantidad;
    }

    public int getIdcurso(int id){
        return cursos[id].getId();
    }
    public int buscarId_clase(int codigo){
        int id =0;
        for (int i = 0; i < cursos.length; i++) {

            if (cursos[i] != null) {
                if (cursos[i].getCodigo() == codigo) {
                    id = cursos[i].getId();
                    break;
                }
            }
        }
        return id;
    }
}
