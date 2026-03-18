package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe03 {

    private float precoGasolina;
    private float valorPagamento;

    public Uni3Exe03(float precoGasolina, float valorPagamento) {
        this.precoGasolina = precoGasolina;
        this.valorPagamento = valorPagamento;
    }

    public float calcularCombustivel() {
        return valorPagamento / precoGasolina;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o preço do litro da gasolina: ");
        float precoGasolina = scan.nextFloat();

        System.out.print("Digite o valor pago: ");
        float valorPago = scan.nextFloat();

        Uni3Exe03 posto = new Uni3Exe03(precoGasolina, valorPago);

        System.out.printf("Você conseguiu colocar %.2f com este valor", posto.calcularCombustivel());
    }

}
