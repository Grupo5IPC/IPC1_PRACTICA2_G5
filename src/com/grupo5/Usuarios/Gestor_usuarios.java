/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo5.Usuarios;

/**
 *
 * @author Ludwin
 */
public class Gestor_usuarios {

    Usuario[] usuarios;

    public Gestor_usuarios() {
        usuarios = new Usuario[5];

    }

    public boolean Ins_usu(String nombre, String pass) {
        for (int i = 0; i < 5; i++) {

            if (usuarios[i] == null) {
                usuarios[i] = new Usuario(nombre, pass);
                return true;
            }
        }
        return false;
    }

    public void print_usu() {
        for (int i = 0; i < 5; i++) {
            if (usuarios[i] != null) {
                System.out.print(usuarios[i].getUsuario());
                System.out.println(usuarios[i].getPassword());

            }

        }
    }

    public boolean verificar(String usu, String pass) {
        for (int i = 0; i < 5; i++) {
            if (usuarios[i] != null) {
                if ((usuarios[i].getUsuario().equals(usu)) && (usuarios[i].getPassword().equals(pass))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificar_exis(String usu) {
        for (int i = 0; i < 5; i++) {
            if (usuarios[i] != null) {
                if ((usuarios[i].getUsuario().equals(usu))) {
                    return true;
                }
            }
        }
        return false;
    }

    public int verificar_cant() {
        int cantidad = 0;
        for (int i = 0; i < 5; i++) {
            if (usuarios[i] != null) {

                cantidad++;
            }
        }
        //System.out.println("usuarios: "+ cantidad);
        return cantidad;
    }

    public String buscar_nombre_USU(String nom) {
        String nombre = "";
        for (int i = 0; i < 5; i++) {

            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(nom)) {
                    nombre = usuarios[i].getUsuario();
                    break;
                }
            }
        }
        return nombre;
    }

    public String buscar_contra(String nom) {
        String nombre = "";
        for (int i = 0; i < 5; i++) {

            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(nom)) {
                    nombre = usuarios[i].getPassword();
                    break;
                }
            }
        }
        return nombre;
    }
}
