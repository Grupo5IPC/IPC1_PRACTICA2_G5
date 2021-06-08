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
public class Gestor_profesor {

    Profesor[] profesores;
    Asignacion_prof [] asignaciones;

    public Gestor_profesor() {
        profesores = new Profesor[20];
        asignaciones = new Asignacion_prof[30];
    }

    public boolean Ins_prof(int id, int registro,String nombre,String fecha_nacimiento,String fecha_contratacion, String genero) {
        for (int i = 0; i < 25; i++) {
            if (profesores[i] == null) {
                profesores[i] = new Profesor(id, registro, nombre, fecha_nacimiento, fecha_contratacion, genero);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_prof(int id) {
        boolean s = false;
        for (int i = 0; i < 25; i++) {
            if (profesores[0] == null) {
               
                return true;

            } else {
                if (profesores[i] != null) {
                    if (profesores[i].getId() == id) {
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

    public void print_profesores() {
        System.out.println("Profesores en el sistema:");
        for (int i = 0; i < 25; i++) {
            if (profesores[i] != null) {

                System.out.print(profesores[i].getId() + ",");
                System.out.print(profesores[i].getNombre() + ",");

                System.out.println();
            }

        }
    }
    public boolean asginar_curso(int id_a, int id_c) {
        for (int i = 0; i < 75; i++) {
            if (asignaciones[i] == null) {
                asignaciones[i] = new Asignacion_prof(id_a, id_c);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_asign(int id_a, int id_c) {
        boolean s = false;
        for (int i = 0; i < 75; i++) {
            if (asignaciones[0] == null) {
                s = true;
                return s;

            } else {
                if (asignaciones[i] != null) {
                    if ((asignaciones[i].getId_prof() == id_a) && (asignaciones[i].getId_curso() == id_c)) {
                        s = false;
                        return s;

                    } else {
                        s = true;
                    }
                }
            }
        }

        return s;
    }
    
    public int verificar_cant_asign(int id_a){
        int curso = 0;
        for (int i = 0; i < 75; i++) {
            if (asignaciones[i]!= null) {
                if (asignaciones[i].getId_prof() == id_a) {
                    curso++;
                }
            }
        }
        return curso;
    }
    public void print_asig(){
        System.out.println("Profesor y cursos asignados:");
        for (int i = 0; i < 75; i++) {
            if (asignaciones[i] != null) {

                System.out.print(asignaciones[i].getId_prof()+ ",");
                System.out.println(asignaciones[i].getId_curso()+ ",");

          
            }

        }
    }
    public int get_id_prof(int id){
    
        return asignaciones[id].getId_prof();
    }
    public int get_id_curso(int id){
    
        return asignaciones[id].getId_curso();
    }
    public int cantidad_filas(){
        int cant =0;
        for (int i = 0; i < 75; i++) {
            if (asignaciones[i] != null) {
                cant++;
                
            }
        }
        return cant;
    }
    //  FALTA REFORMULAR Y TESTEAR, NO DESCOMENTAR
    /*
    public void ordenar() {
        int menor;
        int cant = 0;
        for (int i = 0; i < 25; i++) {
            if (profesores[i] != null) {
                cant++;
                
            }
        }
        for (int x = 0; x < 25; x++) {
            if (profesores[x] != null) {
                for (int i = 0; i < cant - x - 1; i++) {
                    if (profesores[i].getId() > profesores[i + 1].getId()) {
                        int tmp = profesores[i + 1].getId();
                        int tmp_n = profesores[i+1].getRegistro();
                        String tmp_e = profesores[i+1].getNombre();
                        String s = profesores[i+1].getFecha_nacimiento();
                        profesores[i + 1].setId(profesores[i].getId());
                        profesores[i+1].setRegistro(profesores[i].getRegistro());
                        profesores[i+1].setNombre(profesores[i].getNombre());
                        profesores[i+1].setFecha_nacimiento(profesores[i].getFecha_nacimiento());
                        profesores[i].setId(tmp);
                        profesores[i].setRegistro(tmp_n);
                        profesores[i].setNombre(tmp_e);
                        profesores[i].setFecha_nacimiento(s);
                    }
                }
            }

        }
    }
    public void ordenar_asig() {
        int menor;
        int cant = 0;
        for (int i = 0; i < 75; i++) {
            if (asignaciones[i] != null) {
                cant++;
                
            }
        }
        for (int x = 0; x < 75; x++) {
            if (asignaciones[x] != null) {
                for (int i = 0; i < cant - x - 1; i++) {
                    if (asignaciones[i].getId_prof()> asignaciones[i + 1].getId_prof()) {
                        int tmp = asignaciones[i + 1].getId_prof();
                        asignaciones[i + 1].setId_prof(asignaciones[i].getId_prof());
                        asignaciones[i].setId_prof(tmp);
                    }
                    if (asignaciones[i].getId_curso() > asignaciones[i + 1].getId_curso()) {
                        int tmp = asignaciones[i + 1].getId_curso();
                        asignaciones[i + 1].setId_curso(asignaciones[i].getId_curso());
                        asignaciones[i].setId_curso(tmp);
                    }
                }
            }

        }
    }

     */
    public String buscar_nombre_prof(int id){
        String nombre="";
        for (int i = 0; i < 25; i++) {
            
                if (profesores[i] != null) {
                    if (profesores[i].getId() == id) {
                       nombre = profesores[i].getNombre();
                        break;
                    } 
                }
        }
        return nombre;
    }
    public int verificar_cant(){
        int cantidad = 0;
        for (int i = 0; i < 25;i++) {
            if (profesores[i]!= null) {
                 
                    cantidad++;
                }
            }

        return cantidad;
    }
    
}
