package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1, n2, multiplo;

        System.out.print("Digite o primeiro número: ");
        n1 = scan.nextInt();
        System.out.print("Digite o segundo número: ");
        n2 = scan.nextInt();
        multiplo = n1 * n2;

        System.out.printf("A soma dos numeros %d e %d é %d ", n1, n2, multiplo);

        scan.close();
    }
}
