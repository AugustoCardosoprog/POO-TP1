package Ej8;

import java.security.SecureRandom;

public class Password {
    private String pass;
    private int longitud=8;
    private String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+[]{}|;:<>,.?/~";


    public boolean generar(){
        SecureRandom random = new SecureRandom();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            char caracterAleatorio = caracteres.charAt(indice);
            builder.append(caracterAleatorio);
        }
        pass=builder.toString();
        return true;
    }

    public boolean generar(int tamanio){
        if (tamanio>=8){
            longitud=tamanio;
            return generar();
        }else {
            return false;
        }
    }
    public boolean cambiarLongitud(int tamanio){
        if (tamanio>=8){
            longitud=tamanio;
            return generar();
        }else {
            return false;
        }
    }

    //Hice el pass publico con el fin de probar el funcionamiento del ejercicio. Se que deberia estar oculto
    public String getPass() {
        return pass;
    }

    public boolean esFuerte(){
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (char caracter : pass.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                mayusculas++;
            } else if (Character.isLowerCase(caracter)) {
                minusculas++;
            } else if (Character.isDigit(caracter)) {
                numeros++;
            }
        }
        //"más de 2 mayúsculas, más de 1 minúscula y al menos dos números."
        if ((mayusculas > 2) && (minusculas > 1) && (numeros >= 2)){
            return true;
        }else{
            return false;
        }
    }

    public void hacerFuerte(){
        while (!esFuerte()){
            generar();
        }
    }
}
