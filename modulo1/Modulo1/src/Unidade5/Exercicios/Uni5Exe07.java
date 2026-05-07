package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1;
        double payload;
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;

        System.out.print("Digite o n: ");
        n1 = scan.nextInt();

        for (int i = 0; i < n1; i++) {

            System.out.print("digite o " + (i + 1) + " numero real: ");
            payload = scan.nextDouble();

            if (payload > max) {
                max = payload;
            } else if (payload < min) {
                min = payload;
            }
        }

        System.out.println("O maior númeor é: " + max);
        System.out.println("O menor númeor é: " + min);
    }
}
