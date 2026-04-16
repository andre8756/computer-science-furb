package prova2;

import java.util.Scanner;

public class Questao3 {
    private Scanner scan = new Scanner(System.in);
    private char tipoConbustivel;
    private float valorTotal, litros, valorCombustivel;

    public Questao3() {
        iniciar();
    }

    public void iniciar() {
        System.out.println("Gasolina (G) -> R$ 5,80");
        System.out.println("Etanol (E) -> R$ 4,30");
        System.out.println("Diesel (D) -> R$ 6,20");
        System.out.println();
        System.out.print("Digite o tipo de conbustível(G/E/D): ");
        tipoConbustivel = scan.next().toUpperCase().charAt(0);

        System.out.print("Digite a quantidade de litros: ");
        litros = scan.nextFloat();

        calcularPreco();
    }

    public int calcularPreco() {
        if (tipoConbustivel == 'G') {
            valorCombustivel = 5.80f;
        } else if (tipoConbustivel == 'E') {
            valorCombustivel = 4.30f;
        } else if (tipoConbustivel == 'D') {
            valorCombustivel = 6.20f;
        } else {
            System.out.println("Tipo de combustível inválido!!");
            return 1;
        }

        valorTotal = valorCombustivel * litros;

        if (litros >= 30) {
            valorTotal = valorTotal - (valorTotal * 0.07f);
        }

        System.out.printf("Valor final a pagar: R$ %.2f", valorTotal);

        return 0;
    }

    public static void main(String[] args) {
        new Questao3();
    }
}
