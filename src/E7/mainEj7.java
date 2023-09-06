package E7;

public class mainEj7 {
    public static void main(String[] args) {
        Ecuacion ecuacion = new Ecuacion(2,6,4);

        if(ecuacion.unaRaiz()){
            Double resul = ecuacion.resolverRaizUnica();
            if (!Double.isNaN(resul)) {
                System.out.println("Raiz unica: " + resul);
            }else {
                System.out.println("Resultado fuera de los racionales.");
            }
        }else {
            System.out.println("Raiz doble: "+ecuacion.resolverRaices());
        }

        System.out.println("Resultado de Y con X = 10: "+ecuacion.calcularY(10));
    }
}
