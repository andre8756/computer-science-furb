package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float reais, dolars;

        System.out.print("Digite o valor a ser convertido: ");
        dolars = scan.nextFloat();

        reais = dolars * 5.23f;

        System.out.printf("O valor a ser devolvido é: %.2f", reais);
        scan.close();
    }
}
