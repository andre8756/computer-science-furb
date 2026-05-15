package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int reabastecimentos;
        float quilometragem, combustivel;
        float quilometragemMedia = 0;
        System.out.println("Número total de reabastecimentos: ");
        reabastecimentos = scan.nextInt();

        for (int i = 0; i < reabastecimentos; i++) {
            System.out.println("Parada " + (i + 1) + ": ");
            System.out.print("  Quilometragem: ");
            quilometragem = scan.nextFloat();
            System.out.print("  Combustível: ");
            combustivel = scan.nextFloat();
            System.out.println("  Parada " + (i + 1) + ": " + (quilometragem / combustivel));
            quilometragemMedia += (quilometragem / combustivel);
        }

        quilometragemMedia /= reabastecimentos;

        System.out.printf("Quilometragem média obtida por litro: %.2f", quilometragemMedia);

    }

}
