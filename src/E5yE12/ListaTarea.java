package E5yE12;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaTarea {

    private ArrayList<Tarea> listaDeTareas = new ArrayList<>();
    private ArrayList<Tarea> noVencidas = new ArrayList<>();
    private ArrayList<Tarea> tareasOrdenadasPrioridad = new ArrayList<>();
    private ArrayList<Tarea> tareasOrdenadasFechas = new ArrayList<>();
    private boolean esVacia;

    public boolean agregarTarea(String descripcion){
        Tarea nuevaTarea = new Tarea(descripcion);
        if (listaDeTareas.add(nuevaTarea)){
            return true;
        }else {
            return false;
        }

    }
    public String obtenerDescripcion(int numero){
        return listaDeTareas.get(numero).getDescripcion();
    }
    public boolean setDescripcion(String descripcion,int numero){
        if (contiene(numero)){
            Tarea tarea=listaDeTareas.get(numero);
            tarea.setDescripcion(descripcion);
            return true;
        }else {
            return false;
        }
    }
    public String obtenerPrioridad(int numero){
        return listaDeTareas.get(numero).getPrioridadStr();
    }

    public boolean setPrioridad(int numero,int prioridad){
        if (prioridad > 0 && prioridad < 4) {
            if (contiene(numero)){
                Tarea tarea=listaDeTareas.get(numero);
                tarea.setPrioridad(prioridad);
                return true;
            }
        }
        return false;
    }
    public boolean obtenerCompleta(int numero){
        return listaDeTareas.get(numero).getCompleta();
    }
    public boolean setCompleta(int numero,int opcion){
        if (contiene(numero)) {
            if (opcion==1){
                Tarea tarea=listaDeTareas.get(numero);
                tarea.setCompleta(true);
                return true;
            }else if(opcion==2){
                Tarea tarea=listaDeTareas.get(numero);
                tarea.setCompleta(false);
                return true;
            }else {
                return false;
            }
        }
        return false;

    }

    public boolean obtenerVencida(int numero){
        return listaDeTareas.get(numero).getVencida();
    }

    public LocalDate obtenerFechaLimite(int numero){
        Tarea tarea = listaDeTareas.get(numero);
        if (tarea.getFechaLimite()!=null){
            return tarea.getFechaLimite();
        }else{
            return null;
        }
    }

    public boolean setFechaLimite(int numero, LocalDate fecha){
        if (contiene(numero)) {
            Tarea tarea = listaDeTareas.get(numero);
            tarea.setFechaLimite(fecha);
            return true;
        }else {
            return false;
        }
    }

    public boolean esVacia(){
        return listaDeTareas.isEmpty();
    }

    public boolean contiene(int numero){
        if (numero >= -1 && numero < listaDeTareas.size()) {
            return listaDeTareas.contains(listaDeTareas.get(numero));
        }else {
            return false;
        }
    }



    public void listaNoVencidas(){
        noVencidas.removeAll(noVencidas);
        for (Tarea tarea : listaDeTareas) {
            if (!tarea.getVencida()){
                noVencidas.add(tarea);
            }
        }
    }

    public ArrayList<Tarea> getNoVencidas() {
        listaNoVencidas();
        return noVencidas;
    }

    private void listaNoVencidasPorPrioridad(){
        listaNoVencidas();
        tareasOrdenadasPrioridad.removeAll(tareasOrdenadasPrioridad);

        for (Tarea tarea : noVencidas) {
            if (tarea.getPrioridadStr() == "ALTA") {
                tareasOrdenadasPrioridad.add(tarea);
            }
        }
        for (Tarea tarea : noVencidas) {
            if (tarea.getPrioridadStr() == "MEDIA") {
                tareasOrdenadasPrioridad.add(tarea);
            }
        }
        for (Tarea tarea : noVencidas) {
            if (tarea.getPrioridadStr() == "BAJA") {
                tareasOrdenadasPrioridad.add(tarea);
            }
        }
    }

    public ArrayList<Tarea> getTareasOrdenadasPrioridad() {
        listaNoVencidasPorPrioridad();
        return tareasOrdenadasPrioridad;
    }
    public void listaNoVencidasPorFecha(){
        listaNoVencidas();
        //tareasOrdenadasFechas.removeAll(tareasOrdenadasFechas);

        tareasOrdenadasFechas=noVencidas;
        int n = tareasOrdenadasFechas.size();

        for (int i = 0; i < n - 1; i++) {
            int imin = i;

            for (int j = i + 1; j < n; j++) {
                LocalDate fecha1 = noVencidas.get(j).getFechaLimite();
                LocalDate fecha2 = noVencidas.get(imin).getFechaLimite();

                if (fecha1 != null) {
                    if (fecha1.isBefore(fecha2)) {
                        imin = j;
                    }
                }
            }
            if (imin != i) {
                Tarea aux = tareasOrdenadasFechas.get(i);
                tareasOrdenadasFechas.set(i, tareasOrdenadasFechas.get(imin));
                tareasOrdenadasFechas.set(imin, aux);
            }
        }
    }

    public ArrayList<Tarea> getTareasOrdenadasFechas() {
        listaNoVencidasPorFecha();
        return tareasOrdenadasFechas;
    }
}
