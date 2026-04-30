package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1;

        for (int i = 0; i < 21; i++) {
            System.out.println("Digite um número: ");
            n1 = scan.nextInt();

            if (n1 % 2 == 0) {
                System.out.println("Par");
            } else {
                System.out.println("Ímpar");
            }
        }
    }
}
