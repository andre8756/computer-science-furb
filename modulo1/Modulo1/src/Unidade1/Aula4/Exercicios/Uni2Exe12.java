package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1, y1, x2, y2, distancia;

        System.out.println("----POSICAO 1: ");
        System.out.print("Digite o valor do eixo X:");
        x1 = scan.nextDouble();
        System.out.print("Digite o valor do eixo Y:");
        y1 = scan.nextDouble();

        System.out.println("----POSICAO 2: ");
        System.out.print("Digite o valor do eixo X:");
        x2 = scan.nextDouble();
        System.out.print("Digite o valor do eixo Y:");
        y2 = scan.nextDouble();

        distancia = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2));

        System.out.printf("A distância é igual a: %.4f", distancia);
        scan.close();
    }
}
