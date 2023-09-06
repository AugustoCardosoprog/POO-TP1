package E3;

public class Pila {
    private NodoPila tope;
    public Pila(){
        tope = null;
    }
    public Pila(Object dato){ //Construir con dato
        NodoPila nuevoNodo = new NodoPila();
        nuevoNodo.setDato(dato);
        tope = nuevoNodo;
    }
    public boolean vacia(){
        if (tope==null){
            return true;
        }
        return false;
    }

    public void apilar(Object dato){
        NodoPila nuevoNodo = new NodoPila();
        nuevoNodo.setDato(dato);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public Object desapilar(){
        if (vacia()){
            return null;
        }else {
        NodoPila topeActual = tope;
        Object dato = topeActual.getDato();
        tope = topeActual.getSiguiente();
        return dato;
        }
    }

    public Object tope(){
        return tope.getDato();
    }

}
