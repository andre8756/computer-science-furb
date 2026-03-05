package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1, n2, soma;

        System.out.print("Digite o primeiro número: ");
        n1 = scan.nextInt();
        System.out.print("Digite o segundo número: ");
        n2 = scan.nextInt();
        soma = n1 + n2;

        System.out.printf("A soma dos numeros %d e %d é %d ", n1, n2, soma);

        scan.close();
    }
}
