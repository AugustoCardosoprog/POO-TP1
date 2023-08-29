package Ej1;

public class NodoLista {
    private Object dato;
    private NodoLista proximo = null;

    public void setDato(Object dato) {
        this.dato = dato;
    }
    public Object getDato() {
        return dato;
    }
    public void setProximo(NodoLista proximo) {
        this.proximo = proximo;
    }
    public NodoLista getProximo() {
        return proximo;
    }
}

