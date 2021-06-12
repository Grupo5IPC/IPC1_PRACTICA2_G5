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
    static Asignacion_alumno[] Asignar = new Asignacion_alumno[200];
    static Asignacion_prof[] Asignar2 = new Asignacion_prof[30];
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

        // cargar alumno

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
                            
                        case 5:
                            System.out.println("Ingrese la ruta del archivo: ");
                            Ruta = escribirRuta.nextLine();
                            AsignarProfesores(Ruta);
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

          public static void CargarAlumnos(String Ruta) {
        int Id, Carnet;
        String Nombre, FechaNac, Genero;

        try {
            //Carga de Archivo e interpretación
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

            //Contador de filas en el archivo llenas de datos
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Rows.length; i++) {
                if (Rows[i] != null) {
                    ++Cont2;
                }
            }

            //Llena el arreglo con datos del archivo
            for (int i = 1; i <= Cont2; i++) {
                try {
                    try {
                        if (Rows[i] != null) {

                            Columns = Rows[i].split(",");

                            Id = Integer.parseInt(Columns[0]);
                            Carnet = Integer.parseInt(Columns[1]);
                            Nombre = Columns[2];
                            FechaNac = Columns[3];
                            Genero = Columns[4];

                            Alumno alumnos1 = new Alumno(Id, Carnet, Nombre, FechaNac, Genero);
                            alumnos[Cont++] = alumnos1;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                        //System.out.println("porque excede la capacidad de carga");
                    }
                } catch (Exception e) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque un elemento no coincide");
                    //Cont = Cont - 1;

                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (alumnos[i].getId() == alumnos[j].getId()) {
                                alumnos[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                                //System.out.println("porque su id es repetido");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (alumnos[i] == null) {

                        for (int j = i; j < alumnos.length - 1; j++) {
                            alumnos[j] = alumnos[j + 1];
                        }
                        alumnos[alumnos.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Agregar datos fuera de la carga solo si se borraron algunos datos incorrectos cargados
            int aux = 1;
            for (int i = 0; i <= alumnos.length; i++) {
                try {

                    if (alumnos[i] == null) {
                        int dato = alumnos.length - i;
                        int dato2 = i + dato + aux++;

                        if (Rows[dato2] != null) {

                            Columns = Rows[dato2].split(",");

                            Id = Integer.parseInt(Columns[0]);
                            Carnet = Integer.parseInt(Columns[1]);
                            Nombre = Columns[2];
                            FechaNac = Columns[3];
                            Genero = Columns[4];

                            Alumno alumnos1 = new Alumno(Id, Carnet, Nombre, FechaNac, Genero);
                            alumnos[i] = alumnos1;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque excede la capacidad de carga :0");
                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (alumnos[i].getId() == alumnos[j].getId()) {
                                alumnos[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "], ");
                                //System.out.println("porque su id es repetido :0");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (alumnos[i] == null) {

                        for (int j = i; j < alumnos.length - 1; j++) {
                            alumnos[j] = alumnos[j + 1];
                        }
                        alumnos[alumnos.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Contador de filas en el archivo llenas de datos
            int Cont3 = 0;
            for (int i = 0; i <= Rows.length; i++) {
                try {
                    if (alumnos[i] != null) {
                        ++Cont3;
                    }
                } catch (Exception e) {
                }
            }

            //Imprimimos los datos ingresados
            System.out.println("\nFueron ingresados: " + Cont3 + " alumnos");

            for (int i = 0; i < Cont2; i++) {
                if (alumnos[i] != null) {
                    /*System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                    System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                    System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                    System.out.println("Fecha de Nacimiento: " + String.valueOf(alumnos[i].getFecha()));
                    System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));*/
                }
            }
            System.out.println("\n");
            Reader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nSe ingresó un archivo que excede la capacidad de carga, ");
            System.out.println("pero se agregaron los datos correspondientes");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
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

            //Contador de filas en el archivo llenas de datos
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Rows.length; i++) {
                if (Rows[i] != null) {
                    ++Cont2;
                }
            }

            //Llena el arreglo con datos del archivo
            for (int i = 1; i <= Cont2; i++) {
                try {
                    try {
                        if (Rows[i] != null) {

                            Columns = Rows[i].split(",");

                            Id = Integer.parseInt(Columns[0]);
                            Registro = Integer.parseInt(Columns[1]);
                            Nombre = Columns[2];
                            FechaNac = Columns[3];
                            FechaCont = Columns[4];
                            Genero = Columns[5];

                            Profesor profesor1 = new Profesor(Id, Registro, Nombre, FechaNac, FechaCont, Genero);
                            profesores[Cont++] = profesor1;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                        //System.out.println("porque excede la capacidad de carga");
                    }
                } catch (Exception e) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque un elemento no coincide");
                    //Cont = Cont - 1;

                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (profesores[i].getId() == profesores[j].getId()) {
                                profesores[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                                //System.out.println("porque su id es repetido");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (profesores[i] == null) {

                        for (int j = i; j < profesores.length - 1; j++) {
                            profesores[j] = profesores[j + 1];
                        }
                        profesores[profesores.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Agregar datos fuera de la carga solo si se borraron algunos datos incorrectos cargados
            int aux = 1;
            for (int i = 0; i <= profesores.length; i++) {
                try {

                    if (profesores[i] == null) {
                        int dato = profesores.length - i;
                        int dato2 = i + dato + aux++;

                        if (Rows[dato2] != null) {

                            Columns = Rows[dato2].split(",");

                            Id = Integer.parseInt(Columns[0]);
                            Registro = Integer.parseInt(Columns[1]);
                            Nombre = Columns[2];
                            FechaNac = Columns[3];
                            FechaCont = Columns[4];
                            Genero = Columns[5];

                            Profesor profesores1 = new Profesor(Id, Registro, Nombre, FechaNac, FechaCont, Genero);
                            profesores[i] = profesores1;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque excede la capacidad de carga :0");
                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (profesores[i].getId() == profesores[j].getId()) {
                                profesores[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "], ");
                                //System.out.println("porque su id es repetido :0");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (profesores[i] == null) {

                        for (int j = i; j < profesores.length - 1; j++) {
                            profesores[j] = profesores[j + 1];
                        }
                        profesores[profesores.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Contador de filas en el archivo llenas de datos
            int Cont3 = 0;
            for (int i = 0; i <= Rows.length; i++) {
                try {
                    if (profesores[i] != null) {
                        ++Cont3;
                    }
                } catch (Exception e) {
                }
            }

            //Imprimimos los datos ingresados
            System.out.println("\nFueron ingresados: " + Cont3 + " profesores");

            for (int i = 0; i < Cont2; i++) {
                if (profesores[i] != null) {
                    /*System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                    System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                    System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                    System.out.println("Fecha de Nacimiento: " + String.valueOf(alumnos[i].getFecha()));
                    System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));*/
                }
            }
            System.out.println("\n");
            Reader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nSe ingresó un archivo que excede la capacidad de carga, ");
            System.out.println("pero se agregaron los datos correspondientes");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
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

            //Contador de filas en el archivo llenas de datos
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Rows.length; i++) {
                if (Rows[i] != null) {
                    ++Cont2;
                }
            }

            //Llena el arreglo con datos del archivo
            for (int i = 1; i <= Cont2; i++) {
                try {
                    try {
                        if (Rows[i] != null) {

                            Columns = Rows[i].split(",");

                            Id = Integer.parseInt(Columns[0]);
                            Codigo = Integer.parseInt(Columns[1]);
                            Nombre = Columns[2];
                            Curso cursos1 = new Curso(Id, Codigo, Nombre);
                            cursos[Cont++] = cursos1;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                        //System.out.println("porque excede la capacidad de carga");
                    }
                } catch (Exception e) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque un elemento no coincide");
                    //Cont = Cont - 1;

                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (cursos[i].getId() == cursos[j].getId()) {
                                cursos[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                                //System.out.println("porque su id es repetido");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (cursos[i] == null) {

                        for (int j = i; j < cursos.length - 1; j++) {
                            cursos[j] = cursos[j + 1];
                        }
                        cursos[cursos.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Agregar datos fuera de la carga solo si se borraron algunos datos incorrectos cargados
            int aux = 1;
            for (int i = 0; i <= cursos.length; i++) {
                try {

                    if (cursos[i] == null) {
                        int dato = cursos.length - i;
                        int dato2 = i + dato + aux++;

                        if (Rows[dato2] != null) {

                            Columns = Rows[dato2].split(",");

                            Id = Integer.parseInt(Columns[0]);
                            Codigo = Integer.parseInt(Columns[1]);
                            Nombre = Columns[2];
                            Curso cursos1 = new Curso(Id, Codigo, Nombre);
                            cursos[i] = cursos1;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque excede la capacidad de carga :0");
                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (cursos[i].getId() == cursos[j].getId()) {
                                cursos[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "], ");
                                //System.out.println("porque su id es repetido :0");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (cursos[i] == null) {

                        for (int j = i; j < cursos.length - 1; j++) {
                            cursos[j] = cursos[j + 1];
                        }
                        cursos[cursos.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Contador de filas en el archivo llenas de datos
            int Cont3 = 0;
            for (int i = 0; i <= Rows.length; i++) {
                try {
                    if (cursos[i] != null) {
                        ++Cont3;
                    }
                } catch (Exception e) {
                }
            }

            //Imprimimos los datos ingresados
            System.out.println("\nFueron ingresados: " + Cont3 + " cursos");

            for (int i = 0; i < Cont2; i++) {
                if (cursos[i] != null) {
                    /*System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                    System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                    System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                    System.out.println("Fecha de Nacimiento: " + String.valueOf(alumnos[i].getFecha()));
                    System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));*/
                }
            }
            System.out.println("\n");
            Reader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nSe ingresó un archivo que excede la capacidad de carga, ");
            System.out.println("pero se agregaron los datos correspondientes");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }
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

            //Contador de filas en el archivo llenas de datos
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Rows.length; i++) {
                if (Rows[i] != null) {
                    ++Cont2;
                }
            }

            //Llena el arreglo con datos del archivo
            for (int i = 1; i <= Cont2; i++) {
                try {
                    try {
                        if (Rows[i] != null) {

                            Columns = Rows[i].split(",");

                            IdAlumno1 = Integer.parseInt(Columns[0]);
                            IdCurso1 = Integer.parseInt(Columns[1]);

                            Asignacion_alumno asignar1 = new Asignacion_alumno(IdAlumno1, IdCurso1, Nota1);
                            Asignar[Cont++] = asignar1;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                        //System.out.println("porque excede la capacidad de carga");
                    }
                } catch (Exception e) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque un elemento no coincide");
                    //Cont = Cont - 1;

                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (Asignar[i].getId_alumno() == Asignar[j].getId_alumno() && Asignar[i].getId_curso() == Asignar[j].getId_curso()) {
                                Asignar[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                                //System.out.println("porque su id es repetido");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (Asignar[i] == null) {

                        for (int j = i; j < Asignar.length - 1; j++) {
                            Asignar[j] = Asignar[j + 1];
                        }
                        Asignar[Asignar.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Agregar datos fuera de la carga solo si se borraron algunos datos incorrectos cargados
            int aux = 1;
            for (int i = 0; i <= Asignar.length; i++) {
                try {

                    if (Asignar[i] == null) {
                        int dato = Asignar.length - i;
                        int dato2 = i + dato + aux++;

                        if (Rows[dato2] != null) {

                            Columns = Rows[dato2].split(",");

                            IdAlumno1 = Integer.parseInt(Columns[0]);
                            IdCurso1 = Integer.parseInt(Columns[1]);

                            Asignacion_alumno asignar1 = new Asignacion_alumno(IdAlumno1, IdCurso1, Nota1);
                            Asignar[i] = asignar1;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque excede la capacidad de carga :0");
                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (Asignar[i].getId_alumno() == Asignar[j].getId_alumno() && Asignar[i].getId_alumno() == Asignar[j].getId_curso()) {
                                Asignar[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "], ");
                                //System.out.println("porque su id es repetido :0");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (Asignar[i] == null) {

                        for (int j = i; j < Asignar.length - 1; j++) {
                            Asignar[j] = Asignar[j + 1];
                        }
                        Asignar[Asignar.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Contador de filas en el archivo llenas de datos
            int Cont3 = 0;
            for (int i = 0; i <= Rows.length; i++) {
                try {
                    if (Asignar[i] != null) {
                        ++Cont3;
                    }
                } catch (Exception e) {
                }
            }

            //Imprimimos los datos ingresados
            System.out.println("\nFueron asignados: " + Cont3 + " alumnos a sus cursos");

            for (int i = 0; i < Cont2; i++) {
                if (Asignar[i] != null) {
                    /*System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                    System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                    System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                    System.out.println("Fecha de Nacimiento: " + String.valueOf(alumnos[i].getFecha()));
                    System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));*/
                }
            }
            System.out.println("\n");
            Reader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nSe ingresó un archivo que excede la capacidad de carga, ");
            System.out.println("pero se agregaron los datos correspondientes");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
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

            //Contador de filas en el archivo llenas de datos
            int Cont = 0;
            int Cont2 = 0;
            for (int i = 1; i < Rows.length; i++) {
                if (Rows[i] != null) {
                    ++Cont2;
                }
            }

            //Llena el arreglo con datos del archivo
            for (int i = 1; i <= Cont2; i++) {
                try {
                    try {
                        if (Rows[i] != null) {

                            Columns = Rows[i].split(",");

                            IdProfesor1 = Integer.parseInt(Columns[0]);
                            IdCurso1 = Integer.parseInt(Columns[1]);

                            Asignacion_prof asignar2 = new Asignacion_prof(IdProfesor1, IdCurso1);
                            Asignar2[Cont++] = asignar2;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                        //System.out.println("porque excede la capacidad de carga");
                    }
                } catch (Exception e) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque un elemento no coincide");
                    //Cont = Cont - 1;

                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                            if (Asignar2[i].getId_prof() == Asignar2[j].getId_prof() && Asignar2[i].getId_curso() == Asignar2[j].getId_curso()) {
                                Asignar2[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                                //System.out.println("porque su id es repetido");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (Asignar2[i] == null) {

                        for (int j = i; j < Asignar2.length - 1; j++) {
                            Asignar2[j] = Asignar2[j + 1];
                        }
                        Asignar2[Asignar2.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Agregar datos fuera de la carga solo si se borraron algunos datos incorrectos cargados
            int aux = 1;
            for (int i = 0; i <= Asignar2.length; i++) {
                try {

                    if (Asignar2[i] == null) {
                        int dato = Asignar2.length - i;
                        int dato2 = i + dato + aux++;

                        if (Rows[dato2] != null) {

                            Columns = Rows[dato2].split(",");

                            IdProfesor1 = Integer.parseInt(Columns[0]);
                            IdCurso1 = Integer.parseInt(Columns[1]);

                            Asignacion_prof asignar2 = new Asignacion_prof(IdProfesor1, IdCurso1);
                            Asignar2[i] = asignar2;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "],");
                    //System.out.println("porque excede la capacidad de carga :0");
                }
            }

            //imprimir Id repetido
            for (int i = 0; i < Cont2; i++) {
                for (int j = 0; j < Cont2; j++) {
                    try {
                        if (i != j) {
                             if (Asignar2[i].getId_prof() == Asignar2[j].getId_prof() && Asignar2[i].getId_curso() == Asignar2[j].getId_curso()) {
                                Asignar2[j] = null;
                                //System.out.println("\nNo se pudo agregar el elemento en la fila " + "[" + i + "], ");
                                //System.out.println("porque su id es repetido :0");

                            } else {
                            }
                        } else {

                        }
                    } catch (Exception e) {
                    }
                }
            }

            //Id repetido mover posiciones de todo el arreglo
            for (int i = 0; i < Cont2; i++) {
                try {
                    if (Asignar2[i] == null) {

                        for (int j = i; j < Asignar2.length - 1; j++) {
                            Asignar2[j] = Asignar2[j + 1];
                        }
                        Asignar2[Asignar2.length - 1] = null;
                    } else {
                    }
                } catch (Exception e) {
                }
            }

            //Contador de filas en el archivo llenas de datos
            int Cont3 = 0;
            for (int i = 0; i <= Rows.length; i++) {
                try {
                    if (Asignar2[i] != null) {
                        ++Cont3;
                    }
                } catch (Exception e) {
                }
            }

            //Imprimimos los datos ingresados
            System.out.println("\nFueron asignados: " + Cont3 + " profesores a sus cursos");

            for (int i = 0; i < Cont2; i++) {
                if (Asignar2[i] != null) {
                    /*System.out.println("\nId: " + String.valueOf(alumnos[i].getId()));
                    System.out.println("Carnet: " + String.valueOf(alumnos[i].getCarnet()));
                    System.out.println("Nombre: " + String.valueOf(alumnos[i].getNombre()));
                    System.out.println("Fecha de Nacimiento: " + String.valueOf(alumnos[i].getFecha()));
                    System.out.println("Genero: " + String.valueOf(alumnos[i].getGenero()));*/
                }
            }
            System.out.println("\n");
            Reader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nSe ingresó un archivo que excede la capacidad de carga, ");
            System.out.println("pero se agregaron los datos correspondientes");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
