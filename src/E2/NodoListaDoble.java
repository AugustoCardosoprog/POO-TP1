package E2;

public class NodoListaDoble {
    private Object dato;
    private NodoListaDoble proximo = null;
    private NodoListaDoble anterior = null;

    public void setDato(Object dato) {
        this.dato = dato;
    }
    public Object getDato() {
        return dato;
    }
    public void setProximo(NodoListaDoble proximo) {
        this.proximo = proximo;
    }
    public NodoListaDoble getProximo() {
        return proximo;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }
}
