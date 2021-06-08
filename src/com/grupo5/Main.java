package com.grupo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import IPC1_PRACTICA2_G5.Alumnos.Alumno;

public class Main {

    public static Scanner MenuPrincipal = new Scanner(System.in);
    public static Scanner escribirRuta = new Scanner(System.in);
    public static Alumno[] alumnos = new Alumno[100];
    static String Ruta;
    static int Columnas, Filas;

    public static void main(String[] args) {
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

                            break;

                        case 3:

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
                Data += Reader.nextLine() + "\n";
            }
            String[] Rows = Data.split("\n");
            Filas = Rows.length;

            String[] Columns = Rows[0].split(",");
            Columnas = Columns.length;

            for (int i = 1; i < Filas; i++) {
                Columns = Rows[i].split(",");

                Id = Integer.parseInt(Columns[0]);
                Carnet = Integer.parseInt(Columns[1]);
                Nombre = Columns[2];
                FechaNac = Columns[3];
                Genero = Columns[4];

                alumnos[i] = new Alumno(Id, Carnet, Nombre, FechaNac, Genero);
            }
            System.out.println("\nFueron ingresados: " + (Filas - 1) + " Alumnos");

            for (int i = 1; i < Filas; i++) {
                System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                System.out.println("Fecha: " + String.valueOf(alumnos[i].getFecha()));
                System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));
            }
            System.out.println("\n");
            Reader.close();
        } catch (Exception e) {
        }
    }
}
