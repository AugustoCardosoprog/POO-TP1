package E10yE13;

import java.time.LocalDate;

public class Tarea2 {
    private String descripcion;
    private Prioridad prioridad;
    private boolean completa;
    private boolean vencida;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;
    private boolean porVencer;

    private enum Prioridad {
        ALTA, MEDIA, BAJA
    }

    public Tarea2(String descripcion){
        this.descripcion = descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        vence();
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

    public void vence(){
        if (fechaRecordatorio!=null){
            LocalDate fechaActual = LocalDate.now();
            if (fechaActual.isAfter(fechaRecordatorio)||fechaActual.equals(fechaRecordatorio)){
                prioridad = Prioridad.ALTA;
            }
        }
    }

    public boolean porVencer(){
        vence();
        LocalDate fechaActual = LocalDate.now();
        if (fechaRecordatorio!=null) {
            if (fechaRecordatorio.isAfter(fechaActual) || fechaActual.equals(fechaRecordatorio)) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public void setFechaRecordatorio(LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;

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
            prioridad = Tarea2.Prioridad.ALTA;
        } else if (opcion==2){
            prioridad = Tarea2.Prioridad.MEDIA;
        } else {
            prioridad = Tarea2.Prioridad.BAJA;
        }
        vence();
    }

    public String getPrioridadStr() {
        if (prioridad == Tarea2.Prioridad.ALTA){
            return "ALTA";
        }else if (prioridad == Tarea2.Prioridad.MEDIA){
            return "MEDIA";
        }else {
            return "BAJA";
        }


    }
}
