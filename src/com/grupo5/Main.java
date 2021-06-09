package com.grupo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.grupo5.Cursos.Curso;
import com.grupo5.Alumnos.*;
import com.grupo5.Cursos.*;
import com.grupo5.Profesores.*;
import com.grupo5.Usuarios.*;

public class Main {

    public static Scanner MenuPrincipal = new Scanner(System.in);
    public static Scanner escribirRuta = new Scanner(System.in);
    public static Curso[] cursos = new Curso[15];
    public static Profesor[] profesores = new Profesor[20];
    public static Alumno[] alumnos = new Alumno[100];
    static Asignacion_alumno[] Asignar = new Asignacion_alumno[alumnos.length];
    static Asignacion_prof[] Asignar2 = new Asignacion_prof[profesores.length];
    static String Ruta;
    static int Columnas, Filas, IdAlumno, IdCurso, IdProfesor, Nota;
    public static Gestor_alumno gestor_alumno;
    public static Gestor_curso gestor_curso;
    public static Gestor_profesor gestor_profesor;
    public static Gestor_usuarios gestor_usuarios;

    public static void main(String[] args) {
        gestor_alumno = new Gestor_alumno();
        gestor_curso = new Gestor_curso();
        gestor_profesor = new Gestor_profesor();
        gestor_usuarios = new Gestor_usuarios();
        menuPrincipal();
    }

    public static void menuPrincipal() {

        try {
            System.out.println("*******************************");
            System.out.println("*           LOGIN             *");
            System.out.println("*******************************");
            System.out.println("* Ingrese su usuario          *");
            String user = MenuPrincipal.nextLine();
            System.out.println("* Ingrese su contraseña       *");
            String pass = MenuPrincipal.nextLine();
            System.out.println("*******************************");
            int Opciones = 0;
            if (user.equals("admin") && pass.equals("admin")) {
                do {
                    try {
                        System.out.println("*******************************");
                        System.out.println("*       MENÚ PRINCIPAL        *");
                        System.out.println("*******************************");
                        System.out.println("* 1) Cargar Alumnos           *");
                        System.out.println("* 2) Cargar Profesores        *");
                        System.out.println("* 3) Cargar Cursos            *");
                        System.out.println("* 4) Asignar Alumnos          *");
                        System.out.println("* 5) Asignar Profesores       *");
                        System.out.println("* 6) Cargar Notas             *");
                        System.out.println("* 7) Agregar Usuario          *");
                        System.out.println("* 8) Salir                    *");
                        System.out.println("*******************************");
                        System.out.print("Elige una opcion: ");
                        Opciones = MenuPrincipal.nextInt();
                        switch (Opciones) {
                            case 1:

                                break;

                            case 2:

                                break;

                            case 3:
                                System.out.println("Ingrese la ruta del archivo: ");
                                Ruta = escribirRuta.nextLine();
                                CargarCursos(Ruta);
                                break;

                            case 7:
                                NuevoUser();
                                break;

                            case 8:
                                System.out.println("Has salido del programa");
                                break;

                            default:
                                System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                                break;
                        }
                    } catch (Exception e) {
                        MenuPrincipal = new Scanner(System.in);
                        System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                    }
                } while (Opciones != 8);
            } else if (gestor_usuarios.verificar(user, pass)) {
                do {
                    try {
                        System.out.println("*************************************");
                        System.out.println("*           MENÚ PRINCIPAL          *");
                        System.out.println("*************************************");
                        System.out.println("* 1) Reporte de Alumnos             *");
                        System.out.println("* 2) Reporte asignacion Alumnos     *");
                        System.out.println("* 3) Reporte asignacion Profesores  *");
                        System.out.println("* 4) Reporte General                *");
                        System.out.println("* 5) Reporte Especifico             *");
                        System.out.println("* 6) Top 5 Mejores Alumnos          *");
                        System.out.println("* 7) Salir                          *");
                        System.out.println("*******************************");
                        System.out.print("Elige una opcion: ");
                        Opciones = MenuPrincipal.nextInt();
                        switch (Opciones) {
                            case 1:

                                break;

                            case 2:

                                break;

                            case 3:

                                break;

                            case 7:

                                break;

                            default:
                                System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                                break;
                        }
                    } catch (Exception e) {
                        MenuPrincipal = new Scanner(System.in);
                        System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                    }
                } while (Opciones != 8);
            }
        } catch (Exception e) {
            System.out.println("Has hecho una acción no valida,");
            System.out.println("Ejecuta el programa nuevamente");
        }
    }

//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------    
    public static void NuevoUser() {
        System.out.println("*******************************");
        System.out.println("*       Nuevo Usuario         *");
        System.out.println("*******************************");
        System.out.println("* Ingrese el nuevo usuario    *");
        Scanner nombreUsuario = new Scanner(System.in);
        String nuser = nombreUsuario.nextLine();
        System.out.println("* Ingrese una contraseña      *");
        Scanner passUsuario = new Scanner(System.in);
        String npass = passUsuario.nextLine();
        System.out.println("* Confirmar contraseña        *");
        Scanner confirmarPass = new Scanner(System.in);
        String npass2 = confirmarPass.nextLine();
        System.out.println("*******************************");
        if(nuser.equals("admin") && npass.equals(npass2)){
            gestor_usuarios.Ins_usu(nuser, npass);
            System.out.println("\nAgregado corretamente \n");
        }else{
        System.out.println("Error: ocurrio un problema en su registro");
        System.out.println("Vuelva a intentarlo");
    }
    }
//----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

    public static void CargarCursos(String Ruta) {
        int Id, Codigo;
        String Nombre;

        try {
            File CSV = new File(Ruta);
            Scanner Reader = new Scanner(CSV);
            String Data = "";

            while (Reader.hasNextLine()) {
                Data += Reader.nextLine() + "\n";
            }
            String[] Rows = Data.split("\n");
            Filas = Rows.length;

            String[] Columns = Rows[0].split(",");
            Columnas = Columns.length;

            for (int i = 1; i < cursos.length; i++) {
                Columns = Rows[i].split(",");

                Id = Integer.parseInt(Columns[0]);
                Codigo = Integer.parseInt(Columns[1]);
                Nombre = Columns[2];

                cursos[i] = new Curso(Id, Codigo, Nombre);
            }
            System.out.println("\nFueron ingresados: " + (Filas - 1) + " cursos");

            for (int i = 1; i < Filas; i++) {
                System.out.println("\nId: " + String.valueOf(cursos[i].getId()));
                System.out.println("Codigo: " + String.valueOf(cursos[i].getCodigo()));
                System.out.println("Nombre: " + String.valueOf(cursos[i].getNombre()));
            }
            System.out.println("\n");
            Reader.close();
        } catch (Exception e) {
        }
    }
}
