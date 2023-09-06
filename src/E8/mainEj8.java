package E8;

import java.util.Scanner;

public class mainEj8 {
    public static void main(String[] args) {
        Password contrasenia = new Password();
        if (contrasenia.generar()) {
            System.out.printf("Password de prueba: ");
            printContrasenia(contrasenia);
        }else {
            System.out.println("Error");
        }

        System.out.println("Creando password2... ingrese tamaño (numero entero mayor o igual a 8): ");
        Scanner scanner = new Scanner(System.in);
        int tamanio = scanner.nextInt();

        Password contrasenia2 = new Password();
        if (contrasenia2.generar(tamanio)) {
            System.out.println("Creada correctamente.");
            System.out.printf("password2: ");
            printContrasenia(contrasenia2);
        } else {
            System.out.println("Error");
        }

        System.out.println("Creando password3... ingrese tamaño (numero entero mayor o igual a 8): ");
        Scanner scannerDos = new Scanner(System.in);
        int tamanioDos = scanner.nextInt();

        Password contrasenia3 = new Password();
        if (contrasenia3.generar(tamanioDos)) {
            System.out.println("Creada correctamente.");
            System.out.printf("password3: ");
            printContrasenia(contrasenia3);
        } else {
            System.out.println("Error");
        }

        System.out.println("Intentando hacer password3 fuerte...");
        if (!contrasenia3.esFuerte()) {
            contrasenia3.hacerFuerte();
            System.out.printf("password3: ");
            printContrasenia(contrasenia3);
        }else {
            System.out.println("password2 ya es fuerte.");
        }
    }

    public static void printContrasenia(Password contra){
        if (contra.esFuerte()){
            System.out.println(contra.getPass()+" - Fuerte\n");
        }else {
            System.out.println(contra.getPass()+" - Debil\n");
        }
    }
}
