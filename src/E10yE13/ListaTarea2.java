package E10yE13;


import java.time.LocalDate;
import java.util.ArrayList;

public class ListaTarea2 {

    private ArrayList<Tarea2> listaDeTareas = new ArrayList<>();
    private ArrayList<Tarea2> noVencidas = new ArrayList<>();
    private ArrayList<Tarea2> tareasOrdenadasPrioridad = new ArrayList<>();
    private ArrayList<Tarea2> tareasOrdenadasFechas = new ArrayList<>();
    private boolean esVacia;

    public boolean agregarTarea(String descripcion){
        Tarea2 nuevaTarea = new Tarea2(descripcion);
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
            Tarea2 tarea = listaDeTareas.get(numero);
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
                Tarea2 tarea = listaDeTareas.get(numero);
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
                Tarea2 tarea = listaDeTareas.get(numero);
                tarea.setCompleta(true);
                return true;
            }else if(opcion==2){
                Tarea2 tarea = listaDeTareas.get(numero);
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

    public boolean obtenerPorVencer(int numero){
        return listaDeTareas.get(numero).porVencer();
    }

    public boolean setFechaRecordatorio(int numero, LocalDate fecha){
        if (contiene(numero)) {
            Tarea2 tarea = listaDeTareas.get(numero);
            tarea.setFechaRecordatorio(fecha);
            return true;
        }else {
            return false;
        }
    }


    public LocalDate obtenerFechaLimite(int numero){
        Tarea2 tarea = listaDeTareas.get(numero);
        if (tarea.getFechaLimite()!=null){
            return tarea.getFechaLimite();
        }else{
            return null;
        }
    }

    public boolean setFechaLimite(int numero, LocalDate fecha){
        if (contiene(numero)) {
            Tarea2 tarea = listaDeTareas.get(numero);
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
        for (Tarea2 tarea : listaDeTareas) {
            if (!tarea.getVencida()){
                noVencidas.add(tarea);
            }
        }
    }

    public ArrayList<Tarea2> getNoVencidas() {
        listaNoVencidas();
        return noVencidas;
    }

    private void listaNoVencidasPorPrioridad(){
        listaNoVencidas();
        tareasOrdenadasPrioridad.removeAll(tareasOrdenadasPrioridad);

        for (Tarea2 tarea : noVencidas) {
            if (tarea.getPrioridadStr() == "ALTA") {
                tareasOrdenadasPrioridad.add(tarea);
            }
        }
        for (Tarea2 tarea : noVencidas) {
            if (tarea.getPrioridadStr() == "MEDIA") {
                tareasOrdenadasPrioridad.add(tarea);
            }
        }
        for (Tarea2 tarea : noVencidas) {
            if (tarea.getPrioridadStr() == "BAJA") {
                tareasOrdenadasPrioridad.add(tarea);
            }
        }
    }

    public ArrayList<Tarea2> getTareasOrdenadasPrioridad() {
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
                Tarea2 aux = tareasOrdenadasFechas.get(i);
                tareasOrdenadasFechas.set(i, tareasOrdenadasFechas.get(imin));
                tareasOrdenadasFechas.set(imin, aux);
            }
        }
    }

    public ArrayList<Tarea2> getTareasOrdenadasFechas() {
        listaNoVencidasPorFecha();
        return tareasOrdenadasFechas;
    }
}
