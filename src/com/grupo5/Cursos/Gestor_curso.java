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
        for (int i = 0; i < 15; i++) {
            if (cursos[i] == null) {
                cursos[i] = new Curso(id,codigo, Nombre);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_curso(int id) {
        boolean s = false;
        for (int i = 0; i < 15; i++) {
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

    public void print_cursos() {
        System.out.println("Cursos:");
        for (int i = 0; i < 15; i++) {
            if (cursos[i] != null) {

                System.out.print(cursos[i].getId() + ",");
                System.out.println(cursos[i].getNombre() + ",");

            }

        }
    }
    public String buscar_nombre_clase(int id){
        String nombre="";
        for (int i = 0; i < 15; i++) {
            
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
        for (int i = 0; i < 15;i++) {
            if (cursos[i]!= null) {
                 
                    cantidad++;
                }
            }

        return cantidad;
    }
}
