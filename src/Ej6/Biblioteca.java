package Ej6;

import java.util.ArrayList;
import java.util.Objects;

public class Biblioteca {
    private int cantTotalPrestamos=0;
    private ArrayList<Libro> listaDeLibros = new ArrayList<>();

    public Libro agregarLibro(String titulo,String autor){
        Libro libroNuevo = new Libro(titulo,autor);
        listaDeLibros.add(libroNuevo);
        return libroNuevo;
    }

    public void agregarEjemplar(Libro libro,int cantidad){
        libro.agreagarEjemplares(cantidad);
    }

    public Libro buscarPorTituloYAutor(String titulo,String autor){
        for (Libro libro: listaDeLibros) {
            if ((Objects.equals(titulo,libro.getTitulo()))&&(Objects.equals(autor,libro.getAutor()))){
                return libro;
            }else {
                return null;
            }
        }
        return null;
    }
    public ArrayList<Libro> arrayBuscarPorTitulo(String titulo){ //Obtener lista de Libros que coinciden con un titulo
        ArrayList<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : listaDeLibros) {
            if (Objects.equals(titulo, libro.getTitulo())) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }
    public ArrayList<String> obtenerAutores(ArrayList<Libro> libros) { //Obtener lista de autores que coinciden con un titulo
        ArrayList<String> autores = new ArrayList<>();
        for (Libro libro : libros) {
            autores.add(libro.getAutor());
        }
        return autores;
    }

    public ArrayList<Libro> getListaDeLibros(){
        ArrayList<Libro> copia = listaDeLibros;
        return copia;
    }
    public String mostrarLibro(Libro libro){
        String acumulador = ("El libro: " + libro.getTitulo() + ", creado por el autor: " +libro.getAutor() + ", tiene " + libro.getPaginas() + " páginas, quedan: " + libro.getCantEjemplares() + " disponibles y se prestaron: " + libro.getCantEjemplaresPrestados() + ".");
        return acumulador;
    }
    public int getCantTotalPrestamos(){
        return cantTotalPrestamos;
    }

    public boolean prestar(Libro libro, int cantidadP){
        if (libro.prestar(cantidadP)){
            cantTotalPrestamos =  cantTotalPrestamos+cantidadP;
            return true;
        } else {
            return  false;
        }
    }
}
