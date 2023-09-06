package E11;

public class mainEj11 {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        jugador1.formarPalabra("Kiwi");
        System.out.println("Jugador1 jugó Kiwi");

        jugador2.formarPalabra("Yaguar");
        System.out.println("Jugador2 jugó Yaguar");

        System.out.println("Jugador1 tiene "+jugador1.getPuntajeTotal()+" puntos.");
        System.out.println("Jugador2 tiene "+jugador2.getPuntajeTotal()+" puntos.");

        jugador2.agregarPalabraADiccionario("Quadrado");
        System.out.println("Jugador2 agrego Quadrado al diccionario");

        jugador1.formarPalabra("Quadrado");
        System.out.println("Jugador1 jugó Quadrado");

        jugador2.formarPalabra("Mate");
        System.out.println("Jugador2 jugó Mate (No esta en el diccionario)");

        System.out.println("Jugador1 tiene "+jugador1.getPuntajeTotal()+" puntos.");
        System.out.println("Jugador2 tiene "+jugador2.getPuntajeTotal()+" puntos.");

        mostrarGanador(jugador1,jugador2);
    }
    
    public static void mostrarGanador(Jugador jUno,Jugador jDos){
        if (jUno.getPuntajeTotal()==jDos.getPuntajeTotal()){
            System.out.println("Empatados");
        } else if (jUno.getPuntajeTotal()>jDos.getPuntajeTotal()) {
            System.out.println("Gana Jugador1");
        }else {
            System.out.println("Gana Jugador2");
        }
    }
}
