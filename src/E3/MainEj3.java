package E3;

public class MainEj3 {
    public static void main(String[] args) {
        //Pila p = new Pila();
        Pila p = new Pila("A");
        p.apilar("B");
        p.apilar("c");
        p.apilar("1");

        mostrarPila(p);

        if (p.vacia()) {
            System.out.println("Pila vacia.");
        }else {
            System.out.println("Pila no vacia.");
        }

        System.out.println(p.desapilar());
        mostrarPila(p);
    }



    public static void mostrarPila(Pila pila){
        if (pila.vacia()) {
            System.out.println("Pila vacia.");
            return;
        }

        Pila pilaAux = new Pila();
        int i=-1;

        while (!pila.vacia()){
            Object dato = pila.desapilar();
            i++;
            System.out.println("Nodo "+i+": "+"\""+dato+"\"");
            pilaAux.apilar(dato);
        }

        while (!pilaAux.vacia()){
            Object dato = pilaAux.desapilar();
            pila.apilar(dato);
        }

    }

}
