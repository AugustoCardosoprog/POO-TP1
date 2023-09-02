package Ej3;

public class NodoPila {
    private NodoPila siguiente = null;
    private Object dato;

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }
    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }
}
