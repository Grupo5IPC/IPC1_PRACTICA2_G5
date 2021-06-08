package com.grupo5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author Ludwin
 */
public class Reportes {
    public String n_reporte;

    public boolean m_ing = false;

    public Reportes() {
        Calendar fecha = Calendar.getInstance();
        int year = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minutos = fecha.get(Calendar.MINUTE);
        n_reporte = dia + "-" + mes + "-" + year + " " + hora + "." + minutos;

        try {
            File directorio = new File("Reportes");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {

                } else {

                }
            }
            File archivo = new File("Reportes/" + n_reporte + ".html");
            if (archivo.createNewFile()) {

            } else {
                archivo = new File("Reportes/" + n_reporte + "(1).html");
                archivo.createNewFile();
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        css();
        html();
    }

    public void css() {
        File style = new File("Reportes/css/style.css");
        File directorio = new File("Reportes/css");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {

            } else {

            }
        }
        try {

            if (style.createNewFile()) {

                try {
                    FileWriter fn = new FileWriter(style, false);
                    String cont = "* {\n" +
                            "    box-sizing: border-box;\n" +
                            "    font-family: 'Futura BdCn BT', sans-serif;\n" +
                            "    margin: 0;\n" +
                            "}\n" +
                            "\n" +
                            "p{\n" +
                            "    font-size: 20px;\n" +
                            "}\n" +
                            "\n" +
                            ".margen\n" +
                            "{\n" +
                            "    padding: 20px;\n" +
                            "    margin: 10px;\n" +
                            "}\n" +
                            "\n" +
                            "body {\n" +
                            "    margin: 0;\n" +
                            "    font-family: -apple-system,BlinkMacSystemFont,\"Segoe UI\",Roboto,\"Helvetica Neue\",Arial,\"Noto Sans\",sans-serif,\"Apple Color Emoji\",\"Segoe UI Emoji\",\"Segoe UI Symbol\",\"Noto Color Emoji\";\n" +
                            "    font-size: 1rem;\n" +
                            "    font-weight: 400;\n" +
                            "    line-height: 1.5;\n" +
                            "\n" +
                            "    text-align: left;\n" +
                            "    background-color: #fff;\n" +
                            "}\n" +
                            "section {\n" +
                            "    display: block;\n" +
                            "}\n" +
                            ".container {\n" +
                            "    width: 100%;\n" +
                            "    padding: 15px;\n" +
                            "    margin-right: auto;\n" +
                            "    margin-left: auto;\n" +
                            "}\n" +
                            "@media (min-width: 1200px){\n" +
                            ".container {\n" +
                            "    max-width: 1140px;\n" +
                            "}\n" +
                            "}\n" +
                            "@media (min-width: 992px){\n" +
                            ".container {\n" +
                            "    max-width: 960px;\n" +
                            "}\n" +
                            "}\n" +
                            "\n" +
                            "@media (min-width: 768px){\n" +
                            ".container {\n" +
                            "    max-width: 720px;\n" +
                            "}\n" +
                            "}\n" +
                            "\n" +
                            "@media (min-width: 576px){\n" +
                            ".container {\n" +
                            "    max-width: 540px;\n" +
                            "}\n" +
                            ".col-sm-12 {\n" +
                            "    -ms-flex: 0 0 100%;\n" +
                            "    flex: 0 0 100%;\n" +
                            "    max-width: 100%;\n" +
                            "}\n" +
                            ".col-sm-4 {\n" +
                            "    -ms-flex: 0 0 33.333333%;\n" +
                            "    flex: 0 0 33.333333%;\n" +
                            "    max-width: 33.333333%;\n" +
                            "}\n" +
                            ".col-sm-3 {\n" +
                            "    -ms-flex: 0 0 25%;\n" +
                            "    flex: 0 0 25%;\n" +
                            "    max-width: 25%;\n" +
                            "}\n" +
                            ".col-sm-6 {\n" +
                            "    -ms-flex: 0 0 50%;\n" +
                            "    flex: 0 0 50%;\n" +
                            "    max-width: 50%;\n" +
                            "}\n" +
                            "}\n" +
                            "\n" +
                            ".area {\n" +
                            "    position: relative;\n" +
                            "    padding: 100px 0px;\n" +
                            "    text-align: center;\n" +
                            "}\n" +
                            ".row {\n" +
                            "    display: -ms-flexbox;\n" +
                            "    display: flex;\n" +
                            "    -ms-flex-wrap: wrap;\n" +
                            "    flex-wrap: wrap;\n" +
                            "    padding: 15px;\n" +
                            "}\n" +
                            ".text-center {\n" +
                            "    text-align: center!important;\n" +
                            "}\n" +
                            ".col-sm-12, .col-sm-4, .col-sm-3, .col-sm-6{\n" +
                            "    position: relative;\n" +
                            "    width: 100%;\n" +
                            "    padding: 15px;\n" +
                            "}\n" +
                            ".title-sec1 {\n" +
                            "    position: relative;\n" +
                            "    opacity: 0;\n" +
                            "    color: #242f40;\n" +
                            "    transform: translateX(-100px);\n" +
                            "    transition: 1s;\n" +
                            "}\n" +
                            "div {\n" +
                            "    display: block; text-align:center;\n" +
                            "}\n" +
                            ".clearfix {\n" +
                            "    float: none;\n" +
                            "    clear: both;\n" +
                            "}\n" +
                            ".intro-block2 {\n" +
                            "    transform: translateY(0px);\n" +
                            "    opacity: 1;\n" +
                            "    transition: 1s;\n" +
                            "}\n" +
                            ".intro-block {\n" +
                            "    position: relative;\n" +
                            "    text-align: center;\n" +
                            "    margin: 0px 0px 0px;\n" +
                            "    padding: 50px 25px 40px;\n" +
                            "    transform: translateY(150px);\n" +
                            "    opacity: 0;\n" +
                            "    transition: 0.5s ease-in-out;\n" +
                            "}\n" +
                            "table {\n" +
                            "    width: 96%;\n" +
                            "    border: 1px solid black;\n" +
                            "    border-collapse: collapse;\n" +
                            "}\n" +
                            "\n" +
                            "\n" +
                            "thead {\n" +
                            "    display: table-header-group;\n" +
                            "    vertical-align: middle;\n" +
                            "    border-color: inherit;\n" +
                            "    background: #2B7CD3;\n" +
                            "}\n" +
                            "\n" +
                            "tr {\n" +
                            "    display: table-row;\n" +
                            "    vertical-align: inherit;\n" +
                            "    border-color: inherit;\n" +
                            "}\n" +
                            "\n" +
                            "tbody {\n" +
                            "    display: table-row-group;\n" +
                            "    vertical-align: middle;\n" +
                            "    border-color: inherit;\n" +
                            "}\n" +
                            "\n" +
                            "th {\n" +
                            "    padding: 15px;\n" +
                            "}\n" +
                            "\n" +
                            "tr {\n" +
                            "    padding: 15px;\n" +
                            "}\n" +
                            "\n" +
                            "td {\n" +
                            "    border: 1px solid black;\n" +
                            "    padding: 15px;\n"
                            + " border-spacing: 0;" +
                            "\n" +
                            "} tr:nth-child(even){background-color: #f2f2f2}div.col-ms-6,div.col-ms-4,div.col-ms-3,{overflow-x:auto;}"
                            + ".Titulo{background:black;color:White!important}";
                    fn.write(cont);
                    fn.close();

                } catch (Exception e) {
                    System.out.print(e);
                }
            } else {

            }
        } catch (Exception e) {
        }

    }

    public void html() {
        try {
            FileWriter fn = new FileWriter("Reportes/" + n_reporte + ".html", false);
            String cont = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                    "    <title>Reporte</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"Titulo\" row><div class=\"col-sm-12\"><h1>Reporte " + n_reporte + "</h1</div></div>" +
                    "<h1>" +
                    "</div";
            fn.write(cont);
            fn.close();
        } catch (Exception e) {

        }
    }

}