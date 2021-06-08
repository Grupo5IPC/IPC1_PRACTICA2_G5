/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo5.Alumnos;

/**
 * @author Ludwin
 */
public class Gestor_alumno {

    Alumno[] alumnos;
    Asignacion_alumno[] asignaciones;

    public Gestor_alumno() {
        alumnos = new Alumno[100];
        asignaciones = new Asignacion_alumno[200];
    }

    public boolean Ins_alum(int id, int carnet, String nombre, String fecha, String genero) {
        for (int i = 0; i < 150; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, carnet, nombre, fecha, genero);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_alum(int id) {
        boolean s = false;
        for (int i = 0; i < 150; i++) {
            if (alumnos[0] == null) {
                return true;
            } else {
                if (alumnos[i] != null) {
                    if (alumnos[i].getId() == id) {
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

    public void print_alumnos() {
        System.out.println("Alumnos ingresados actualmente:");
        for (int i = 0; i < 150; i++) {
            if (alumnos[i] != null) {

                System.out.print(alumnos[i].getId() + ",");
                System.out.print(alumnos[i].getCarnet() + ",");
                System.out.print(alumnos[i].getFecha() + ",");
                System.out.println(alumnos[i].getGenero() + ",");
            }

        }
    }

    public boolean asginar_curso(int id_a, int id_c, double zona) {
        for (int i = 0; i < 450; i++) {
            if (asignaciones[i] == null) {
                asignaciones[i] = new Asignacion_alumno(id_a, id_c, zona);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_asign(int id_a, int id_c) {
        boolean s = false;
        for (int i = 0; i < 450; i++) {
            if (asignaciones[0] == null) {
                s = true;
                break;

            } else {
                if (asignaciones[i] != null) {
                    if ((asignaciones[i].getId_alumno() == id_a) && (asignaciones[i].getId_curso() == id_c)) {
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

    public boolean verificar_asign_curso(int id_c) {
        boolean s = false;
        for (int i = 0; i < 450; i++) {
            if (asignaciones[0] == null) {
                s = true;
                break;

            } else {
                if (asignaciones[i] != null) {
                    if (asignaciones[i].getId_curso() == id_c) {
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

    public boolean ver_test(int fila, int id_c) {
        if (asignaciones[fila] != null) {

            if (asignaciones[fila].getId_curso() == id_c) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public int verificar_cant_asign(int id_a) {
        int curso = 0;
        for (int i = 0; i < 450; i++) {
            if (asignaciones[i] != null) {
                if (asignaciones[i].getId_alumno() == id_a) {
                    curso++;
                }
            }
        }
        return curso;
    }

    public void print_asig() {
        System.out.println("Asignaciones:");
        for (int i = 0; i < 450; i++) {
            if (asignaciones[i] != null) {

                System.out.print(asignaciones[i].getId_alumno() + ",");
                System.out.print(asignaciones[i].getId_curso() + ",");
                System.out.println(asignaciones[i].getNota() + ",");

            }

        }
    }

    //  FALTA VERIFICAR, NO DESCOMENTAR
/*
    public void ordenar() {
        int menor;
        int cant = 0;
        for (int i = 0; i < 150; i++) {
            if (alumnos[i] != null) {
                cant++;

            }
        }
        for (int x = 0; x < 150; x++) {
            if (alumnos[x] != null) {
                for (int i = 0; i < cant - x - 1; i++) {
                    if (alumnos[i].getId() > alumnos[i + 1].getId()) {
                        int tmp = alumnos[i + 1].getId();
                        String tmp_n = alumnos[i + 1].getNombre();
                        int tmp_e = alumnos[i + 1].getEdad();
                        String s = alumnos[i + 1].getSexo();
                        alumnos[i + 1].setId(alumnos[i].getId());
                        alumnos[i + 1].setEdad(alumnos[i].getEdad());
                        alumnos[i + 1].setNombre(alumnos[i].getNombre());
                        alumnos[i + 1].setGenero(alumnos[i].getGenero());
                        alumnos[i].setId(tmp);
                        alumnos[i].setNombre(tmp_n);
                        alumnos[i].setEdad(tmp_e);
                        alumnos[i].setSexo(s);
                    }
                }
            }

        }


    }

    public void ordenar_asig() {
        int menor;
        int cant = 0;
        for (int i = 0; i < 150; i++) {
            if (asignaciones[i] != null) {
                cant++;

            }
        }
        for (int x = 0; x < 450; x++) {
            if (asignaciones[x] != null) {
                for (int i = 0; i < cant - x - 1; i++) {
                    if (asignaciones[i].getId_alumno() > asignaciones[i + 1].getId_alumno()) {
                        int tmp = asignaciones[i + 1].getId_alumno();
                        asignaciones[i + 1].setId_alumno(asignaciones[i].getId_alumno());
                        asignaciones[i].setId_alumno(tmp);
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

    public int cantidad_filas() {
        int cant = 0;
        for (int i = 0; i < 450; i++) {
            if (asignaciones[i] != null) {
                cant++;

            }
        }
        return cant;
    }

    public int cantidad_filas_asig(int id) {
        int cant = 0;
        for (int i = 0; i < 450; i++) {
            if (asignaciones[i] != null) {
                if (asignaciones[i].getId_curso() == id) {
                    cant++;

                }
            }

        }
        return cant;
    }

    public int get_id_al(int id) {

        return asignaciones[id].getId_alumno();
    }

    public int get_id_curso(int id) {

        return asignaciones[id].getId_curso();
    }

    public double get_nota(int id) {
        return asignaciones[id].getNota();
    }

    public String buscar_nombre_alumn(int id) {
        String nombre = "";
        for (int i = 0; i < 150; i++) {

            if (alumnos[i] != null) {
                if (alumnos[i].getId() == id) {
                    nombre = alumnos[i].getNombre();
                    break;
                }
            }
        }
        return nombre;
    }

    public int verificar_cant() {
        int cantidad = 0;
        for (int i = 0; i < 150; i++) {
            if (alumnos[i] != null) {

                cantidad++;
            }
        }

        return cantidad;
    }
}
