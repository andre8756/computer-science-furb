package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dobras, quadrados;

        System.out.print("Digite o número de dobras (em um número par) feitas no papel: ");
        dobras = scan.nextInt();

        quadrados = (int) Math.pow(2, dobras);

        System.out.printf("Ao desdobrar você verá %d quadrados.", quadrados);

        scan.close();
    }
}