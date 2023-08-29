package Ej1;

public class ListaEnlazada {
    private NodoLista primero = null;


    public void agregar(Object dato){
        NodoLista nuevoNodo = new NodoLista();
        nuevoNodo.setDato(dato);
        if (primero == null){
            primero = nuevoNodo;
        } else {
            NodoLista nodoAux = primero;
            while (nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
        }
    }

    public String mostrar(){
        String acumulador = "";
        NodoLista nodoAux = primero;
        int i = 0;
        if (primero == null) {
            acumulador = "Lista vacia";
        } else {
            while (nodoAux != null) {
                acumulador += (" Nodo " + i + ": "+ nodoAux.getDato() + "\n");
                i++;
                nodoAux = nodoAux.getProximo();
            }
        }
        return acumulador;
    }

}
