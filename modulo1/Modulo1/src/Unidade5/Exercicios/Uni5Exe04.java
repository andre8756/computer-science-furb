package Unidade5.Exercicios;

public class Uni5Exe04 {
    public static void main() {

        double numerador = 3;
        double denominador = 2;
        int n1 = 2;
        int n2 = 1;
        double resultado = 0;

        for (int i = 0; i < 20; i++) {
            resultado = resultado + numerador / denominador;
            denominador = numerador + denominador + 1;
            numerador = numerador + 2;
        }

        System.out.println("Resultado: " + resultado);
    }

}
