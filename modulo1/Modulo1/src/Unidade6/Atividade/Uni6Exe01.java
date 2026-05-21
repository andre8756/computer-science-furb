package Unidade6.Atividade;

import java.util.Scanner;

public class Uni6Exe01 {
    Scanner scan = new Scanner(System.in);
    int n;
    int array[];

    public Uni6Exe01(int n) {
        this.n = n;
        array = new int[n];
    }

    public void ler() {
        System.out.println("--Lendo: ");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o " + (i + 1) + " número: ");
            array[i] = scan.nextInt();
        }
    }

    public void printar() {
        System.out.println("--Escrevendo: ");

        for (int i = (n - 1); i >= 0; i--) {
            System.out.println("Número da posição " + i + ": " + array[i]);
        }
    }

    public static void main(String[] args) {
        Uni6Exe01 exercicio = new Uni6Exe01(10);
        exercicio.ler();
        System.out.println();
        exercicio.printar();
    }

}
