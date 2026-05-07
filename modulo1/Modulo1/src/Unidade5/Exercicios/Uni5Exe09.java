package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, idade;
        String nome;
        String payload1 = "";
        String nomeComposto = "";
        int qnt20 = 0;
        int qnt18 = 0;

        System.out.print("Digite a quantidade de alunos: ");
        n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            nome = scan.next();
            System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
            idade = scan.nextInt();

            if (idade == 18) {
                qnt18++;

                if (qnt18 == 1) {
                    nomeComposto = nomeComposto + nome;
                } else if (qnt18 == 2) {
                    payload1 = nome;
                } else if (qnt18 > 2) {
                    nomeComposto = nomeComposto + ", " + nome;
                }
            } else if (idade > 20) {
                qnt20++;
            }
        }

        if (qnt18 > 2) {
            nomeComposto = nomeComposto + " e " + payload1;
        }

        System.out.println("Nomes dos alunos que tem 18 anos: " + nomeComposto);
        System.out.println("Quantidade de alunos que tem idade acima de 20 anos: " + qnt20);
    }
}
