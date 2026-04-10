package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe22 {
    Scanner scan = new Scanner(System.in);
    int opcao;

    public Uni4Exe22() {
        iniciar();
    }

    public void iniciar() {
        System.out.println("1 - Ciência da Computação");
        System.out.println("2 - Licenciado em Computação");
        System.out.println("3  - Sistemas de Informação");
        System.out.println();
        System.out.print("Digite a resposta: ");
        opcao = scan.nextInt();

        emitirCertificado();
    }

    public void emitirCertificado() {
        switch (opcao) {
            case 1:
                System.out.println("Bacharel em Ciência da Computação");
                break;

            case 2:
                System.out.println("Licenciado em Computação");
                break;

            case 3:
                System.out.println("Bacharel em Sistemas de Informação");
                break;

            default:
                System.out.println("Opção invália!");
                break;
        }
    }

    public static void main(String[] args) {
        new Uni4Exe22();
    }
}
