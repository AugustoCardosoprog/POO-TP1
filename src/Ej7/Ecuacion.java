package Ej7;

public class Ecuacion {
    private double a;
    private double b;
    private double c;

    private int X;
    private int Y;

    private double x1Raiz;
    private double x2Raiz;

    private double raizUnica;

    private double discriminante;

    public Ecuacion(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante(){
        return  ( b * b - 4 * a * c);
    }
    public boolean unaRaiz(){
        if(getDiscriminante()==0){
            return true;
        }else{
            return false;
        }
    }

    public double resolverRaizUnica(){
        raizUnica=(-b + Math.sqrt(getDiscriminante())) / (2 * a);
        return (raizUnica);

    }
    public String resolverRaices(){
        x1Raiz=(-b + Math.sqrt(getDiscriminante())) / (2 * a);
        x2Raiz=(-b - Math.sqrt(getDiscriminante())) / (2 * a);
        if (Double.isNaN(x1Raiz)||(Double.isNaN(x2Raiz))){
            return ("Resultado fuera de los racionales.");
        }else {
            return ("Raiz x1: "+x1Raiz+"."+" Raiz x2: "+x2Raiz+".");
        }
    }

    public double calcularY(double x){
        double resultado = (a *(x * x)+(b * x)+c);
        return resultado;
    }
}
