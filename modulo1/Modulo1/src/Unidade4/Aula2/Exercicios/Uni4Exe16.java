package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe16 {
    Scanner scan = new Scanner(System.in);
    int idadeH1, idadeH2, idadeM1, idadeM2;

    public Uni4Exe16() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Idade do primeiro homem: ");
        idadeH1 = scan.nextInt();
        System.out.print("Idade do segundo homem: ");
        idadeH2 = scan.nextInt();
        System.out.print("Idade da primeira mulher: ");
        idadeM1 = scan.nextInt();
        System.out.print("Idade da segunda mulher: ");
        idadeM2 = scan.nextInt();

        calcularIdades();
    }

    public void calcularIdades() {
        System.out.printf("A soma é %s e o ", (Math.max(idadeH2, idadeH1) + Math.min(idadeM2, idadeM1)));
        System.out.printf("produto é %s", (Math.max(idadeM2, idadeM1) * Math.min(idadeH2, idadeH1)));
    }

    public static void main(String[] args) {
        new Uni4Exe16();
    }
}
