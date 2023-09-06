package E6;

public class Libro {
    private String titulo;
    private String autor;
    private String paginas;
    private String ISBN;
    private int anio;
    private int cantEjemplares;
    private int cantEjemplaresPrestados;


    public Libro(String titulo,String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getPaginas() {
        if (paginas==null){
            return "<No cargadas>";
        }else {
            return paginas;
        }
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public int getCantEjemplaresPrestados() {
        return cantEjemplaresPrestados;
    }

    public void agreagarEjemplares(int cantidad){
        cantEjemplares += cantidad;
    }

    public boolean prestar(int cantidad){
        if (cantidad<cantEjemplares&&cantEjemplares>1){
            for (int i = 0; i<cantidad; i++) {
                cantEjemplares--;
                cantEjemplaresPrestados++;
            }
            return true;
        }else {
            return false;
        }
    }

    public boolean devolver(int cantidad){
        if (cantEjemplaresPrestados>1){
            cantEjemplaresPrestados--;
            cantEjemplares++;
            return true;
        }else {
            return false;
        }
    }


}
