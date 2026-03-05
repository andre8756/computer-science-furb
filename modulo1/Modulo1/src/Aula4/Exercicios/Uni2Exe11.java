package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float a, b, c, areaRetangulo, areaTrapezio;
        double areaCirculo, areaQuadrado, retangulo2Lados;

        System.out.print("Digite o valor A: ");
        a = scan.nextFloat();
        System.out.print("Digite o valor B: ");
        b = scan.nextFloat();
        System.out.print("Digite o valor C: ");
        c = scan.nextFloat();

        // a - area do triângulo retângulo que tem A por base e C por altura.
        areaRetangulo = (a * c) / 2;
        // b - área do círculo de raio C. (pi = 3.14159)
        areaCirculo = Math.pow(c, 2) * Math.PI;
        // c - área do trapézio que tem A e B por bases e C por altura
        areaTrapezio = ((a + b) * c) / 2;
        // d - área do quadrado que tem lado B
        areaQuadrado = Math.pow(b, 2);
        // e - área do retângulo que tem lados A e B
        retangulo2Lados = a * b;

        System.out.println("-----Resultados------");
        System.out.println("A área do triângulo retângulo que tem A por base e C por altura:");
        System.out.printf("%.2f", areaRetangulo);
        System.out.println();
        System.out.println("A área do círculo de raio C. (pi = 3.14159):");
        System.out.printf("%.2f", areaCirculo);
        System.out.println();
        System.out.println("A área do trapézio que tem A e B por bases e C por altura:");
        System.out.printf("%.2f", areaTrapezio);
        System.out.println();
        System.out.println("A área do quadrado que tem lado B:");
        System.out.printf("%.2f", areaQuadrado);
        System.out.println();
        System.out.println("A área do retângulo que tem lados A e B:");
        System.out.printf("%.2f", retangulo2Lados);

        scan.close();
    }
}
