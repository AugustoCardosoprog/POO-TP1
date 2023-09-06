package E1;

public class ListaEnlazada {
    private NodoLista primero = null;
    private int contador = 0;

    public boolean esVacia(){
        boolean resultado = false;
        if (contador == 0){
            resultado = true;
        }
        return resultado;
    }

    public int longitud(){
        return contador;
    }

    public void agregar(Object dato){
        NodoLista nuevoNodo = new NodoLista();
        nuevoNodo.setDato(dato);
        if (primero == null){
            primero = nuevoNodo;
            contador++;
        } else {
            NodoLista nodoAux = primero;//
            while (nodoAux.getProximo() != null){
                nodoAux = nodoAux.getProximo();
            }
            nodoAux.setProximo(nuevoNodo);
            contador++;
        }
    }

    public String mostrar(){
        String acumulador = "";
        NodoLista nodoActual = primero;
        int i = 0;
        if (contador == 0){
            System.out.println("Lista vacia.");///////////////////////
        } else {
            while (nodoActual != null) {
                acumulador += (" Nodo " + i + ": " + nodoActual.getDato() + "\n");
                i++;
                nodoActual = nodoActual.getProximo();
            }
        }
        return acumulador;
    }


   private void agregarNodoNulo() {
       NodoLista nuevoNodo = new NodoLista();

       if (contador == 0) {
           primero = nuevoNodo;
           contador++;
       } else {
           NodoLista nodoAux = primero;//
           while (nodoAux.getProximo() != null ){
               nodoAux = nodoAux.getProximo();
           }
           nodoAux.setProximo(nuevoNodo);
           contador++;
       }

   }

    public boolean insertar(Object dato, int posicion) {
        if (posicion < 0 ) {
            return false;
        }else if (posicion > contador) {
            while (posicion>contador){
                agregarNodoNulo();
            }
        }
        NodoLista nuevoNodo = new NodoLista();
        nuevoNodo.setDato(dato);

        if (posicion == 0) {
            nuevoNodo.setProximo(primero);
            primero = nuevoNodo;
        } else {
            NodoLista nodoActual = primero;
            for (int i = 0; i < posicion - 1; i++) {
                nodoActual = nodoActual.getProximo();
            }
            nuevoNodo.setProximo(nodoActual.getProximo());
            nodoActual.setProximo(nuevoNodo);
        }

        contador++;
        return true;
    }



    public boolean agregarAlFinal(Object dato){
        boolean resultado = insertar(dato,contador);
        return resultado;
    }

    public boolean eliminarPrimerOcurrencia(Object dato){
        boolean resultado = false;
        NodoLista nodoActual = primero;

        if (nodoActual != null && nodoActual.getDato().equals(dato)) {
            primero = nodoActual.getProximo();
            contador--;
            resultado = true;
        } else {
            //Nos paramos en el nodo anterior al buscado y el siguiente del actual pasa a ser el siguiente del buscado.
            while (nodoActual != null && nodoActual.getProximo() != null) {
                NodoLista proximo = nodoActual.getProximo();
                if (proximo.getDato().equals(dato)) {
                    nodoActual.setProximo(proximo.getProximo());
                    contador--;
                    resultado = true;
                }
                nodoActual = nodoActual.getProximo();
            }
        }
        return resultado;
    }


    public Object recuperar(int posicion) {
        Object resultado = "";
        NodoLista nodoActual = primero;

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
