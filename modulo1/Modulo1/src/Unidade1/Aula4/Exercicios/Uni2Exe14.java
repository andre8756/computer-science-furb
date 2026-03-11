package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe14{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int valor, notas100, notas50, notas20, notas10, notas5, notas2, notas1;

        System.out.print("Digite o valor desejado para troco: ");
        valor = scan.nextInt();

        notas100 = 0;
        notas50 = 0;
        notas20 = 0;
        notas10 = 0;
        notas5 = 0;
        notas2 = 0;
        notas1 = 0;

        notas100 = valor / 100;
        valor = valor % 100;
        notas50 = valor/50;
        valor = valor % 50;
        notas20 = valor / 20;
        valor = valor % 20;
        notas10 = valor / 10;
        valor = valor % 10;
        notas5 = valor / 5;
        valor = valor % 5;
        notas2 = valor / 2;
        valor = valor % 2;
        notas1 = valor;

        System.out.println("------Valor do troco: ");
        System.out.printf("Notas de R$100,00 - %d%n", notas100);
        System.out.printf("Notas de R$50,00 - %d%n", notas50);
        System.out.printf("Notas de R$20,00 - %d%n", notas20);
        System.out.printf("Notas de R$10,00 - %d%n", notas10);
        System.out.printf("Notas de R$5,00 - %d%n", notas5);
        System.out.printf("Notas de R$02,00 - %d%n", notas2);
        System.out.printf("Notas de R$01,00 - %d%n", notas1);
        

        scan.close();
    }
}