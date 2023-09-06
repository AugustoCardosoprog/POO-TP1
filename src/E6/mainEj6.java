package E6;

import java.util.ArrayList;
import java.util.Scanner;

public class mainEj6 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro dracula = biblioteca.agregarLibro("Dracula","Bram Stoker");
        dracula.setISBN("0721408125");
        dracula.setAnio(1897);
        dracula.setPaginas("470");

        Libro hieloyfuego = biblioteca.agregarLibro("Cancion de Hielo y Fuego II","George R.R. Martin");
        hieloyfuego.setISBN("9506442320");
        hieloyfuego.setAnio(2012);
        hieloyfuego.setPaginas("928");
        hieloyfuego.setCantEjemplares(10);

        mostrarLibros(biblioteca);

        prestar(biblioteca,dracula,3);
        prestar(biblioteca,hieloyfuego,5);

        mostrarLibros(biblioteca);

        int cantidadPrestados = biblioteca.getCantTotalPrestamos();
        System.out.println(cantidadPrestados+" prestamos realizados en total.");

    }

    public static void prestar(Biblioteca biblio,Libro libro, int cantidad){
        if(!biblio.prestar(libro,cantidad)){
            System.out.println("No se pueden prestar "+cantidad+" ejemplares de "+libro.getTitulo()+".");
        }else {
            System.out.println("Se prestaron "+cantidad+" ejemplares de "+libro.getTitulo()+".");
        }
    }
    public static void mostrarLibros(Biblioteca biblio){
        ArrayList<Libro> libros = biblio.getListaDeLibros();
        for (Libro libro : libros){
            System.out.println(biblio.mostrarLibro(libro));
        }
    }
    public static Libro buscarPorTitulo(Biblioteca biblio,String titulo){
        ArrayList<Libro> porTitulo = new ArrayList<>();
        porTitulo = biblio.arrayBuscarPorTitulo(titulo);
        ArrayList<String> autores = biblio.obtenerAutores(porTitulo);
        int i=-1;
        for (String autor: autores) {
            i++;
            System.out.println(i+". "+autor);
        }
        System.out.println("Elija un numero de autor: ");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        if (!autores.contains(autores.get(numero))) {
            System.out.println("Opcion incorrecta.");
            return null;
        } else {
            String autor = autores.get(numero);
            Libro encontrado = new Libro("a","a");
            encontrado = biblio.buscarPorTituloYAutor(titulo,autor);
            return encontrado;
        }
    }
}
