package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, c, d;

        System.out.println("Digite o valor A: ");
        a = scan.nextInt();
        System.out.println("Digite o valor B: ");
        b = scan.nextInt();
        System.out.println("Digite o valor C: ");
        c = scan.nextInt();
        System.out.println("Digite o valor D: ");
        d = scan.nextInt();

        float diferenca = ((a * b) - (c * d));

        System.out.println("A diferença é: " + diferenca);

        scan.close();
    }
}
