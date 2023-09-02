package Ej2;

import Ej1.NodoLista;

public class ListaEnlazadaDoble {
    private NodoListaDoble primero = null;
    //private NodoListaDoble ultimo = null;
    private int contador = 0;

    public boolean esVacia() {
        boolean resultado = false;
        if (contador == 0){
            resultado = true;
        }
        return resultado;
    }

    public int longitud(){
        return contador;
    }

    public String mostrar() {
        String acumulador = "";
        NodoListaDoble nodoActual = primero;
        int i = 0;
        if (contador == 0) {
            System.out.println("Lista vacia.");
        } else {
            while (nodoActual != null) {
                acumulador += (" Nodo " + i + ": " + nodoActual.getDato() + "\n");
                i++;
                nodoActual = nodoActual.getProximo();
            }
        }
        return acumulador.toString();
    }

    public void agregar(Object dato){
        NodoListaDoble nuevoNodo = new NodoListaDoble();
        nuevoNodo.setDato(dato);
        if (primero == null){
            primero = nuevoNodo;
            contador++;
        } else {
            NodoListaDoble nodoAux = primero;//
            while (nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(nodoAux);
            contador++;
        }
    }


    public boolean agregarAlFinal(Object dato){
        boolean resultado = insertar(dato,contador);
        return resultado;
    }
    private void agregarNodoNulo() {
        NodoListaDoble nuevoNodo = new NodoListaDoble();

        if (contador == 0) {
            primero = nuevoNodo;
        } else {
            NodoListaDoble nodoAux = primero;//
            while (nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(nodoAux);
        }
        contador++;
    }

    public boolean insertar(Object dato, int posicion) {
        if (posicion < 0 ) {
            return false;
        }else if (posicion > contador) {
            while (posicion>contador){
                agregarNodoNulo();
            }
        }
        NodoListaDoble nuevoNodo = new NodoListaDoble();
        nuevoNodo.setDato(dato);

        if (posicion == 0) {
            nuevoNodo.setProximo(primero);
            primero = nuevoNodo;
        } else {
            NodoListaDoble nodoActual = primero;
            for (int i = 0; i < posicion - 1; i++) {
                nodoActual = nodoActual.getProximo();
            }
            nuevoNodo.setProximo(nodoActual.getProximo());
            nodoActual.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(nodoActual);
        }
        contador++;
        return true;
    }

    public boolean eliminarEnPosicion(int posicion) {
        boolean resultado = false;

        if (posicion >= 0 && posicion <= contador) {
            if (posicion == 0) {
                primero = primero.getProximo();
                if (primero != null) {
                    primero.setAnterior(null);

                }
            } else{
                NodoListaDoble nodoAux = primero;
                for (int i = 0; i < posicion; i++) {
                    nodoAux = nodoAux.getProximo();
                }
                NodoListaDoble anterior = nodoAux.getAnterior();
                NodoListaDoble siguiente = nodoAux.getProximo();
                anterior.setProximo(siguiente);

                if (siguiente != null) {
                    siguiente.setAnterior(anterior);
                }
            }
            resultado=true;
        }
        contador--;
        return resultado;
    }

    public Object recuperar(int posicion) {
        Object resultado = "";
        NodoListaDoble nodoActual = primero;

        if (posicion >= 0 & posicion < contador) {
            if (posicion == 0) {
                resultado = nodoActual.getDato();
            } else {
                for (int i = 0; i < posicion; i++) {
                    nodoActual = nodoActual.getProximo();
                }
                resultado = nodoActual.getDato();
            }
        } else {
            resultado = "Posicion incorrecta.";
        }
        return (resultado);
    }
}
