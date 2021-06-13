package com.grupo5;


import java.sql.Statement;

public class Handler {
    public static  Log log;
    public static String cadena ="";
    public Handler(Log log2){
        log = log2;

    }


    public  boolean ComprobarFila_Alumno( String fila[], int cont2) {
        boolean state = true;
        int cont = 0;
        if (cont2 == 0){
            log.add_Titulo("\\s Carga de Alumnos + \n");
        }
        if (fila.length == 5){

            try{
                //System.out.println("ID: "+ fila[0]);

               if (verficarEntero(fila[0].toString()) != true ){
                    log.addCuerpo("Error al convertir el ID \""+fila[0]+" \" ");
                   cont++;
               }
               if (verficarEntero(fila[1].toString()) != true){
                   log.addCuerpo("Error al convertir el ID \""+fila[0]+" \" ");
                   cont++;
               }
               if (verificarChar(fila[4]) == false){
                    log.addCuerpo("El genero ingresado debe ser \"M\" o \"F\": "+fila[4]+"");
                   cont++;
               }
               if (cont >0){

                   state = false;
               }


            }catch (Exception e){
                log.addCuerpo("El alumno con ID "+fila[0]+" no puede ser ingresado, verifique que todos los campos sean correctos");
                state = false;
            }
        }else{

            state = false;
        }
        //System.out.println(state);

        return state;
    }

    public  boolean ComprobarFilaprofesor( String fila[]) {
        boolean state = true;
        int cont = 0;
        if (fila.length == 6){
            try{
                if (verficarEntero(fila[0]) != true ){
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true){
                    cont++;
                }
                if (verificarChar(fila[5]) == false){
                    cont++;
                }
                if (cont >0){
                    state = false;
                }


            }catch (Exception e){
                state = false;
            }
        }else{

            state = false;
        }
        //System.out.println(state);

        return state;
    }
    public  boolean ComprobarFila_curso( String fila[]) {
        boolean state = true;
        int cont = 0;
        if (fila.length == 3){
            try{
                if (verficarEntero(fila[0].toString()) != true ){
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true){
                    cont++;
                }

                if (cont >0){
                    state = false;
                }


            }catch (Exception e){
                state = false;
            }
        }else{

            state = false;
        }
        //System.out.println(state);

        return state;
    }
    public  boolean ComprobarFila_asignacion( String fila[]) {
        boolean state = true;
        int cont = 0;
        if (fila.length == 2){
            try{
                if (verficarEntero(fila[0].toString()) != true ){
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true){
                    cont++;
                }

                if (cont >0){
                    state = false;
                }


            }catch (Exception e){
                state = false;
            }
        }else{

            state = false;
        }
        //System.out.println(state);

        return state;
    }
    public  boolean ComprobarFila_notas( String fila[]) {
        boolean state = true;
        int cont = 0;
        if (fila.length == 3){
            try{
                if (verficarEntero(fila[0].toString()) != true ){
                    cont++;
                }
                if (verficarEntero(fila[1].toString()) != true){
                    cont++;
                }
                if (verficarDecimal(fila[2].toString()) != true){
                    cont++;
                }
                if (verificarNota(fila[2].toString()) != true){
                    cont++;
                }

                if (cont >0){
                    state = false;
                }


            }catch (Exception e){
                state = false;
            }
        }else{

            state = false;
        }
        //System.out.println(state);

        return state;
    }


    private boolean verficarEntero(String parse){
        try{

            Integer.parseInt(parse);
            return true;
        }catch (Exception e){
            return false;
        }


    }
    private boolean verficarDecimal(String parse){
        try{

            Double.parseDouble(parse);
            return true;
        }catch (Exception e){
            return false;
        }


    }
    private boolean verificarChar(String parse){
        boolean state = false;
        try {
            char genero = Character.toUpperCase(parse.charAt(0));

            if (genero == 'M' ) {
                state = true;
            }else if (genero == 'F'){
                state = true;
            }
        }catch (Exception e){
            state = false;
        }
        return state;
    }
    private static boolean verificarNota(String parse){
        try{
            double nota = Double.parseDouble(parse);
            if (nota <0 || nota > 100){
                return false;
            }else {
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }

}
