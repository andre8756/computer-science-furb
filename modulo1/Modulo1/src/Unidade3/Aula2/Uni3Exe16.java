package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe16 {

    private int valorProduto;
    private int valorCliente;
    private int valorTroco;
    private int notas100;
    private int notas10;
    private int notas1;
    private int resto;
    private int totalNotas;

    public Uni3Exe16(int valorProduto, int valorCliente) {
        this.valorProduto = valorProduto;
        this.valorCliente = valorCliente;
    }

    public void setTroco() {
        valorTroco = valorCliente - valorProduto;
    }

    public void calcularTroco() {
        notas100 = valorTroco / 100;
        resto = valorTroco % 100;
        notas10 = resto / 10;
        resto = resto % 10;
        notas1 = resto;

        totalNotas = notas100 + notas10 + notas1;
    }

    public void printarTroco() {
        System.out.printf("O número mínimo de notas de troco é: %d \n", totalNotas);
        System.out.println();
        System.out.printf("Quantidade de notas de 100 necessárias é: %d \n", notas100);
        System.out.printf("Quantidade de notas de 10 necessárias é: %d \n", notas10);
        System.out.printf("Quantidade de notas de 1 necessárias é: %d \n", notas1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Valor total da compra: ");
        int valorCompra = scan.nextInt();
        System.out.print("Valor total dado pelo cliente: ");
        int valorCliente = scan.nextInt();
        System.out.println();

        Uni3Exe16 registradora = new Uni3Exe16(valorCompra, valorCliente);
        registradora.setTroco();
        registradora.calcularTroco();
        registradora.printarTroco();

        scan.close();
    }

}
