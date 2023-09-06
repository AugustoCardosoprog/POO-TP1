package E5yE12;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;
    private boolean completa;
    private boolean vencida;
    private LocalDate fechaLimite;

    private enum Prioridad {
        ALTA, MEDIA, BAJA
    }

    public Tarea(String descripcion){
        this.descripcion = descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
    public boolean getCompleta(){
        return completa;
    }
    public boolean comprobarVencida(){
        boolean resp=false;
        LocalDate fechaActual = LocalDate.now();
        if (fechaLimite!=null) {
            if (!completa && fechaActual.isAfter(fechaLimite)){
                vencida = true;
                resp = true;
            } else {
                vencida = false;
                resp = false;
            }
        }
        return false;
    }
    public LocalDate getFechaLimite() {
        comprobarVencida();
        return fechaLimite;
    }
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
        comprobarVencida();
    }
    public void setVencida(boolean vencida) {
        this.vencida = vencida;
    }
    public boolean getVencida(){
        comprobarVencida();
        return vencida;
    }

    /**
     * Insertar 1 para ALTA, 2 para MEDIA o 3 para BAJA
     * @ setPrioridad
     */
    public void setPrioridad(int opcion) {
        if (opcion==1){
            prioridad = Tarea.Prioridad.ALTA;
        } else if (opcion==2){
            prioridad = Tarea.Prioridad.MEDIA;
        } else {
            prioridad = Tarea.Prioridad.BAJA;
        }
    }

    public String getPrioridadStr() {
        if (prioridad == Tarea.Prioridad.ALTA){
            return "ALTA";
        }else if (prioridad == Tarea.Prioridad.MEDIA){
            return "MEDIA";
        }else {
            return "BAJA";
        }
    }
}
