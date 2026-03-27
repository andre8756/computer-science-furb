package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe05 {
    Scanner scan = new Scanner(System.in);
    boolean cor;

    public Uni4Exe05() {
        iniciar();
    }

    public void iniciar() {
        System.out.println("A cor é azul? ");
        cor = scan.nextBoolean();
        if (cor) {
            System.out.println("Sim");
        } else {
            System.out.println("Não");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe05();
    }
}
