package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome;
        float precoCompra, precoVenda, lucro;
        float compraTotal = 0;
        float vendaTotal = 0;
        float lucroTotal = 0;
        int mercadorias = 20;
        int menorDez = 0;
        int dezVinte = 0;
        int acimaVinte = 0;

        for (int i = 0; i < mercadorias; i++) {
            System.out.println("Mercadoria: " + (i + 1) + ": ");
            System.out.print("  Nome: ");
            nome = scan.next();
            System.out.print("  Preço de Compra: ");
            precoCompra = scan.nextFloat();
            System.out.print("  Preço de Venda: ");
            precoVenda = scan.nextFloat();

            lucro = (precoVenda - precoCompra) / precoCompra * 100;
            compraTotal += precoCompra;
            vendaTotal += precoVenda;
            lucroTotal += (precoVenda - precoCompra);

            if (lucro < 10) {
                menorDez++;
            } else if (lucro >= 10 && lucro <= 20) {
                dezVinte++;
            } else {
                acimaVinte++;
            }

        }

        System.out.println("Mercadorias com menos de 10% de lucro: " + menorDez);
        System.out.println("Mercadorias entre 10% e 20% de lucro: " + dezVinte);
        System.out.println("Mercadorias com mais de 20% de lucro: " + acimaVinte);
        System.out.println("Valor total de compra: " + compraTotal);
        System.out.println("Valor total de venda: " + vendaTotal);
        System.out.println("Valor total de lucro: " + lucroTotal);

    }
}
