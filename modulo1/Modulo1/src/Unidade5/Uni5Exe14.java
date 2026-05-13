package Unidade5;

import java.util.Scanner;

public class Uni5Exe14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome;
        float precoCompra, compraTotal, precoVenda, vendaTotal, lucro, lucroTotal;
        int mercadorias = 20;
        int menorDez = 0;
        int dezVinte = 0;
        int acimaVinte = 0;

        for (int i = 0; i < mercadorias; i++) {
            System.out.println("Mercadoria: " + (i + 1) + ": ");
            System.out.print("  Nome: ");
            nome = scan.next();
            System.out.println("  Preço de Compra: ");
            precoCompra = scan.nextFloat();
            System.out.println("  Preço de Venda: ");
            precoVenda = scan.nextFloat();

            lucro = (precoVenda - precoCompra) / precoCompra * 100;

            if (lucro < 0.1f) {
                menorDez++;
            } else if (lucro >= 0.1 && lucro <= 0.2) {
                dezVinte++;
            } else {
                acimaVinte++;
            }

            // Só falta printar

        }

    }
}
