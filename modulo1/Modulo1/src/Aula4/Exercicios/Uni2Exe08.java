package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int codigo1, codigo2, unidades1, unidades2;
        float valor1, valor2, total;

        System.out.print("Digite o código da peça 1: ");
        codigo1 = scan.nextInt();
        System.out.print("Digite o número de peças: ");
        unidades1 = scan.nextInt();
        System.out.print("Digite o preço unitário da peça: ");
        valor1 = scan.nextInt();

        System.out.println();

        System.out.print("Digite o código da peça 2: ");
        codigo2 = scan.nextInt();
        System.out.print("Digite o número de peças: ");
        unidades2 = scan.nextInt();
        System.out.print("Digite o preço unitário da peça: ");
        valor2 = scan.nextInt();

        total = (unidades1 * valor1) + (unidades2 * valor2);

        System.out.printf("O total a ser pago é: R$ %.2f", total);
        scan.close();
    }
}
