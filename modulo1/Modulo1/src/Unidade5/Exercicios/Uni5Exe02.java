package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pares = 0;
        int impares = 0;

        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                pares = pares + i;

            } else {
                impares = impares + i;
            }
        }

        System.out.println("Soma dos numeros pares: " + pares);
        System.out.println("Soma dos numeros impares: " + impares);
    }
}
