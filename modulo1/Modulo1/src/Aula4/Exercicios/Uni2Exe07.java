package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome;
        float salario, totalVendas, comissao, comissaoTotal;

        System.out.print("Digite o nome do vendedor: ");
        nome = scan.nextLine();
        System.out.print("Digite o salário fixo do vendedor: ");
        salario = scan.nextFloat();
        System.out.print("Digite o valor total de vendas do vendedor: ");
        totalVendas = scan.nextFloat();

        comissao = (totalVendas * 0.15f);
        comissaoTotal = comissao + salario;
        System.out.println("O vendedor " + nome + " deve receber no final do Mês:");
        System.out.printf("Salário fixo: %.2f%n", salario);
        System.out.printf("Salário fixo: %.2f%n", comissao);
        System.out.printf("Total: %.2f", comissaoTotal);
        scan.close();
    }
}
