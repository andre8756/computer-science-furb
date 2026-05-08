package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1;
        int contador = 1;

        System.out.print("Digite o valor de n (positivo): ");
        n1 = scan.nextInt();

        System.out.println();

        for (int i = 0; i < n1; i++) {
            System.out.print(contador);
            contador++;

            for (int j = 0; j < i; j++) {
                System.out.print(" " + contador);
                contador++;
            }

            System.out.println();
        }

    }
}
