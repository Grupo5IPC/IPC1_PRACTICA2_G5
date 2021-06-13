package com.grupo5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import com.grupo5.Cursos.Curso;
import com.grupo5.Alumnos.*;
import com.grupo5.Cursos.*;
import com.grupo5.Profesores.*;
import com.grupo5.Usuarios.*;

public class Main {

    //public static Scanner MenuPrincipal = new Scanner(System.in);
    public static Scanner escribirRuta = new Scanner(System.in);
    public static Curso[] cursos = new Curso[15];
    public static Profesor[] profesores = new Profesor[20];
    public static Alumno[] alumnos = new Alumno[100];
    static Asignacion_alumno[] Asignar = new Asignacion_alumno[200];
    static Asignacion_prof[] Asignar2 = new Asignacion_prof[30];
    static String Ruta, Log;
    static int Columnas, Filas, IdAlumno, IdCurso, IdProfesor, Nota, alum, curs, profs, asig_alum, asig_prof;
    public static Gestor_alumno gestor_alumno;
    public static Gestor_curso gestor_curso;
    public static Gestor_profesor gestor_profesor;
    public static Gestor_usuarios gestor_usuarios;
    public static Handler verificaciones;
    public static Reportes reportes;
    public static Log log;


    public static void main(String[] args) {
        gestor_alumno = new Gestor_alumno();
        gestor_curso = new Gestor_curso();
        gestor_profesor = new Gestor_profesor();
        gestor_usuarios = new Gestor_usuarios();
        log = new Log();
        verificaciones = new Handler(log);
        reportes = new Reportes();

        menuPrincipal();

    }

