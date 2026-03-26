package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe02 {
    Scanner scan = new Scanner(System.in);
    int valor;

    public Uni4Exe02() {
        iniciar();
    }

    public void verificaPar() {
        if (valor % 2 == 0) {
            System.out.println("Número é par");
        } else {
            System.out.println("Número é ímpar");
        }
    }

    public void iniciar() {
        System.out.print("Digite um número: ");
        valor = scan.nextInt();
        verificaPar();
    }

    public static void main(String[] args) {
        new Uni4Exe02();
    }
}
