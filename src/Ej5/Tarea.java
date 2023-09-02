package Ej5;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;
    private boolean completa;
    private boolean vencida;
    private LocalDate fechaLimite;

    private enum Prioridad{
        ALTA, MEDIA, BAJA
    }
    public Tarea(String descripcion){
        this.descripcion = descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCompleta(boolean completa) {
        this.completa = completa;
    }
    public boolean getCompleta(){
        return  completa;
    }
    public String getCompletaStr(){
        String acumulador;
        if (completa) {
            acumulador =("Completa");
        } else {
            acumulador =("Incompleta");
        }
        return acumulador;
    }
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
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
        return resp;
    }

    public String getFechaStr(){
        if (fechaLimite!=null) {
            return fechaLimite.toString();
        }else {
            return "No hay fecha limite";
        }
    }
    public void setVencida(boolean vencida) {
        this.vencida = vencida;
    }
    public boolean getVencida(){
        comprobarVencida();
        return vencida;
    }

    public String getVencidaStr(){
        comprobarVencida();
        String acumulador;
        if (vencida) {
            acumulador = ("(Vencida) ");
        } else {
            acumulador = ("(No vencida) ");
        }
        return acumulador;
    }

    public String getDescripcion(){
        comprobarVencida();
        String acumulador;
        if (descripcion!=null) {
            acumulador = getVencidaStr()+descripcion;
        }else {
            acumulador = "No existe.";
        }
        return acumulador;
    }

    public String mostrar(){
        String acumulador;
        comprobarVencida();
        acumulador =(getDescripcion()+". Prioridad "+getPrioridad()+", Estado de "+getCompletaStr()+", Fecha límite "+getFechaStr()+".");
        return acumulador;
    }

    /**
     * Inserte 1 para ALTA, 2 para MEDIA o 3 para BAJA
     * @ setPrioridad
     */
    public void setPrioridad(int opcion) {
        if (opcion==1){
            prioridad = Prioridad.ALTA;
        } else if (opcion==2){
            prioridad = Prioridad.MEDIA;
        } else {
            prioridad = Prioridad.BAJA;
        }
    }

    public String getPrioridad() {
        if (prioridad == Prioridad.ALTA){
            return "ALTA";
        }else if (prioridad == Prioridad.MEDIA){
            return "MEDIA";
        }else {
            return "BAJA";
        }
    }
}
