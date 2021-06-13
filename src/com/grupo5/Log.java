package com.grupo5;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class Log {
    public static String n_reporte;
    public boolean m_ing = false;

    public Log(){
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minutos = fecha.get(Calendar.MINUTE);
        n_reporte = dia + "-" + mes + "-" + año + " " + hora + "." + minutos;
        try {
            File directorio = new File("Log");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {

                } else {

                }
            }
            File archivo = new File("Log/" + n_reporte + ".txt");
            if (archivo.createNewFile()) {

            } else {
                archivo = new File("Log/" + n_reporte + "(1).txt");
                archivo.createNewFile();
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }


    public static void add_Titulo(String cadena){
        try {
            FileWriter fn = new FileWriter("Log/" + n_reporte + ".txt", true);
            Calendar fecha = Calendar.getInstance();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minutos = fecha.get(Calendar.MINUTE);
            String aux = dia + "-" + mes + "-" + año + " " + hora + "." + minutos+": ";
            String texto = cadena + " " + aux +"\n";
            fn.write(texto);
            fn.close();
        } catch (Exception e) {

        }
    }

    public static void addCuerpo(String cadena){
        try {
            FileWriter fn = new FileWriter("Log/" + n_reporte + ".txt", true);
            Calendar fecha = Calendar.getInstance();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minutos = fecha.get(Calendar.MINUTE);
            String aux = dia + "-" + mes + "-" + año + " " + hora + "." + minutos+": ";
            String texto = aux.concat(cadena + "\n");
            fn.write(texto);
            fn.close();
        } catch (Exception e) {

        }
    }



}
