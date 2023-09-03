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
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    //Crear tarea
                    System.out.println("Ingrese la descripcion de la tarea (numero o texto) :");
                    Scanner scannerDos = new Scanner(System.in);
                    String descripcion = scannerDos.next();
                    Tarea tarea = new Tarea(descripcion);
                    listaDeTareas.add(tarea);
                    System.out.println("Tarea creada.");
                    System.out.println(tarea.getDescripcion()+"\n");
                break;
                case 2:
                    //Cambiar descripcion
                    mostrar(listaDeTareas);
                    if (!listaDeTareas.isEmpty()) {
                        System.out.println("Seleccione el numero de tarea (numero) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int numero = scannerTres.nextInt();
                        if (!listaDeTareas.contains(listaDeTareas.get(numero))){
                            System.out.println("Opcion incorrecta.");
                        }else {
                            Tarea tarea2 = listaDeTareas.get(numero);
                            System.out.println("Ingrese la descripcion de la tarea (numero o texto) :");
                            Scanner scannerCuatro = new Scanner(System.in);
                            String descripcion2 = scannerCuatro.next();
                            tarea2.setDescripcion(descripcion2);
                            System.out.println("Descripcion cambiada.");
                            System.out.println(tarea2.getDescripcion()+"\n");
                        }
                    }
                    break;
                case 3:
                    mostrar(listaDeTareas);
                    if (!listaDeTareas.isEmpty()) {
                        System.out.println("Seleccione el numero de tarea (numero) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int numero = scannerTres.nextInt();
                        if (!listaDeTareas.contains(listaDeTareas.get(numero))){
                            System.out.println("Opcion incorrecta.");
                        }else {
                            Tarea tarea2 = listaDeTareas.get(numero);
                            System.out.println(tarea2.getDescripcion()+"\n");
                        }
                    }
                    break;
                case 4:
                    //Cambiar prioridad
                    mostrar(listaDeTareas);
                    if (!listaDeTareas.isEmpty()) {
                        System.out.println("Seleccione el numero de tarea (numero) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int numero = scannerTres.nextInt();
                        if (!listaDeTareas.contains(listaDeTareas.get(numero))){
                            System.out.println("Opcion incorrecta.");
                        }else {
                            Tarea tarea2 = listaDeTareas.get(numero);
                            System.out.println("Ingrese la nueva prioridad 1. ALTA , 2. MEDIA o 3. BAJA:");
                            Scanner scannerCuatro = new Scanner(System.in);
                            int prio = scannerCuatro.nextInt();
                            tarea2.setPrioridad(prio);
                            System.out.println("Descripcion cambiada.");
                            System.out.println(tarea2.mostrar()+"\n");
                        }
                    }
                    break;
                case 5:
                    //Mostrar prioridad
                    mostrar(listaDeTareas);
                    if (!listaDeTareas.isEmpty()) {
                        System.out.println("Seleccione el numero de tarea (numero) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int numero = scannerTres.nextInt();
                        if (!listaDeTareas.contains(listaDeTareas.get(numero))){
                            System.out.println("Opcion incorrecta.");
                        }else {
                            Tarea tarea2 = listaDeTareas.get(numero);
                            System.out.println(tarea2.getPrioridad()+"\n");
                        }
                    }
                    break;
                case 6:
                    //Cambiar estado
                    mostrar(listaDeTareas);
                    if (!listaDeTareas.isEmpty()) {
                        System.out.println("Seleccione el numero de tarea (numero) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int numero = scannerTres.nextInt();
                        if (!listaDeTareas.contains(listaDeTareas.get(numero))){
                            System.out.println("Opcion incorrecta.");
                        }else {
                            Tarea tarea2 = listaDeTareas.get(numero);
                            System.out.println("Ingrse 1 para Completa o 2 para Incompleta");
                            Scanner scannerCuatro = new Scanner(System.in);
                            int estado = scannerCuatro.nextInt();
                            if (estado==1){
                                tarea2.setCompleta(true);
                            }else {
                                tarea2.setCompleta(false);
                            }
                            System.out.println("Estado cambiado.");
                            System.out.println(tarea2.mostrar()+"\n");
                        }
                    }
                    break;
                case 7:
                    //Mostrar estado
                    mostrar(listaDeTareas);
                    if (!listaDeTareas.isEmpty()) {
                        System.out.println("Seleccione el numero de tarea (numero) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int numero = scannerTres.nextInt();
                        if (!listaDeTareas.contains(listaDeTareas.get(numero))){
                            System.out.println("Opcion incorrecta.");
                        }else {
                            Tarea tarea2 = listaDeTareas.get(numero);
                            System.out.println(tarea2.getCompletaStr()+"\n");
                        }
                    }
                    break;
                case 8:
                    //Establecer fecha limite

                    break;
                case 9:
                    //Mostrar fecha limite
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    mostrar(listaDeTareas);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion!=0);
    }

    public static void mostrar(ArrayList<Tarea> lista){
        int i=-1;
        if (!lista.isEmpty()){
            for (Tarea elemento: lista) {
                i++;
                System.out.println(i+". "+elemento.getDescripcion());
            }
        } else {
            System.out.println("No hay tareas.\n");
        }
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
