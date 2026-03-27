package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe09 {
    Scanner scan = new Scanner(System.in);
    private int n1, n2;

    public Uni4Exe09() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite o primeiro valor: ");
        n1 = scan.nextInt();
        System.out.print("Digite o segundo valor: ");
        n2 = scan.nextInt();

        if (isMultiplo()) {
            System.out.println("O valores são múltiplos.");
        } else {
            System.out.println("Os valores não são múltiplos.");
        }
    }

    public boolean isMultiplo() {
        if (n1 % n2 == 0 || n2 % n1 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Uni4Exe09();
    }
}
