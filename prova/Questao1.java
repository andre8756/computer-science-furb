package prova;

import java.util.Scanner;

public class Questao1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite um valor em R$ sem centavos: ");
        int reais = scan.nextInt();

        int notas100 = 0;
        int notas50 = 0;
        int notas20 = 0;

        while (reais >= 100) {
            reais = reais - 100;
            notas100++;
        }

        while (reais >= 50) {
            reais = reais - 50;
            notas50++;
        }

        while (reais >= 20) {
            reais = reais - 20;
            notas20++;
        }

        System.out.println("O troco ficou com: ");
        System.out.println(notas100 + " notas de R$ 100");
        System.out.println(notas50 + " notas de R$ 50");
        System.out.println(notas20 + " notas de R$ 20");

        if (reais > 0) {
            System.out.println("E ainda sobrou R$ " + reais);
        } else {
            System.out.print("E não sobrou mais nada.");
        }
    }

}
