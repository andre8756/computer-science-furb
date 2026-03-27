package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe10 {
    Scanner scan = new Scanner(System.in);
    private int idade1, idade2, idade3;

    public Uni4Exe10() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Idade de Marquinhos: ");
        idade1 = scan.nextInt();
        System.out.print("Idade de Zezinho: ");
        idade2 = scan.nextInt();
        System.out.print("Idade de Luluzinha: ");
        idade3 = scan.nextInt();

        compararIdades();
    }

    public void compararIdades() {
        if (idade1 < idade2 && idade1 < idade3) {
            System.out.println("O Marquinhos é o caçula.");
        } else if (idade2 < idade1 && idade2 < idade3) {
            System.out.println("O Zezinho é o caçula.");
        } else {
            System.out.println("A Luluzinha é o caçula.");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe10();
    }
}
