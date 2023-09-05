package Ej11;

import java.util.ArrayList;

public class Diccionario {
    private ArrayList<String> palabras = new ArrayList<String>() {{
        add("Hola");//Palabras por defecto
        add("Mundo");
        add("Java");
        add("Kiwi");
        add("Zapato");
        add("Whisky");
        add("Yaguar");
        add("Excelente");
    }};

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public boolean agregarPalabra(String palabra){
        if(palabras.add(palabra)){
            return true;
        }
        else {
            return false;
        }
    }

}
