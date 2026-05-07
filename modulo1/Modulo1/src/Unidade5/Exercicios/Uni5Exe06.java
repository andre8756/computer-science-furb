package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float altura = 0;
        float media;

        for (int i = 0; i < 20; i++) {
            System.out.println("Altura da pessoa " + (i + 1) + ": ");
            altura = altura + scan.nextFloat();
        }

        media = altura / 20;

        System.out.println("A média das alturas é: " + media);
    }
}
