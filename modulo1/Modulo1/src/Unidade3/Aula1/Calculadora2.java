package Unidade3.Aula1;

public class Calculadora2 {
    private double n1;
    private double n2;

    public double somar(double n1, double n2) {
        return n1 + n2;
    }

    public double subtrair(double n1, double n2) {
        return n1 - n2;
    }

    public double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    public double dividir(double n1, double n2) {
        return n1 / n2;
    }

    public double raiz(double n1) {
        return Math.sqrt(n1);
    }

    public double exponencial(double n1, double n2) {
        return Math.pow(n1, n2);
    }

    public static void main(String[] args) {
        Calculadora2 calculadora2 = new Calculadora2();

        double valor = calculadora2.exponencial(5, 2);
        System.out.println(valor);
    }

}
