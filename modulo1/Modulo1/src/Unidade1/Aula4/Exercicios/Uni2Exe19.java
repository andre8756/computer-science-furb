package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a, b, c, d;

        System.out.print("Digite o valor de B: ");
        b = scan.nextDouble();
        System.out.print("Digite o valor de C: ");
        c = scan.nextDouble();
        System.out.print("Digite o valor de D: ");
        d = scan.nextDouble();

        a = b;

        System.out.printf("Valor de A = %.2f", a);

        scan.close();
    }
}