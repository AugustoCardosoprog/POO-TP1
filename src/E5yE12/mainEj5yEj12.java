package E5yE12;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class mainEj5yEj12 {
    public static void main(String[] args) {
       /* ListaTarea nuevalista = new ListaTarea();

        int numero = selecionarNumeroTarea(nuevalista);
        mostrar(nuevalista,numero);

        nuevalista.agregarTarea("hola");
        nuevalista.agregarTarea("hola12");
        mostrarTodas(nuevalista);
    */
    int opcion;
    Scanner scanner = new Scanner(System.in);
    ListaTarea listaDeTareas = new ListaTarea();


    do{
        printMenu();
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                //Crear tarea
                System.out.println("Ingrese la descripcion de la tarea (numero o texto) :");
                Scanner scannerDos = new Scanner(System.in);
                String descripcion = scannerDos.next();
                listaDeTareas.agregarTarea(descripcion);
                System.out.println("Tarea creada.");
                mostrarTodas(listaDeTareas);
                break;
            case 2:
                //Cambiar descripcion
                int numero = selecionarNumeroTarea(listaDeTareas);
                if (numero!=-1) {
                    System.out.println("Ingrese la descripcion de la tarea (numero o texto) :");
                    Scanner scannerTres = new Scanner(System.in);
                    String descripcionCambiar = scannerTres.next();
                    if (listaDeTareas.setDescripcion(descripcionCambiar, numero)) {
                        System.out.println("Descripcion cambiada.");
                        mostrarTodo(listaDeTareas,numero);
                    }else {
                        System.out.println("Error.");
                    }
                }
                //}
                break;
            case 3:
                //Establecer prioridad
                int numero3 = selecionarNumeroTarea(listaDeTareas);
                if (numero3 != -1) {
                    System.out.println("Ingrese el numero de prioridad 1. ALTA, 2. MEDIA, 3. BAJA:");
                    Scanner scannerTres = new Scanner(System.in);
                    int numeroPrioridad = scannerTres.nextInt();
                    if(listaDeTareas.setPrioridad(numero3,numeroPrioridad)){
                        System.out.println("Prioridad establecida.");
                        mostrarTodo(listaDeTareas,numero3);
                    }else {
                        System.out.println("Error.");
                    }
                }
                break;
            case 4:
                //Establecer completa
                int numero2 = selecionarNumeroTarea(listaDeTareas);
                if (numero2!=-1) {
                    System.out.println("Ingrese 1. para Completa 2. para Incompleta. :");
                    Scanner scannerTres = new Scanner(System.in);
                    int eleccion = scannerTres.nextInt();
                    if (listaDeTareas.setCompleta(numero2,eleccion)) {
                        mostrarTodo(listaDeTareas,numero2);
                    }else {
                        System.out.println("Error.");
                    }
                }else {
                    System.out.println("Error.");
                }
                break;
            case 5:
                //Establecer fecha limite
                int numero4 = selecionarNumeroTarea(listaDeTareas);
                if (numero4!=-1) {
                    System.out.print("Ingrese una fecha (en formato AAAA-MM-DD): ");
                    Scanner scannerCuatro = new Scanner(System.in);
                    String fechaComoTexto = scannerCuatro.nextLine();
                    if (fechaComoTexto.matches("\\d{4}-\\d{2}-\\d{2}")){
                        LocalDate fecha = LocalDate.parse(fechaComoTexto);
                        listaDeTareas.setFechaLimite(numero4,fecha);
                        System.out.println("Fecha límite establecida.");
                        mostrarTodo(listaDeTareas,numero4);
                    }else {
                        System.out.println("Formato incorrecto.");
                    }
                }
            case 6:
                //mostrar una tarea
                int numero5 = selecionarNumeroTarea(listaDeTareas);
                if (numero5!=-1) {
                    mostrarTodo(listaDeTareas,numero5);
                }
                break;
            case 7:
                //mostrar todas
                mostrarTodasTodo(listaDeTareas);
                break;
            case 8:
                // ejemplos
                cargarEjemplos(listaDeTareas);
                break;
            case 9:
                //Mostrar no vencidas ordenadas por prioridad
                mostrarArrayList(listaDeTareas.getTareasOrdenadasPrioridad());
                break;
            case 10:
                //Mostrar no vencidas ordenadas por fecha de vencimieto
                mostrarArrayList(listaDeTareas.getTareasOrdenadasFechas());
                break;
        }
    }while(opcion!=0);
    }


    public static String mostrar(ListaTarea listaTarea,int numero) {
        String acumulador;
        if (!listaTarea.esVacia()) {
            if (listaTarea.obtenerVencida(numero)){
                acumulador = (numero+" "+listaTarea.obtenerDescripcion(numero)+" (Vencida)");
            } else {
                acumulador = (numero+" "+listaTarea.obtenerDescripcion(numero)+" (No vencida)");
            }
        } else {
            acumulador = "Lista vacia.";
        }
        return acumulador;
    }

    public static void mostrarArrayList(ArrayList<Tarea> list){
        int i=-1;
        if (!list.isEmpty()){
            for (Tarea elemento: list) {
                i++;
                System.out.println(i+" "+elemento.getDescripcion()+" Prioridad "+ elemento.getPrioridadStr()+" Fecha limite "+elemento.getFechaLimite());
            }
        } else {
            System.out.println("No hay tareas.\n");
        }
    }
    public static String strCompleta(ListaTarea listaTarea,int numero){
        String acumulador;
        if (!listaTarea.esVacia()) {
            if (listaTarea.obtenerCompleta(numero)){
                acumulador = ("Completa");
            } else {
                acumulador = ("No completa.");
            }
        } else {
            acumulador = "Lista vacia.";
        }
        return acumulador;
    }

    public static String strFechaLimite(ListaTarea listaTarea,int numero){
        String acumulador;
        if (!listaTarea.esVacia()) {
            if (listaTarea.obtenerFechaLimite(numero)!=null){
                acumulador = listaTarea.obtenerFechaLimite(numero).toString();
            }else {
                acumulador = "Sin fecha limite.";
            }
        } else {
            acumulador = "Lista vacia.";
        }
        return acumulador;
    }

    public static String mostrarTodo(ListaTarea listaTarea,int numero) {
        String acumulador;
        if (!listaTarea.esVacia()) {
            acumulador = (mostrar(listaTarea,numero)+ ". Prioridad " + listaTarea.obtenerPrioridad(numero) + ", Estado de " + strCompleta(listaTarea, numero) + ", Fecha límite " + strFechaLimite(listaTarea, numero)+ ".");
        } else {
            acumulador = "Lista vacia.";
        }
        return acumulador;
    }


    public static void mostrarTodas(ListaTarea listaTareas){
        int i=0;

        if (!listaTareas.esVacia()) {
            while (listaTareas.contiene(i)){
                System.out.println(mostrar(listaTareas,i));
                i++;
            }
        } else {
            System.out.println("Lista vacia.");
        }

    }
    public static void mostrarTodasTodo(ListaTarea listaTareas){
        int i=0;

        if (!listaTareas.esVacia()) {
            while (listaTareas.contiene(i)){
                System.out.println(mostrarTodo(listaTareas,i));
                i++;
            }
        } else {
            System.out.println("Lista vacia.");
        }

    }
    public static int selecionarNumeroTarea(ListaTarea listaTareas){
        mostrarTodas(listaTareas);
        if (!listaTareas.esVacia()) {
            System.out.println("Seleccione el numero de tarea (numero) :");
            Scanner scannerTres = new Scanner(System.in);
            int numero = scannerTres.nextInt();
            if (!listaTareas.contiene(numero)) {
                System.out.println("Opcion incorrecta.");
                return -1;
            } else {
                return numero;
            }
        }
        return -1;
    }


    public static void cargarEjemplos(ListaTarea listaTareas){
        //A "Ir al supermercado mañana". Debe tener la fecha límite establecida y estar incompleta.
        listaTareas.agregarTarea("Ir al supermercado mañana");
        listaTareas.setFechaLimite(0,LocalDate.of(2038,1,19));
        listaTareas.setCompleta(0,2);
        System.out.println(mostrarTodo(listaTareas,0));

        //B "Consultar repuesto del auto". Debe tener la fecha límite para ayer y estar completa.
        listaTareas.agregarTarea("Consultar repuesto del auto");
        LocalDate fechaActual = LocalDate.now();
        listaTareas.setFechaLimite(1,fechaActual.minusDays(1));
        listaTareas.setCompleta(1,1);
        System.out.println(mostrarTodo(listaTareas,1));

        //C "Ir al cine a ver la nueva película de Marvel". Debe tener fecha límite de ayer y estar incompleta.
        listaTareas.agregarTarea("Ir al cine a ver la nueva película de Marvel");
        listaTareas.setFechaLimite(2,fechaActual.minusDays(1));
        listaTareas.setCompleta(2,2);
        System.out.println(mostrarTodo(listaTareas,2));

        //
        listaTareas.agregarTarea("Limpiar el garaje ");
        listaTareas.setFechaLimite(3,LocalDate.of(2024,01,12));
        listaTareas.setCompleta(3,2);
        System.out.println(mostrarTodo(listaTareas,3));

        //
        listaTareas.agregarTarea("Responder correos electrónicos pendientes");
        listaTareas.setFechaLimite(4,fechaActual);
        listaTareas.setCompleta(4,1);
        System.out.println(mostrarTodo(listaTareas,4));

        //
        listaTareas.agregarTarea("Completar informe");
        listaTareas.setFechaLimite(5,fechaActual.minusDays(1));
        listaTareas.setCompleta(5,2);
        System.out.println(mostrarTodo(listaTareas,5));
    }

    public static void printMenu(){
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Crear Tarea");
        System.out.println("2. Cambiar descripcion.");
        System.out.println("3. Establecer prioridad.");
        System.out.println("4. Establecer estado.");
        System.out.println("5. Establecer fecha limite.");
        System.out.println("6. Mostrar una tarea.");
        System.out.println("7. Mostrar tareas.");
        System.out.println("8. Cargar ejemplos del ejercicio .");
        System.out.println("9. Mostrar no vencidas ordenadas por prioridad.");
        System.out.println("10. Mostrar no vencidas ordenadas por fecha de vencimiento.");
        System.out.println("0. Salir.");
    }
}
