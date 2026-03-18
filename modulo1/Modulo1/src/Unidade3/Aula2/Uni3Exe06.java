package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe06 {

    private float preçoQuilo = 25;
    private float prato;

    public Uni3Exe06(float prato) {
        this.prato = prato;
    }

    public Uni3Exe06() {
    }

    public float calculaPreco(float prato) {
        return (prato - 0.750f) * preçoQuilo;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o peso do prato: ");
        float prato = scan.nextFloat();
        Uni3Exe06 restaurante = new Uni3Exe06(prato);

        System.out.printf("O valor do prato do cliente é R$ %.2f", restaurante.calculaPreco(prato));
    }

}