    public static void menuPrincipal() {
       Scanner login = new Scanner(System.in);
        Scanner MenuPrincipal = new Scanner(System.in);
        try {
            System.out.println("*******************************");
            System.out.println("*           LOGIN             *");
            System.out.println("*******************************");
            System.out.println("* Ingrese su usuario          *");
            String user = login.nextLine();
            System.out.println("* Ingrese su contraseña       *");
            String pass = login.nextLine();
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
                        System.out.println("* 8) Cerrar sesion            *");
                        System.out.println("* 9) Salir                    *");
                        System.out.println("*******************************");
                        System.out.print("Elige una opcion: ");
                        Opciones = MenuPrincipal.nextInt();
                        switch (Opciones) {
                            case 1:

                                C_alumnos();
                                break;

                            case 2:
                                C_profesores();
                                break;

                            case 3:
                                C_cursos();
                                break;

                            case 4:
                                A_alumnos();
                                break;

                            case 5:
                                A_profesores();
                                break;

                            case 6:
                                ingresoNotas();
                                break;
                            case 7:
                                NuevoUser();
                                break;

                            case 8:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                menuPrincipal();
                                break;
                            case 9:
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
                } while (Opciones != 9);
            } else if (gestor_usuarios.verificar(user, pass)) {
                do {
                    try {
                        System.out.println("*************************************");
                        System.out.println("*           MENÚ DE REPORTES        *");
                        System.out.println("*************************************");
                        System.out.println("* 1) Reporte de Alumnos             *");
                        System.out.println("* 2) Reporte asignacion Alumnos     *");
                        System.out.println("* 3) Reporte asignacion Profesores  *");
                        System.out.println("* 4) Reporte General                *");
                        System.out.println("* 5) Reporte Especifico             *");
                        System.out.println("* 6) Top 5 Mejores Alumnos          *");
                        System.out.println("* 7) Cerrar sesion                  *");
                        System.out.println("* 7) Salir                          *");
                        System.out.println("*************************************");
                        System.out.print("Elige una opcion: ");
                        Opciones = MenuPrincipal.nextInt();
                        switch (Opciones) {
                            case 1:
                                repAlumnos();
                                break;

                            case 2:
                                repAsignacion_alumnos();
                                break;

                            case 3:
                                repAsignacion_profesores();
                                break;

                            case 4:
                                repCursos();
                                break;
                            case 5:
                                repCurso();
                                break;
                            case 6:
                                repTop5();
                                break;
                            case 7:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                menuPrincipal();
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
        if ( npass.equals(npass2)) {
            if (gestor_usuarios.verificar(nuser,npass)) {
                gestor_usuarios.Ins_usu(nuser, npass);
                System.out.println("\nAgregado corretamente \n");
            }else{
                System.out.println("El usuario ya existe, intentelo de nuevo");
            }
        } else {
            System.out.println("Error: ocurrio un problema en su registro");
            System.out.println("Vuelva a intentarlo");
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------

    public static void C_alumnos() {
        String aux = Log;
        int cont = 0;
        if (gestor_alumno.verificar_cant() == 100) {
            System.out.println("Ya se han ingresado la cantidad maxima de alumnos");
        } else {
            try {
                String filas[] = getFilas();
                String col[] = filas[0].split(",");

                for (int i = 0; i < filas.length; i++) {
                    col = filas[i].split(",");
                    if (!verificaciones.ComprobarFila_Alumno(filas[i].split(","), cont, i)) {
                        if (cont == 0){


                            cont++;
                        }

                        //System.out.println("pasa");
                        continue;
                    }

                    if ((gestor_alumno.verificar_alum_carnet(Integer.parseInt(col[1]))) && (gestor_alumno.verificar_alum_id(Integer.parseInt(col[0])))) {
                        if (gestor_alumno.verificar_cant() == 100) {
                            System.out.println("Limite de carga Alcanzado");
                            break;
                        } else {

                            char genero = col[4].charAt(0);
                            gestor_alumno.Ins_alum(Integer.parseInt(col[0]), Integer.parseInt(col[1]), col[2], col[3], genero);
                            alum++;
                        }
                    } else {
                        log.addCuerpo("El Carnet o ID ingresado: "+col[1]+", "+col[0]+" ya se encuentra registrado");
                    }
                }
                if (cont>0){
                    printErrores();
                }
                gestor_alumno.print_alumnos();


            } catch (Exception e) {
                System.out.println("Hubo un error" + e);

            }


        }
    }

    public static void C_profesores() {
        int cont = 0;
        if (gestor_profesor.verificar_cant() == 20) {
            System.out.println("Ya se han ingresado la cantidad maxima de profesores");
        } else {
            try {
                String filas[] = getFilas();
                String col[] = filas[0].split(",");

                for (int i = 1; i < filas.length; i++) {
                    col = filas[i].split(",");
                    if (!verificaciones.ComprobarFilaprofesor(filas[i].split(","), cont , i)) {
                        if (cont == 0){


                            cont++;
                        }
                        //System.out.println("pasa");
                        continue;
                    }

                    if ((gestor_profesor.verificar_prof_registro(Integer.parseInt(col[1]))) && (gestor_profesor.verificar_prof_id(Integer.parseInt(col[0])))) {
                        if (gestor_profesor.verificar_cant() == 20) {
                            System.out.println("Limite de carga alcanzado");
                            break;
                        } else {

                            char genero = col[5].charAt(0);
                            gestor_profesor.Ins_prof(Integer.parseInt(col[0]), Integer.parseInt(col[1]), col[2], col[3], col[4], genero);
                            profs++;
                        }
                    } else {
                        log.addCuerpo("El Registro o ID ingresado: "+col[1]+", "+col[0]+" ya se encuentra registrado, no se ha podido cargar ");
                    }
                }
                if (cont>0){
                    printErrores();
                }
                gestor_profesor.print_profesores();


            } catch (Exception e) {
                System.out.println("Hubo un error" + e);

            }


        }
    }

    public static void C_cursos() {
        int cont = 0;
        if (gestor_curso.verificar_cant() == 14) {
            System.out.println("Ya se han ingresado la cantidad maxima de cursos");
        } else {
            try {
                String filas[] = getFilas();
                String col[] = filas[0].split(",");

                for (int i = 1; i < filas.length; i++) {
                    col = filas[i].split(",");
                    if (!verificaciones.ComprobarFila_curso(filas[i].split(","), cont , i)) {
                        //System.out.println("pasa");
                        if (cont == 0){
                            cont++;
                        }
                        continue;
                    }

                    if ((gestor_curso.verificar_curso_codigo(Integer.parseInt(col[1]))) && (gestor_curso.verificar_curso_id(Integer.parseInt(col[0])))) {
                        if (gestor_profesor.verificar_cant() == 14) {
                            System.out.println("Limite de carga alcanzado ");
                            break;
                        } else {

                            gestor_curso.Ins_curso(Integer.parseInt(col[0]), Integer.parseInt(col[1]), col[2]);
                            curs++;

                        }
                    } else {
                        log.addCuerpo("El Codigo o ID ingresado: "+col[1]+", "+col[0]+" ya se encuentran registrado, no se ha podido cargar ");
                    }
                }
                if (cont>0){
                    printErrores();
                }
                gestor_curso.print_cursos();


            } catch (Exception e) {
                System.out.println("Hubo un error" + e);

            }


        }
    }

    public static void A_alumnos() {
        int cont = 0;
        String cadena ="";
        String ids = "";
        if (curs > 0 && alum > 0) {
            if (gestor_alumno.cantidad_filas() == 199) {
                System.out.println("Inscripcion maxima alcanzada");

            } else {
                try {
                    String filas[] = getFilas();
                    String col[] = filas[0].split(",");
                    for (int i = 1; i < filas.length; i++) {
                        col = filas[i].split(",");
                        if (!verificaciones.ComprobarFila_asignacion(filas[i].split(","), 1,cont, i)) {
                            if (cont == 0){
                                cont ++;
                            }
                            //System.out.println("pasa");
                            continue;
                        }
                        if (gestor_alumno.verificar_alum_id(Integer.parseInt(col[0])) == false) {
                            if (gestor_curso.verificar_curso_id(Integer.parseInt(col[1])) == false) {
                                if (gestor_alumno.verificar_asign(Integer.parseInt(col[0]), Integer.parseInt(col[1])) == true) {
                                    if (gestor_alumno.cantidad_filas() == 99) {
                                        System.out.println("Inscripcion maxima alcanzada");
                                        break;
                                    } else {
                                        gestor_alumno.asginar_curso(Integer.parseInt(col[0]), Integer.parseInt(col[1]));
                                        asig_alum++;
                                    }

                                } else {
                                    cadena += col[0] +","+col[1];
                                }
                            } else {
                                ids += col[0] +"," + col[1];
                                log.addCuerpo("EL curso con ID "+ col[1]+" no existe, el alumno con ID "+ col[0]+" no se asigno");
                            }

                        } else {
                            ids += col[0] +"," + col[1];
                            log.addCuerpo("EL alumno con ID "+ col[0]+", no existe, no se realizo asignacion a "+ col[1]);
                        }
                    }
                    if (!ids.equals("")){
                        System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo: ");
                        System.out.println(ids);
                    }
                    if (!cadena.equals("")){
                        System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo, porque ya se encontraban realizadas: ");
                        System.out.println(cadena);
                    }
                    if (cont>0){
                        printErrores();
                    }

                    gestor_alumno.print_asig();
                } catch (Exception e) {

                }
            }
        }
    }

    public static void A_profesores() {
        int cont = 0;
        String cadena ="";
        String ids = "";
        if (profs > 0 && curs > 0) {
            if (gestor_profesor.cantidad_filas_asig() == 29) {
                System.out.println("Asignacion maxima alcanzada");

            } else {
                try {
                    String filas[] = getFilas();
                    String col[] = filas[0].split(",");
                    for (int i = 1; i < filas.length; i++) {
                        col = filas[i].split(",");
                        if (!verificaciones.ComprobarFila_asignacion(filas[i].split(","),2,cont,i)) {
                            //System.out.println("pasa");
                            if (cont == 0){
                                cont ++;
                            }
                            continue;
                        }
                        if (gestor_profesor.verificar_prof_id(Integer.parseInt(col[0])) == false) {
                            if (gestor_curso.verificar_curso_id(Integer.parseInt(col[1])) == false) {
                                if (gestor_profesor.verificar_asign(Integer.parseInt(col[0]), Integer.parseInt(col[1])) == true) {
                                    if (gestor_profesor.cantidad_filas_asig() == 29) {
                                        System.out.println("Asignacion maxima alcanzada");
                                        break;
                                    } else {
                                        gestor_profesor.asginar_curso(Integer.parseInt(col[0]), Integer.parseInt(col[1]));
                                        asig_prof++;
                                    }

                                } else {
                                    cadena += col[0] +","+col[1];
                                }
                            } else {
                                ids += col[0] +"," + col[1];
                                log.addCuerpo("EL curso con ID "+ col[1]+" no existe, el profesor con ID "+ col[0]+" no se asigno");
                            }

                        } else {
                            ids += col[0] +"," + col[1];
                            log.addCuerpo("EL profesor con ID "+ col[0]+", no existe, no se realizo asignacion a "+ col[1]);
                        }
                    }
                    if (!ids.equals("")){
                        System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo: ");
                        System.out.println(ids);
                    }
                    if (!cadena.equals("")){
                        System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo, porque ya se encontraban realizadas: ");
                        System.out.println(cadena);
                    }
                    if (cont>0){
                        printErrores();
                    }

                    gestor_profesor.print_asig();
                } catch (Exception e) {

                }
            }
        }
    }

    public static void ingresoNotas() {
        int cont = 0;
        String ids = "", cadena = "";
        if (curs > 0 && alum > 0) {
            if (gestor_alumno.cantidad_filas_notas() == 199) {
                System.out.println("Limite de asignacion de notas maxima alcanzada");

            } else {
                try {
                    String filas[] = getFilas();
                    String col[] = filas[0].split(",");
                    for (int i = 1; i < filas.length; i++) {
                        col = filas[i].split(",");
                        if (!verificaciones.ComprobarFila_notas(filas[i].split(","), cont, i)) {
                            //System.out.println("pasa");
                            if (cont == 0){
                                cont++;
                            }
                            continue;
                        }
                        if (gestor_alumno.verificar_asign(Integer.parseInt(col[0]), Integer.parseInt(col[1])) == false) {

                            if (gestor_alumno.verificarIngreso(Integer.parseInt(col[0]), Integer.parseInt(col[1])) == true) {
                                if (gestor_alumno.cantidad_filas_notas() == 199) {
                                    System.out.println("Limite de asignacion de notas maxima alcanzada");
                                    break;
                                } else {
                                    double nota = Double.parseDouble(col[2]);
                                    gestor_alumno.asginarNota(Integer.parseInt(col[0]), Integer.parseInt(col[1]), nota);

                                }

                            } else {
                                cadena += col[0] + ", "+ col[1]+", "+col[2] +"\n";
                            }
                        }else{
                            ids += col[0] + ", "+ col[1]+", "+col[2] +"\n";
                            log.addCuerpo("EL alumno con ID "+ col[0]+", no esta asignado a "+col[1]);

                        }

                    }
                    if (!ids.equals("")){
                        System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo, porque los alumnos no estan asignados: ");
                        System.out.println(ids);

                    }
                    if (!cadena.equals("")){
                        System.out.println("Las siguientes asignaciones no se pudieron llevar a cabo, porque los alumnos ya tienen nota ingresada: ");
                        System.out.println(ids);
                    }
                    if (cont>0){
                        printErrores();
                    }
                    gestor_alumno.printNota();

                } catch (Exception e) {

                }
            }
        }

    }
    public static String getContentOfFile(String pathname) {
        File archive = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archive = new File(pathname);
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {

            System.out.println("No se ha podido encontrar el archivo");
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (NullPointerException e) {
                System.out.println("No ha seleccionado ningún archivo");
            } catch (Exception e) {
                System.out.println();
            }
        }
        return "";
    }

    public static String[] getFilas() {

        String filas[];


        System.out.println("*         Ingrese la ruta de la lista de alumnos   *");
        Scanner ruta = new Scanner(System.in);
        String auxi = ruta.next();

        String prueba = getContentOfFile(auxi);
        prueba.trim(); //QUITAMOS LOS ESPACIOS
        String s = prueba.trim();


        filas = s.split("\n");

        String[] aux = new String[filas.length];

        for (int i = 0; i < aux.length; i++) {
            aux[i] = "";
        }

        for (int i = 0; i < filas.length; i++) {
            String[] columnas = filas[i].split(",");
            String cola = columnas[0].trim() + ",";


            for (int j = 0; j < columnas.length; j++) {
                String col = columnas[j].trim() + ",";

                if (j != 2) {
                    aux[i] += col;

                } else aux[i] += col;

            }

        }



        //System.out.println(filas[1]);
        return aux;


    }

    // REPORTES

    public static void repAlumnos() {
        if (alum > 0) {
            int filas = gestor_alumno.verificar_cant();

            String[][] m = new String[filas][3];
            for (int i = 0; i < m.length; i++) {
                m[i][0] = String.valueOf(gestor_alumno.getCarnet(i));
                m[i][1] = String.valueOf(gestor_alumno.getNombre(i));
                m[i][2] = String.valueOf(gestor_alumno.getGenero(i));

            }
            int menor;

            for (int x = 0; x < m.length; x++) {

                for (int i = 0; i < m.length - x - 1; i++) {
                    if (Integer.parseInt(m[i][0]) > Integer.parseInt(m[i + 1][0])) {
                        int tmp = Integer.parseInt(m[i + 1][0]);
                        String tmp_n = m[i + 1][1];
                        String tmp_idc = m[i + 1][2];

                        m[i + 1][0] = m[i][0];
                        m[i + 1][1] = m[i][1];
                        m[i + 1][2] = m[i][2];

                        m[i][0] = String.valueOf(tmp);
                        m[i][1] = tmp_n;
                        m[i][2] = tmp_idc;

                    }
                }

            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    System.out.print(m[i][j] + ",");
                }
                System.out.println();
            }

            //
            reportes.add_alumnos(m);

        } else {
            System.out.println("No se ha podido generar el reporte: Aun no se han cargado alumnos");
        }
    }

    public static void repAsignacion_alumnos() {
        if (asig_alum > 0) {
            int filas = gestor_alumno.cantidad_filas();

            String[][] m = new String[filas][4];
            for (int i = 0; i < filas; i++) {
                int id = gestor_alumno.get_id_al(i);
                m[i][0] = String.valueOf(gestor_alumno.getCarnetAsig(id));
                m[i][1] = gestor_alumno.buscar_nombre_alumn(id);
                int idCurso = gestor_alumno.get_id_curso(i);
                m[i][2] = String.valueOf(gestor_curso.buscarCodigo_clase(idCurso));
                m[i][3] = gestor_curso.buscar_nombre_clase(idCurso);
            }
            int menor;

            for (int x = 0; x < m.length; x++) {

                for (int i = 0; i < m.length - x - 1; i++) {
                    if (Integer.parseInt(m[i][0]) > Integer.parseInt(m[i + 1][0])) {
                        int tmp = Integer.parseInt(m[i + 1][0]);
                        String tmp_n = m[i + 1][1];
                        int tmp_idc = Integer.parseInt(m[i + 1][2]);
                        String c = m[i + 1][3];
                        m[i + 1][0] = m[i][0];
                        m[i + 1][1] = m[i][1];
                        m[i + 1][2] = m[i][2];
                        m[i + 1][3] = m[i][3];
                        m[i][0] = String.valueOf(tmp);
                        m[i][1] = tmp_n;
                        m[i][2] = String.valueOf(tmp_idc);
                        m[i][3] = c;
                    }
                }

            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    System.out.print(m[i][j] + ",");
                }
                System.out.println();
            }
            reportes.addAsignacion_alumnos(m);

        } else {
            System.out.println("Aun no se han asignado alumnos");
        }
    }

    public static void repAsignacion_profesores() {
        if (asig_prof > 0) {
            int filas = gestor_profesor.cantidad_filas_asig();

            String[][] m = new String[filas][4];
            for (int i = 0; i < filas; i++) {

                int id = gestor_profesor.get_id_prof(i);
                m[i][0] = String.valueOf(gestor_profesor.buscar_Registro_prof(id));
                m[i][1] = gestor_profesor.buscar_nombre_prof(id);
                int idCurso = gestor_alumno.get_id_curso(i);
                m[i][2] = String.valueOf(gestor_curso.buscarCodigo_clase(idCurso));
                m[i][3] = gestor_curso.buscar_nombre_clase(idCurso);
            }
            int menor;

            for (int x = 0; x < m.length; x++) {

                for (int i = 0; i < m.length - x - 1; i++) {
                    if (Integer.parseInt(m[i][0]) > Integer.parseInt(m[i + 1][0])) {
                        int tmp = Integer.parseInt(m[i + 1][0]);
                        String tmp_n = m[i + 1][1];
                        int tmp_idc = Integer.parseInt(m[i + 1][2]);
                        String c = m[i + 1][3];
                        m[i + 1][0] = m[i][0];
                        m[i + 1][1] = m[i][1];
                        m[i + 1][2] = m[i][2];
                        m[i + 1][3] = m[i][3];
                        m[i][0] = String.valueOf(tmp);
                        m[i][1] = tmp_n;
                        m[i][2] = String.valueOf(tmp_idc);
                        m[i][3] = c;
                    }
                }

            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    System.out.print(m[i][j] + ",");
                }
                System.out.println();
            }
            reportes.addAsignacion_alumnos(m);
        } else {
            System.out.println("Aun no se han asignado profesores");
        }

    }

    public static void repCursos() {
        if (asig_alum > 0) {
            int filas = gestor_curso.verificar_cant();

            String[][] m = new String[filas][3];
            for (int i = 0; i < m.length; i++) {
                int id = gestor_curso.getIdcurso(i);
                m[i][0] = String.valueOf(gestor_curso.buscarCodigo_clase(id));
                m[i][1] = String.valueOf(gestor_curso.buscar_nombre_clase(id));
                m[i][2] = String.valueOf(gestor_alumno.cantidad_filas_asig(id));

            }
            int menor;

            for (int x = 0; x < m.length; x++) {

                for (int i = 0; i < m.length - x - 1; i++) {
                    if (Integer.parseInt(m[i][0]) > Integer.parseInt(m[i + 1][0])) {
                        int tmp = Integer.parseInt(m[i + 1][0]);
                        String tmp_n = m[i + 1][1];
                        String tmp_idc = m[i + 1][2];

                        m[i + 1][0] = m[i][0];
                        m[i + 1][1] = m[i][1];
                        m[i + 1][2] = m[i][2];

                        m[i][0] = String.valueOf(tmp);
                        m[i][1] = tmp_n;
                        m[i][2] = tmp_idc;

                    }
                }

            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    System.out.print(m[i][j] + ",");
                }
                System.out.println();
            }

            //
            reportes.addCursos(m);

        } else {
            System.out.println("No se ha podido generar el reporte: Aun no se han cargado alumnos");
        }
    }

    public static void repCurso() {

        boolean sta = false;
        String encabezado = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("|''''''''''''''' Reporte de cursos ''''''''''''''''''''''''''|");
            gestor_curso.print_cursos();
            System.out.println("Ingrese el ID del curso");
            int or = sc.nextInt();
            int contador = 0;
            if (gestor_curso.verificar_curso_id(or) == false) {
                encabezado += "Curso " + gestor_curso.buscar_nombre_clase(or) + "<br>Impartido por:";


                if (asig_prof > 0) {
                    int[] ids = gestor_profesor.cant_getIdprof_curso(or);
                    for (int i = 0; i < ids.length; i++) {
                        encabezado += gestor_profesor.buscar_nombre_prof(ids[i]);
                        encabezado += " Registro: " + String.valueOf(gestor_profesor.buscar_Registro_prof(ids[i])) + ", ";
                    }


                }


                int ids[] = gestor_alumno.getIds_encurso(or);
                String m[][] = new String[ids.length][4];
                int c = 0;
                for (int i = 0; i < ids.length; i++) {
                    m[i][0] = String.valueOf(gestor_alumno.getCarnetAsig(ids[i]));
                    m[i][1] = gestor_alumno.buscar_nombre_alumn(ids[i]);

                    m[i][2] = String.valueOf(gestor_alumno.buscarNota(ids[i], or));
                    double nota = gestor_alumno.buscarNota(ids[i], or);
                    if (nota >= 61) {
                        m[i][3] = "Aprobado";
                    } else {
                        m[i][3] = "Reprobado";
                    }

                }


                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[0].length; j++) {
                        System.out.print(m[i][j] + ",");
                    }
                    System.out.println();
                }

                reportes.addCurso(encabezado, m);

            } else {
                System.out.println("No se ha encontrado el curso solicitado");
                sta = false;
            }
        } while (sta == false);
    }

    public static void repTop5() {

        boolean sta = false;
        String encabezado = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("|''''''''''''''' Top 5 mejores Alumnos ''''''''''''''''''''''''''|");
            gestor_curso.print_cursos_codigo();
            System.out.println("Ingrese el codigo del curso");
            int or = sc.nextInt();
            int contador = 0;
            if (gestor_curso.verificar_curso_codigo(or) == false) {
                int id = gestor_curso.buscarId_clase(or);
                encabezado += "Curso " + gestor_curso.buscar_nombre_clase(id) + "<br>Impartido por:";


                if (asig_prof > 0) {
                    int[] ids = gestor_profesor.cant_getIdprof_curso(id);
                    for (int i = 0; i < ids.length; i++) {
                        encabezado += gestor_profesor.buscar_nombre_prof(ids[i]);
                        encabezado += " Registro: " + String.valueOf(gestor_profesor.buscar_Registro_prof(ids[i])) + ", ";
                    }


                }


                int ids[] = gestor_alumno.getIds_encurso(or);
                String m[][] = new String[ids.length][3];

                for (int i = 0; i < ids.length; i++) {
                    m[i][0] = String.valueOf(gestor_alumno.getCarnetAsig(ids[i]));
                    m[i][1] = gestor_alumno.buscar_nombre_alumn(ids[i]);

                    m[i][2] = String.valueOf(gestor_alumno.buscarNota(ids[i], or));


                }
                for (int x = 0; x < m.length; x++) {

                    for (int i = 0; i < m.length - x - 1; i++) {
                        if (Double.parseDouble(m[i][2]) < Double.parseDouble(m[i + 1][2])) {
                            int tmp = Integer.parseInt(m[i + 1][0]);
                            String tmp_n = m[i + 1][1];
                            double tmp_idc = Double.parseDouble(m[i + 1][2]);
                            m[i + 1][0] = m[i][0];
                            m[i + 1][1] = m[i][1];
                            m[i + 1][2] = m[i][2];
                            m[i][0] = String.valueOf(tmp);
                            m[i][1] = tmp_n;
                            m[i][2] = String.valueOf(tmp_idc);

                        }
                    }

                }


                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m[0].length; j++) {
                        System.out.print(m[i][j] + ",");
                    }
                    System.out.println();
                }

                reportes.addTop5(encabezado, m);

            } else {
                System.out.println("No se ha encontrado el curso solicitado");
                sta = false;
            }
        } while (sta == false);

    }
    public static void printErrores(){
        System.out.println("----------------------------------------------------");
        System.out.println("Se produjeron excepciones durante este Proceso, verificar el registro ubicado en Log\\"+log.n_reporte+".txt");
    }


}
