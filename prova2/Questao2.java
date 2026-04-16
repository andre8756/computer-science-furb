package prova2;

import java.util.Scanner;

public class Questao2 {
    private Scanner scan = new Scanner(System.in);
    private int plano;
    private char antigo;
    private float valor;

    public Questao2() {
        iniciar();
    }

    public void iniciar() {
        System.out.println("Plano 1 -> R$ 100,00 ");
        System.out.println("Plano 2 -> R$ 200,00 ");
        System.out.println("Plano 3 -> R$ 400,00 ");
        System.out.println();
        System.out.print("Escolha o plano (1,2 ou 3):  ");
        plano = scan.nextInt();
        System.out.print("Aluno antigo? (S/N): ");
        antigo = scan.next().toUpperCase().charAt(0);

        calcular();
    }

    public int calcular() {
        if (antigo != 'S' && antigo != 'N') {
            System.out.println("Campo antigo inválido!");
            System.out.println(antigo);
            return 1;
        }

        if (plano == 1) {
            valor = 100;
        } else if (plano == 2) {
            valor = 200;
        } else if (plano == 3) {
            valor = 400;
        } else {
            System.out.println("Plano inválido!!");
            return 2;
        }

        if (antigo == 'S') {
            valor = valor - (valor * 0.15f);
        } else if (valor >= 300) {
            valor = valor - (valor * 0.1f);
        }

        System.out.printf("Valor final do plano: R$ %.2f", valor);

        return 0;
    }

    public static void main(String[] args) {
        new Questao2();
    }
}
