package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int raio;
        double area;

        System.out.print("Digite o raio da circunferência: ");
        raio = scan.nextInt();
        area = Math.pow(raio, 2) * Math.PI;

        System.out.printf("A area do quadrado é: %.2f", area);

        scan.close();

    }

}
