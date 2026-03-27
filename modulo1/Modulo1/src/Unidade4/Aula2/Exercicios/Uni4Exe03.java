package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe03 {
    Scanner scan = new Scanner(System.in);
    private int n1, n2, maior;

    public Uni4Exe03() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite o primeiro valor: ");
        n1 = scan.nextInt();
        System.out.print("Digite o segundo número: ");
        n2 = scan.nextInt();
        getMaior();
    }

    public void getMaior() {
        if (n1 > n2) {
            System.out.printf("O valor %d é maior que o valor %d\n", n1, n2);
        } else {
            System.out.printf("O valor %d é maior que o valor %d\n", n1, n2);
        }
    }

    public static void main(String[] args) {
        new Uni4Exe03();
    }

}
