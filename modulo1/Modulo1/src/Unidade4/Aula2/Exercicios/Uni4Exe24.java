package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe24 {
    Scanner scan = new Scanner(System.in);
    int opcao, n1, n2, n3, maior, menor, meio;

    public Uni4Exe24() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite o primeiro valor: ");
        n1 = scan.nextInt();
        System.out.print("Digite o segundo valor: ");
        n2 = scan.nextInt();
        System.out.print("Digite o terceiro valor: ");
        n3 = scan.nextInt();
        System.out.print("Digite a opção: ");
        opcao = scan.nextInt();

        ordena();
    }

    public void compara() {
        if (n1 > n2 && n1 > n2) {
            maior = n1;
            if (n2 >= n3) {
                menor = n3;
                meio = n2;
            } else {
                meio = n3;
                menor = n2;
            }
        } else if (n2 > n1 && n2 > n3) {
            maior = n2;
            if (n1 > n3) {
                menor = n3;
                meio = n1;
            } else {
                meio = n3;
                menor = n1;
            }
        } else if (n3 > n1 && n3 > n2) {
            maior = n3;
            if (n1 > n2) {
                meio = n1;
                menor = n2;
            } else {
                menor = n1;
                meio = n2;
            }
        }
    }

    public void ordena() {
        compara();

        switch (opcao) {
            case 1:
                System.out.printf(" %d %d %d ", menor, meio, maior);
                break;

            case 2:
                System.out.printf(" %d %d %d ", maior, meio, menor);
                break;

            case 3:
                System.out.printf(" %d %d %d ", meio, maior, menor);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void main(String[] args) {
        new Uni4Exe24();
    }
}
