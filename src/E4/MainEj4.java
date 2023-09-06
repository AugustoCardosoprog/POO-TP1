package E4;

//import Ej3.Pila;

public class MainEj4 {
    public static void main(String[] args) {

        Cola c = new Cola("A");
        c.encolar("B");
        c.encolar("c");
        c.encolar("1");

        mostrarCola(c);

        if (c.vacia()) {
            System.out.println("Cola vacia.");
        } else {
            System.out.println("Cola no vacia.");
        }

        System.out.println(c.desencolar());
        mostrarCola(c);
    }



    public static void mostrarCola(Cola cola){
        if (cola.vacia()) {
            System.out.println("Pila vacia.");
            return;
        }

        Cola colaAux = new Cola();
        int i=-1;

        while (!cola.vacia()){
            Object dato = cola.desencolar();
            i++;
            System.out.println("Nodo "+i+": "+"\""+dato+"\"");
            colaAux.encolar(dato);
        }

        while (!colaAux.vacia()){
            Object dato = colaAux.desencolar();
            cola.encolar(dato);
        }

    }
}
