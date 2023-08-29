import Ej1.ListaEnlazada;

public class main {
    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar("Hola");
        lista.agregar("Mundo!");

        System.out.println(lista.mostrar());
    }
}