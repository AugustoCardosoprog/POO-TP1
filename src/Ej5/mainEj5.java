package Ej5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class mainEj5 {
    public static void main(String[] args) {
        /*Tarea tarea = new Tarea("Hola");
        System.out.println(tarea.getDescripcion());

        tarea.setDescripcion("Hola Mundo");

        tarea.setVencida(true);
        System.out.println(tarea.getDescripcion());

        tarea.setPrioridad(1);
        System.out.println(tarea.getPrioridad());

        tarea.setFechaLimite(LocalDate.of(2026,12,5));
        tarea.comprobarVencida();
        System.out.println(tarea.getVencida());

        System.out.println(tarea.mostrar());

        Tarea tarea2 = new Tarea("Hola");
        System.out.println(tarea2.mostrar());*/

        System.out.println("***** Lista de tareas *****\n");

        int opcion;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarea> listaDeTareas = new ArrayList<Tarea>();

        do {
            printMenu();

        } while (opcion!=0);
    }

    public static void printMenu(){
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Crear Tarea");
        System.out.println("2. Cambiar descripcion.");
        System.out.println("3. Mostrar descripcion.");
        System.out.println("4. Establecer prioridad.");
        System.out.println("5. Mostrar prioridad.");
        System.out.println("6. Establecer estado.");
        System.out.println("7. Mostrar estado.");
        System.out.println("8. Establecer fecha limite.");
        System.out.println("9. Mostrar fecha limite.");
        System.out.println("10. Mostrar si esta completa.");
        System.out.println("11. Mostrar todo de una tarea.");
        System.out.println("12. Mostrar tareas.");
        System.out.println("0. Salir.");
    }

}
