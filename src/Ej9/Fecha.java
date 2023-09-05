package Ej9;

import jdk.jshell.execution.LoaderDelegate;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fecha {
    private LocalDate fecha;


    public boolean setFechaddMMyyyy(String texto) {
        if (validarFormatoFecha(texto)){
            fecha = LocalDate.parse(texto,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        }else {
            return false;
        }
    }

    public boolean setFechaMMddyyyy(String texto) {
        if (validarFormatoFecha(texto)){
            fecha = LocalDate.parse(texto,DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            return true;
        }else {
            return false;
        }
    }
    public boolean validarFormatoFecha(String textoFecha) {
        String regex = "\\d{2}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textoFecha);
        return matcher.matches();
    }
    public LocalDate getFecha() {
        return fecha;
    }

    public boolean seEncuentraEntre(LocalDate menor, LocalDate mayor){
        if ((esMayorA(menor)&&esMenorA(mayor))||(esMayorA(mayor)&&esMenorA(menor))){
            return true;
        }else {
            return false;
        }
    }
    public boolean esMayorA(LocalDate fecha2){
        if (fecha!=null) {
            if (fecha.isAfter(fecha2)) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean esMenorA(LocalDate fecha2){
        if (fecha!=null) {
            if (fecha.isBefore(fecha2)) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    /*System.out.print("Ingrese una fecha (en formato AAAA-MM-DD): ");
    Scanner scannerCuatro = new Scanner(System.in);
    String fechaComoTexto = scannerCuatro.nextLine();
                        if (fechaComoTexto.matches("\\d{4}-\\d{2}-\\d{2}")){
        LocalDate fecha = LocalDate.parse(fechaComoTexto);
        tarea7.setFechaLimite(fecha);
        System.out.println("Fecha límite establecida.");
        System.out.println(tarea7. mostrar()+"\n");
    } else {
        System.out.println("Formato incorrecto.");
    }*/
}
