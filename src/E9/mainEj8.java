package E9;

public class mainEj8 {
    public static void main(String[] args) {

        Fecha fecha1 = new Fecha();
        cargarddMMyyyy(fecha1,"adhsgjh");

        Fecha fecha2 = new Fecha();
        cargarddMMyyyy(fecha2,"15-12-2004");

        Fecha fecha3 = new Fecha();
        cargarMMddyyyy(fecha3,"10-23-2055");

        Fecha fecha4 = new Fecha();
        cargarMMddyyyy(fecha4,"06-30-1991");


        printSeEncuentreEntre(fecha2,fecha3,fecha4);

        printSeEncuentreEntre(fecha2,fecha4,fecha3);

        printSeEncuentreEntre(fecha3,fecha4,fecha2);

        printEsMayorA(fecha3,fecha4);

        printEsMenorA(fecha3,fecha4);

    }
    public static void cargarMMddyyyy(Fecha fecha,String texto){
        if (fecha.setFechaMMddyyyy(texto)){
            System.out.println("Fecha cargada. "+fecha.getFecha());
        }else{
            System.out.println("Formato Incorrecto.");
        }
    }

    public static void cargarddMMyyyy(Fecha fecha,String texto){
        if (fecha.setFechaddMMyyyy(texto)){
            System.out.println("Fecha cargada. "+fecha.getFecha());
        }else{
            System.out.println("Formato Incorrecto.");
        }
    }

    public static void printSeEncuentreEntre(Fecha fecha,Fecha minimo, Fecha maximo){
        if (fecha.seEncuentraEntre(minimo.getFecha(),maximo.getFecha())){
            System.out.println(fecha.getFecha()+" se encuentra entre "+minimo.getFecha()+" y "+maximo.getFecha());
        } else {
            System.out.println((fecha.getFecha()+" no se encuentra entre "+minimo.getFecha()+" y "+maximo.getFecha()));
        }
    }

    public static void printEsMayorA(Fecha fecha,Fecha fecha2){
        if (fecha.esMayorA(fecha2.getFecha())){
            System.out.println(fecha.getFecha()+" es mayor a " +fecha2.getFecha());
        } else {
            System.out.println(fecha.getFecha()+" no es mayor a " +fecha2.getFecha());
        }
    }

    public static void printEsMenorA(Fecha fecha,Fecha fecha2){
        if (fecha.esMenorA(fecha2.getFecha())){
            System.out.println(fecha.getFecha()+" es menor a " +fecha2.getFecha());
        } else {
            System.out.println(fecha.getFecha()+" no es menor a " +fecha2.getFecha());
        }
    }
}

