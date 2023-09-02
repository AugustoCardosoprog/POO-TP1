package Ej1;

import java.util.Scanner;

public class MainEj1 {
    public static void main(String[] args) {
        System.out.println("***** Lista enlazada Simple *****\n");

        Scanner scanner = new Scanner(System.in);
        int opcion;
        ListaEnlazada lista = null; //

        do {
            printMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Crear lista
                    System.out.println("Seleccionaste la opción 1");
                    lista = new ListaEnlazada();
                    System.out.println("Lista creada.\n");
                    break;
                case 2:
                    // Agregar elemento.
                    System.out.println("Seleccionaste la opción 2");

                    if (lista != null){
                        System.out.println("Ingrese el dato a agregar (numero o texto) :");
                        Scanner scannerDos = new Scanner(System.in);
                        Object dato = leerObjeto(scannerDos);

                        lista.agregar(dato);
                        System.out.println("\""+ dato + "\"" + " agregado.");
                    }else {
                        System.out.println("Primero debes crear la lista.");
                    }
                    break;
                case 3:
                    // Agregar al final
                    System.out.println("Seleccionaste la opción 3");
                    if (lista != null){
                        System.out.println("Ingrese el dato a agregar (numero o texto) :");
                        Scanner scannerDos = new Scanner(System.in);
                        Object dato = leerObjeto(scannerDos);

                        lista.agregar(dato);
                        System.out.println("\""+ dato + "\"" + " agregado al final.");
                    }else {
                        System.out.println("Primero debes crear la lista.");
                    }
                    break;
                case 4:
                    //Es vacia
                    System.out.println("Seleccionaste la opción 4");
                    if (lista != null){
                        if (lista.esVacia()){
                            System.out.println("La lista está vacia.");
                        } else {
                            System.out.println("La lista NO está vacia.");
                        }
                    }else{
                        System.out.println("Primero debes crear la lista.");
                    }

                    break;
                case 5:
                    // Insertar en posicion determinada
                    System.out.println("Seleccionaste la opción 5");
                    if (lista != null){
                        System.out.println("Ingrese el dato a agregar (numero o texto) :");
                        Scanner scannerDos = new Scanner(System.in);
                        Object dato = leerObjeto(scannerDos);

                        System.out.println("Ingrese la posición (numero natural) :");
                        Scanner scannerTres = new Scanner(System.in);
                        int posi = scannerTres.nextInt();

                        lista.insertar(dato,posi);
                        System.out.println("\""+ dato + "\"" + " agregado en la posición :" + "\"" + posi + "\"");
                    }else {
                        System.out.println("Primero debes crear la lista.");
                    }
                    break;
                case 6:
                    //Recuperar elemento
                    System.out.println("Seleccionaste la opción 6");
                    if (lista != null){
                        System.out.println("Ingrese la posicion del dato a recuperar (numero natural): ");
                        Scanner scannerTres = new Scanner(System.in);
                        int posi = scannerTres.nextInt();

                        Object dato = lista.recuperar(posi);
                        if (dato == ""){
                            System.out.println("Vacio");
                        }else {
                            System.out.println(dato);
                        }
                    }else {
                        System.out.println("Primero debes crear la lista.");
                    }
                    break;
                case 7:
                    //Consultar longitud
                    System.out.println("Seleccionaste la opción 7");
                    if (lista != null){
                        System.out.println("La longitud de la lista es: "+lista.longitud());

                    } else{
                        System.out.println("Primero debes crear la lista.\n");
                    }
                    break;
                case 8:
                    //Eliminar dato
                    System.out.println("Seleccionaste la opción 8");
                        if (lista != null){
                            System.out.println("Ingrese el dato a eliminar (numero o texto): ");
                            Scanner scannerDos = new Scanner(System.in);
                            Object dato = leerObjeto(scannerDos);
                            if (lista.eliminarPrimerOcurrencia(dato)){
                                System.out.println("Eliminado.");
                            }else {
                                System.out.println("Error por favor intente de nuevo.");
                            }
                        } else{
                            System.out.println("Primero debes crear la lista.\n");
                        }
                    break;
                case 9:
                    //Mostrar
                    System.out.println("Seleccionaste la opción 9");
                    if (lista != null){
                        System.out.println(lista.mostrar());
                    } else{
                        System.out.println("Primero debes crear la lista.\n");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }  while (opcion!=0);
    }

    public static void printMenu(){
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Crear Lista.");
        System.out.println("2. Agregar elemento.");
        System.out.println("3. Agregar elemento al final de la lista.");
        System.out.println("4. Consultar si la lista está vacía.");
        System.out.println("5. Insertar elemento en la lista en una posición específica.");
        System.out.println("6. Recuperar elemento de la lista.");
        System.out.println("7. Consultar la longitud de la lista.");
        System.out.println("8. Eliminar elemento de la lista (primer ocurrencia).");
        System.out.println("9. Mostrar la lista.");
        System.out.println("0. Salir.");
    }

    public static Object leerObjeto(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            return scanner.nextLine();
        }
    }


}