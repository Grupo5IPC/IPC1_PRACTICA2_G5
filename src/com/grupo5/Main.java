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
    public static Gestor_alumno  gestor_alumno ;
    public static Gestor_curso gestor_curso ;
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

            int Opciones = 0;

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
                            System.out.println("Ingrese la ruta del archivo: ");
                            Ruta = escribirRuta.nextLine();
                            CargarAlumnos(Ruta);
                            break;

                        case 2:
                            System.out.println("Ingrese la ruta del archivo: ");
                            Ruta = escribirRuta.nextLine();
                            CargarProfesores(Ruta);
                            break;

                        case 3:
                            System.out.println("Ingrese la ruta del archivo: ");
                            Ruta = escribirRuta.nextLine();
                            CargarCursos(Ruta);
                            break;
                        
                        case 4:
                            System.out.println("Ingrese la ruta del archivo: ");
                            Ruta = escribirRuta.nextLine();
                            AsignarAlumnos(Ruta);
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

        } catch (Exception e) {
            System.out.println("Has hecho una acción no valida,");
            System.out.println("Ejecuta el programa nuevamente");
        }

    }

       public static void CargarAlumnos(String Ruta) {
        int Id, Carnet;
        String Nombre, FechaNac, Genero;

        try {
            File CSV = new File(Ruta);
            Scanner Reader = new Scanner(CSV);
            String Data = "";

            while (Reader.hasNextLine()) {
                Data += Reader.nextLine().replace(" ", "") + "\n";
            }
            String[] Rows = Data.split("\n");
            Filas = Rows.length;

            String[] Columns = Rows[0].split(",");
            Columnas = Columns.length;

            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Filas; i++) {
                Columns = Rows[i].split(",");

                Id = Integer.parseInt(Columns[0]);
                Carnet = Integer.parseInt(Columns[1]);
                Nombre = Columns[2];
                FechaNac = Columns[3];
                Genero = Columns[4];

                alumnos[Cont++] = new Alumno(Id, Carnet, Nombre, FechaNac, Genero);

                if (alumnos[i] != null) {
                    ++Cont2;
                }
            }

            System.out.println("\nFueron ingresados: " + Cont + " alumnos");

            for (int i = 0; i < Filas; i++) {
                System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                System.out.println("Fecha de Nacimiento: " + String.valueOf(alumnos[i].getFecha()));
                System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));
            }
            System.out.println("\n");
            Reader.close();
        } catch (Exception e) {
        }
    }

    public static void CargarCursos(String Ruta) {
        int Id, Codigo;
        String Nombre;

        try {
            File CSV = new File(Ruta);
            Scanner Reader = new Scanner(CSV);
            String Data = "";

            while (Reader.hasNextLine()) {
                Data += Reader.nextLine().replace(" ", "") + "\n";
            }
            String[] Rows = Data.split("\n");
            Filas = Rows.length;

            String[] Columns = Rows[0].split(",");
            Columnas = Columns.length;

            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Filas; i++) {
                Columns = Rows[i].split(",");

                Id = Integer.parseInt(Columns[0]);
                Codigo = Integer.parseInt(Columns[1]);
                Nombre = Columns[2];
                cursos[Cont++] = new Curso(Id, Codigo, Nombre);

                if (cursos[i] != null) {
                    ++Cont2;
                }
            }

            System.out.println("\nFueron ingresados: " + Cont + " cursos");

            for (int i = 0; i < Filas; i++) {
                System.out.println("\nId: " + String.valueOf(cursos[i].getId()));
                System.out.println("Codigo: " + String.valueOf(cursos[i].getCodigo()));
                System.out.println("Nombre: " + String.valueOf(cursos[i].getNombre()));
            }
            System.out.println("\n");
            Reader.close();
        } catch (Exception e) {
        }
    }

    public static void CargarProfesores(String Ruta) {
        int Id, Registro;
        String Nombre, FechaNac, FechaCont, Genero;

        try {
            File CSV = new File(Ruta);
            Scanner Reader = new Scanner(CSV);
            String Data = "";

            while (Reader.hasNextLine()) {
                Data += Reader.nextLine().replace(" ", "") + "\n";
            }
            String[] Rows = Data.split("\n");
            Filas = Rows.length;

            String[] Columns = Rows[0].split(",");
            Columnas = Columns.length;

            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Filas; i++) {
                Columns = Rows[i].split(",");

                Id = Integer.parseInt(Columns[0]);
                Registro = Integer.parseInt(Columns[1]);
                Nombre = Columns[2];
                FechaNac = Columns[3];
                FechaCont = Columns[4];
                Genero = Columns[5];

                profesores[Cont++] = new Profesor(Id, Registro, Nombre, FechaNac, FechaCont, Genero);

                if (profesores[i] != null) {
                    ++Cont2;
                }
            }

            System.out.println("\nFueron ingresados: " + Cont + " alumnos");

            for (int i = 0; i < Filas; i++) {
                System.out.println("\nId: " + String.valueOf(profesores[i].getId()));
                System.out.println("Registro: " + String.valueOf(profesores[i].getRegistro()));
                System.out.println("Nombre: " + String.valueOf(profesores[i].getNombre()));
                System.out.println("Fecha de Nacimiento: " + String.valueOf(profesores[i].getFecha_nacimiento()));
                System.out.println("Fecha de Contratación: " + String.valueOf(profesores[i].getFecha_contratacion()));
                System.out.println("Genero: " + String.valueOf(profesores[i].getGenero()));
            }
            System.out.println("\n");
            Reader.close();
        } catch (Exception e) {
        }
        
        public static void AsignarAlumnos(String Ruta) {
        int IdAlumno1 = IdAlumno;
        int IdCurso1 = IdCurso;
        double Nota1 = 0.0;
        Nota1 = Nota;

        try {
            File CSV = new File(Ruta);
            Scanner Reader = new Scanner(CSV);
            String Data = "";

            while (Reader.hasNextLine()) {
                Data += Reader.nextLine().replace(" ", "") + "\n";
            }
            String Rows[] = Data.split("\n");
            Filas = Rows.length;

            String Columns[] = Rows[0].split(",");
            Columnas = Columns.length;
            
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Filas; i++) {
                Columns = Rows[i].split(",");

                IdAlumno1 = Integer.parseInt(Columns[0]);
                IdCurso1 = Integer.parseInt(Columns[1]);

                Asignar[Cont++] = new Asignacion_alumno(IdAlumno1, IdCurso1, Nota1);
                
                if (Asignar[i] != null) {
                    ++Cont2;
                }
            }
            System.out.println("\nFueron asignados: " + Cont + " alumnos a sus cursos");

            for (int i = 0; i < Filas; i++) {
                System.out.println("\nId del Alumno: " + String.valueOf(Asignar[i].getId_alumno()));
                System.out.println("Id del Curso: " + String.valueOf(Asignar[i].getId_curso()));
            }
            Reader.close();
        } catch (Exception e) {

        }
    }
        
        public static void AsignarProfesores(String Ruta) {
        int IdProfesor1 = IdProfesor;
        int IdCurso1 = IdCurso;

        try {
            File CSV = new File(Ruta);
            Scanner Reader = new Scanner(CSV);
            String Data = "";

            while (Reader.hasNextLine()) {
                Data += Reader.nextLine().replace(" ", "") + "\n";
            }
            String Rows[] = Data.split("\n");
            Filas = Rows.length;

            String Columns[] = Rows[0].split(",");
            Columnas = Columns.length;
            
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Filas; i++) {
                Columns = Rows[i].split(",");

                IdProfesor1 = Integer.parseInt(Columns[0]);
                IdCurso1 = Integer.parseInt(Columns[1]);

                Asignar2[Cont++] = new Asignacion_prof(IdProfesor1, IdCurso1);
                
                if (Asignar2[i] != null) {
                    ++Cont2;
                }
            }
            System.out.println("\nFueron asignados: " + Cont + " profesores a sus cursos");

            for (int i = 0; i < Filas; i++) {
                System.out.println("\nId del Profesor: " + String.valueOf(Asignar2[i].getId_prof()));
                System.out.println("Id del Curso: " + String.valueOf(Asignar2[i].getId_curso()));
            }
            Reader.close();
        } catch (Exception e) {

        }
    }      
}
