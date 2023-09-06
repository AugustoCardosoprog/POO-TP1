package E4;

public class NodoCola {
    private NodoCola siguiente = null;
    private Object dato;

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }
}






