package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        int valor;
        int min = 0;
        int soma = 0;
        float media;

        System.out.print("Digite o valor de n: ");
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Digite o " + (i + 1) + " número: ");
            valor = scan.nextInt();
            if (valor < min) {
                min = valor;
            } else if (valor > 0) {
                soma = soma + valor;
            }
        }

        media = soma / n;

        System.out.println("Menor valor negativo: " + min);
        System.out.println("Média dos números positivos: " + media);

    }
}