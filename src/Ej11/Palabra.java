package Ej11;

import java.util.ArrayList;

public class Palabra {
    String contenido;
    private int puntaje=0;
    //Diccionario diccionario = new Diccionario();
    private ArrayList<Character> palabrasDoblePuntaje = new ArrayList<Character>() {{
        add('k');
        add('z');
        add('x');
        add('y');
        add('w');
        add('q');
        add('K');
        add('Z');
        add('X');
        add('Y');
        add('W');
        add('Q');
    }};

    public Palabra(String contenido){
        this.contenido = contenido;
        sumarPuntaje();
    }

    public int getPuntaje(){
        return puntaje;
    }
    private void sumarPuntaje(){
        int resultado=0;
        for (char caracter : contenido.toCharArray()) {
            if (palabrasDoblePuntaje.contains(caracter)){
                resultado+=2;
            } else if(Character.isUpperCase(caracter)||Character.isLowerCase(caracter))  {
                resultado++;
            }
        }
        puntaje=resultado;
    }


}
