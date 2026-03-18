package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe02 {

    private float valorDoCalculo;
    private float percentualDesconto;

    // construtor
    public Uni3Exe02(float valor, float desconto) {
        this.valorDoCalculo = valor;
        this.percentualDesconto = desconto;
    }

    public float desconto() {
        return valorDoCalculo * (percentualDesconto / 100);
    }

    public float valorTotalAPagar() {
        return valorDoCalculo - desconto();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o preço do par de sapatos com desconto ");
        float valorTotal = scan.nextFloat();
        System.out.println();
        Uni3Exe02 calcado = new Uni3Exe02(valorTotal, 12);
        System.out.printf("Valor do desconto: R$ %.2f \n", calcado.desconto());
        System.out.printf("O preço do par de sapatos com desconto: R$ %.2f ", calcado.valorTotalAPagar());

        scan.close();
    }

}
