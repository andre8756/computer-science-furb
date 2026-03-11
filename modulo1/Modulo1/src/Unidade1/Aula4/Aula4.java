package Aula4;

import java.util.Random;

public class Aula4 {
    public static void main(String[] args) {
        // raiz quadrada
        double numero = 25;
        double valor = Math.sqrt(numero);
        System.out.println(valor);

        // potencias
        numero = 2;
        double potencia = 3;
        valor = Math.pow(numero, potencia);
        System.out.println(valor);

        // Pi
        double pi = Math.PI;
        double meuPi = Math.PI;
        System.out.println(pi);
        System.out.println(meuPi);

        // maior numero
        int n1 = 40;
        int n2 = 35;
        int maiorNumero = Math.max(n1, n2);
        System.out.println(maiorNumero);

        // numero random
        double aleatorio = Math.random();
        Random random = new Random();
        int outroRandom = random.nextInt(10);
        System.out.println(aleatorio);
        System.out.println(outroRandom);

    }
}
