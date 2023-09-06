package E11;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Palabra> listaDePalabras = new ArrayList<>();
    private int puntajeTotal;
    //Todos los jugadores comparten el mismo diccionario y pueden agregarle palabras
    private static Diccionario diccionario = new Diccionario();


    public boolean formarPalabra(String contenido){
        if (diccionario.getPalabras().contains(contenido)){
            Palabra nuevaPalabra = new Palabra(contenido);
            listaDePalabras.add(nuevaPalabra);
            puntajeTotal += nuevaPalabra.getPuntaje();
            return true;
        }else {
            return false;
        }
    }
    public boolean agregarPalabraADiccionario(String palabra){
        if(diccionario.agregarPalabra(palabra)){
            return true;
        }else {
            return false;
        }
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }
}
