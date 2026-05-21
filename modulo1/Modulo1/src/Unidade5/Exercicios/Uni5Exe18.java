package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int canal = 1;
        int totalAssistindo = 0;
        int pessoasAssistindo;
        float media;

        while (canal != 0) {
            System.out.println("Canal: ");
            canal = scan.nextInt();

            if (canal == 0) {
                break;
            } else if (canal != 4 || canal != 5 || canal != 9 || canal != 12) {
                System.out.println("Número inválido! Tente novamente");
                continue;
            }

            System.out.println("Pessoas Assistindo: ");
            pessoasAssistindo = scan.nextInt();

            totalAssistindo += pessoasAssistindo;
        }
    }
}
