package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe13 {
    Scanner scan = new Scanner(System.in);
    int c1, c2, c3;

    Uni4Exe13() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite a primeira carta: ");
        c1 = scan.nextInt();
        System.out.print("Digite a segunda carta: ");
        c2 = scan.nextInt();
        System.out.print("Digite a terceira carta: ");
        c3 = scan.nextInt();

        jogada();
    }

    public void jogada() {
        if ((c1 == 1 || c1 == 2 || c1 == 3) && (c2 == 1 || c2 == 2 || c2 == 3) && (c3 == 1 || c3 == 2 || c3 == 3)) {
            System.out.println("NOVE");
        } else if ((c1 == 1 || c1 == 2 || c1 == 3) && (c2 == 1 || c2 == 2 || c2 == 3) ||
                (c2 == 1 || c2 == 2 || c2 == 3) && (c3 == 1 || c3 == 2 || c3 == 3) ||
                (c1 == 1 || c1 == 2 || c1 == 3) && (c3 == 1 || c3 == 2 || c3 == 3)) {
            System.out.println("SEIS");
        } else if ((c1 == 1 || c1 == 2 || c1 == 3) || (c2 == 1 || c2 == 2 || c2 == 3)
                || (c3 == 1 || c3 == 2 || c3 == 3)) {
            System.out.println("TRUCO");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe13();
    }

}
