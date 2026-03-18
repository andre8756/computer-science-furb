package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe08 {

    private float valor;
    private float cotacao;

    public Uni3Exe08() {
    }

    public Uni3Exe08(float valor, float cotacao) {
        this.valor = valor;
        this.cotacao = cotacao;
    }

    public float calculoCambio() {
        return valor * cotacao;
    }

    public float calculoCambio(float valor, float cotacao) {
        return valor * cotacao;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Valor em dólares recebido pelo cliente: ");
        float valor = scan.nextFloat();
        System.out.print("Cotação do dólar hoje: ");
        float dolar = scan.nextFloat();

        Uni3Exe08 cambio = new Uni3Exe08(valor, dolar);

        System.out.printf("O atendente deve devolver %.2f para o cliente. ", cambio.calculoCambio());

        scan.close();
    }
}
