package Ej4;

import Ej3.NodoPila;

public class Cola {
    private NodoCola primero;
    private NodoCola ultimo;

    public Cola(){
        primero = null;
        ultimo = null;
    }

    public Cola(Object dato){
        NodoCola nuevoNodo = new NodoCola();
        nuevoNodo.setDato(dato);
        primero = nuevoNodo;
        ultimo = nuevoNodo;
    }

    public boolean vacia(){
        if (primero==null){
            return true;
        }
        return false;
    }

    public void encolar(Object dato){
        NodoCola nuevoNodo = new NodoCola();
        nuevoNodo.setDato(dato);
        nuevoNodo.setSiguiente(null);

        if (vacia()){
            primero = nuevoNodo;
        } else{
            ultimo.setSiguiente(nuevoNodo);
        }
        ultimo = nuevoNodo;
    }

    public Object desencolar(){
        if (vacia()) {
           return null;
        }

        NodoCola nodoAux = primero;
        Object dato = nodoAux.getDato();
        primero = nodoAux.getSiguiente();

        if (primero == null) {
            ultimo = null;
        }
        return dato;

    }

}
