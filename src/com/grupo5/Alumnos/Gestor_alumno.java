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
    Notas[] notas;

    public Gestor_alumno() {
        alumnos = new Alumno[100];
        asignaciones = new Asignacion_alumno[200];
        notas = new Notas[200];
    }

    public boolean Ins_alum(int id, int carnet, String nombre, String fecha, char genero) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, carnet, nombre, fecha, genero);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_alum_carnet(int carnet) {
        boolean s = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[0] == null) {
               // System.out.println("nuevo");
                return true;
            } else {
                if (alumnos[i] != null) {
                    if (alumnos[i].getCarnet() ==carnet ) {
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

    public boolean verificar_alum_id(int id) {
        boolean s = false;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[0] == null) {
                // System.out.println("nuevo");
                return true;
            } else {
                if (alumnos[i] != null) {
                    if (alumnos[i].getId() ==id ) {
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
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {

                System.out.print(alumnos[i].getId() + ",");
                System.out.print(alumnos[i].getCarnet() + ",");
                System.out.print(alumnos[i].getNombre() + ",");
                System.out.print(alumnos[i].getFecha() + ",");
                System.out.println(alumnos[i].getGenero() + ",");
            }

        }
    }

    public boolean asginar_curso(int id_a, int id_c, String fecha) {
        for (int i = 0; i < asignaciones.length; i++) {
            if (asignaciones[i] == null) {
                asignaciones[i] = new Asignacion_alumno(id_a, id_c, fecha );
                return true;
            }
        }
        return false;
    }
    public boolean asginarNota(int id_a, int id_c, double nota) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == null) {
                notas[i] = new Notas(id_a, id_c , nota);
                return true;
            }
        }
        return false;
    }

    public boolean verificar_asign(int id_a, int id_c) {
        boolean s = false;
        for (int i = 0; i < asignaciones.length; i++) {
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
        for (int i = 0; i < 200; i++) {
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
        for (int i = 0; i < 200; i++) {
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
        for (int i = 0; i < 200; i++) {
            if (asignaciones[i] != null) {

                System.out.print(asignaciones[i].getId_alumno() + ",");
                System.out.println(asignaciones[i].getId_curso() + ",");


            }

        }
    }
    public void printNota() {
        System.out.println("Notas:");
        for (int i = 0; i < 200; i++) {
            if (notas[i] != null) {

                System.out.print(notas[i].getIdAlumno() + ",");
                System.out.print(notas[i].getIdCurso() + ",");

                System.out.println(notas[i].getNota() + ",");


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
        for (int i = 0; i < 200; i++) {
            if (asignaciones[i] != null) {
                cant++;

            }
        }
        return cant;
    }
    public int cantidad_filas_notas() {
        int cant = 0;
        for (int i = 0; i < 200; i++) {
            if (notas[i] != null) {
                cant++;

            }
        }
        return cant;
    }

    public int cantidad_filas_asig(int id) {
        int cant = 0;
        for (int i = 0; i < 200; i++) {
            if (asignaciones[i] != null) {
                if (asignaciones[i].getId_curso() == id) {
                    cant++;

                }
            }

        }
        return cant;
    }
    public int[] getIds_encurso(int idCurso) {
        int filas = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] != null) {
                if (notas[i].getIdCurso() == idCurso) {
                    filas++;

                }
            }

        }
        int ids [] = new int [filas];
        int auxiliar = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < notas.length; j++) {
                if (notas[j] != null) {
                    if (notas[j].getIdCurso() == idCurso) {
                        if (auxiliar != ids[i]) {
                            ids[i] = notas[j].getIdAlumno();
                            auxiliar = ids[i];
                            break;
                        }
                    }
                }
            }
        }
        return ids;
    }



    public int get_id_al(int id) {

        return asignaciones[id].getId_alumno();
    }
    public String get_id_fecha(int id) {

        return asignaciones[id].getFecha();
    }

    public int getCarnetAsig(int id) {

        int carnet =0;
        for (int i = 0; i < alumnos.length; i++) {

            if (alumnos[i] != null) {
                if (alumnos[i].getId() == id) {
                    carnet = alumnos[i].getCarnet();
                    break;
                }
            }
        }
        return carnet;
    }
    public String buscar_nombre_alumn(int id)  {
        String nombre = "";
        for (int i = 0; i < alumnos.length; i++) {

            if (alumnos[i] != null) {
                if (alumnos[i].getId() == id) {
                    nombre = alumnos[i].getNombre();
                    break;
                }
            }
        }
        return nombre;
    }
    public double buscarNota(int idAlumno, int idCurso)  {
        double nota =0.0;
        for (int i = 0; i < notas.length; i++) {

            if (notas[i] != null) {
                if (notas[i].getIdAlumno() == idAlumno && notas[i].getIdCurso() == idCurso) {
                    nota = notas[i].getNota();
                    break;
                }
            }
        }
        return nota;
    }





    public int get_id_curso(int id) {

        return asignaciones[id].getId_curso();
    }


   /* public double get_nota(int id) {
        return asignaciones[id].getNota();
    }

    */



    public int verificar_cant() {
        int cantidad = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null) {

                cantidad++;
            }
        }
        System.out.println(cantidad);
        return cantidad;
    }

    //FUNCIONES DE BUSQUEDA

    public int getCarnet(int i){
        return alumnos[i].getCarnet();
    }
    public String getNombre(int i){
        return alumnos[i].getNombre();
    }
    public String getGenero(int i){
        if (alumnos[i].getGenero() =='M'){
            return "Masculino";
        }else{
            return "Femenino";
        }

    }


    public boolean verificarIngreso(int idAlumno, int IdCurso){
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] != null) {
                if (notas[i].getIdAlumno() == idAlumno && notas[i].getIdCurso() == IdCurso) {
                    return false;

                }
            }
        }
        return true;
    }
}
