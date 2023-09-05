package Ej5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class mainEj5 {
    public static void main(String[] args) {
        System.out.println("***** Lista de tareas *****\n");

        int opcion;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarea> listaDeTareas = new ArrayList<>();

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
                    Tarea tarea1 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea1 != null) {
                        System.out.println("Ingrese la descripcion de la tarea (numero o texto) :");
                        Scanner scannerCuatro = new Scanner(System.in);
                        String descripcion2 = scannerCuatro.next();
                        tarea1.setDescripcion(descripcion2);
                        System.out.println("Descripcion cambiada.");
                        System.out.println(tarea1.getDescripcion()+"\n");
                    }
                    break;
                case 3:
                    //Mostrar descripcion
                    mostrar(listaDeTareas);
                    Tarea tarea2 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea2 != null) {
                        System.out.println(tarea2.getDescripcion()+"\n");
                    }
                    break;
                case 4:
                    //Cambiar prioridad
                    mostrar(listaDeTareas);
                    Tarea tarea3 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea3 != null) {
                        System.out.println("Ingrese la nueva prioridad 1. ALTA , 2. MEDIA o 3. BAJA:");
                        Scanner scannerCuatro = new Scanner(System.in);
                        int prio = scannerCuatro.nextInt();
                        tarea3.setPrioridad(prio);
                        System.out.println("Descripcion cambiada.");
                        System.out.println(tarea3.mostrar()+"\n");
                    }
                    break;
                case 5:
                    //Mostrar prioridad
                    mostrar(listaDeTareas);
                    Tarea tarea4 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea4 != null) {
                        System.out.println(tarea4.getPrioridad()+"\n");
                    }
                    break;
                case 6:
                    //Cambiar estado
                    mostrar(listaDeTareas);
                    Tarea tarea5 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea5 != null) {
                            System.out.println("Ingrese 1 para Completa o 2 para Incompleta");
                            Scanner scannerCuatro = new Scanner(System.in);
                            int estado = scannerCuatro.nextInt();
                            if (estado==1){
                                tarea5.setCompleta(true);
                            }else {
                                tarea5.setCompleta(false);
                            }
                            System.out.println("Estado cambiado.");
                            System.out.println(tarea5.mostrar()+"\n");
                        }

                    break;
                case 7:
                    //Mostrar estado
                    mostrar(listaDeTareas);
                    Tarea tarea6 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea6 != null) {
                        System.out.println(tarea6.getCompletaStr()+"\n");
                    }
                    break;
                case 8:
                    //Establecer fecha limite1
                    mostrar(listaDeTareas);
                    Tarea tarea7 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea7 != null) {
                        System.out.print("Ingrese una fecha (en formato AAAA-MM-DD): ");
                        Scanner scannerCuatro = new Scanner(System.in);
                        String fechaComoTexto = scannerCuatro.nextLine();
                        if (fechaComoTexto.matches("\\d{4}-\\d{2}-\\d{2}")){
                            LocalDate fecha = LocalDate.parse(fechaComoTexto);
                            tarea7.setFechaLimite(fecha);
                            System.out.println("Fecha límite establecida.");
                            System.out.println(tarea7. mostrar()+"\n");
                        } else {
                            System.out.println("Formato incorrecto.");
                        }
                    }
                    break;
                case 9:
                    //Mostrar fecha limite
                    mostrar(listaDeTareas);
                    Tarea tarea8 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea8 != null) {
                        System.out.println(tarea8.getFechaStr()+"\n");
                    }
                    break;
                case 10:
                    // Mostrar todo
                    mostrar(listaDeTareas);
                    Tarea tarea9 = selecionarNumeroTarea(listaDeTareas);
                    if (tarea9 != null) {
                        System.out.println(tarea9. mostrar()+"\n");
                    }
                    break;
                case 11:
                    //Mostrar tareas
                    mostrar(listaDeTareas);
                    break;
                case 12:
                    //Crear ejemplos
                    crearEjemplos(listaDeTareas);
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

    public static Tarea selecionarNumeroTarea(ArrayList<Tarea> lista){
        if (!lista.isEmpty()) {
            System.out.println("Seleccione el numero de tarea (numero) :");
            Scanner scannerTres = new Scanner(System.in);
            int numero = scannerTres.nextInt();
            if (!lista.contains(lista.get(numero))) {
                System.out.println("Opcion incorrecta.");
                return null;
            } else {
                return lista.get(numero);
            }
        }
        return null;
    }

    public static void crearEjemplos(ArrayList<Tarea> lista){
        //A "Ir al supermercado mañana". Debe tener la fecha límite establecida y estar incompleta.
        Tarea tareaEA = new Tarea("Ir al supermercado mañana");
        tareaEA.setFechaLimite(LocalDate.of(2038,1,19));
        tareaEA.setCompleta(false);
        lista.add(tareaEA);
        System.out.println(tareaEA.mostrar());

        //B "Consultar repuesto del auto". Debe tener la fecha límite para ayer y estar completa.
        Tarea tareaEB = new Tarea("Consultar repuesto del auto");
        LocalDate fechaActual = LocalDate.now();
        tareaEB.setFechaLimite(fechaActual.minusDays(1));
        tareaEB.setCompleta(true);
        lista.add(tareaEB);
        System.out.println(tareaEB.mostrar());

        //C "Ir al cine a ver la nueva película de Marvel". Debe tener fecha límite de ayer y estar incompleta.
        Tarea tareaEC = new Tarea("Ir al cine a ver la nueva película de Marvel");
        tareaEB.setFechaLimite(fechaActual.minusDays(1));
        tareaEC.setCompleta(false);
        lista.add(tareaEC);
        System.out.println(tareaEC.mostrar());
    }

    public static void printMenu(){
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Crear Tarea");
        System.out.println("2. Cambiar descripcion.");
        System.out.println("3. Mostrar descripcion.");
        System.out.println("4. Establecer prioridad.");
        System.out.println("5. Mostrar prioridad.");
        System.out.println("6. Establecer estado.");
        System.out.println("7. Mostrar si esta completa.");
        System.out.println("8. Establecer fecha limite.");
        System.out.println("9. Mostrar fecha limite.");
        System.out.println("10. Mostrar todo de una tarea.");
        System.out.println("11. Mostrar tareas.");
        System.out.println("12. Cargar ejemplos.");
        System.out.println("0. Salir.");
    }

}
