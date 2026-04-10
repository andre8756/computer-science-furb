package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe25 {
    Scanner scan = new Scanner(System.in);
    float n1, n2;
    int opcao;

    public Uni4Exe25() {
        iniciar();
    }

    public void iniciar() {

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Soma de dois números.");
        System.out.println("2 - Diferença entre dois números.");
        System.out.println("3 - Produto entre dois números.");
        System.out.println("4 - Divisão entre dois números (o denominador não pode ser zero). ");
        System.out.println();
        System.out.print("Valor 1: ");
        n1 = scan.nextFloat();
        System.out.print("Valor 2: ");
        n2 = scan.nextFloat();
        System.out.print("Opção: ");
        opcao = scan.nextInt();

        resposta();
    }

    public float soma() {
        return n1 + n2;
    }

    public float subtracao() {
        return n1 - n2;
    }

    public float multiplicacao() {
        return n1 * n2;
    }

    public float divisao() {
        if (n2 != 0) {
            return n1 / n2;
        }
        return 0;
    }

    public void resposta() {
        switch (opcao) {
            case 1:
                System.out.println(soma());
                break;

            case 2:
                System.out.println(subtracao());
                break;

            case 3:
                System.out.println(multiplicacao());
                break;

            case 4:
                System.out.println(divisao());
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        new Uni4Exe25();
    }
}
