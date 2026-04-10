package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe20 {
    Scanner scan = new Scanner(System.in);
    float n1, n2, n3, exercicios, media;

    public Uni4Exe20() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite a primeira nota: ");
        n1 = scan.nextFloat();
        System.out.print("Digite a segunda nota: ");
        n2 = scan.nextFloat();
        System.out.print("Digite a terceira nota: ");
        n3 = scan.nextFloat();
        System.out.print("Digite a media dos exercicios: ");
        exercicios = scan.nextFloat();

        calcularMedia();
    }

    public void calcularMedia() {
        media = (n1 + n2 * 2 + n3 * 3 + exercicios) / 7;

        System.err.printf("A média de aproveitamento foi: ");

        if (media >= 9) {
            System.out.printf("%.2f. Conceito: A. Aprovado", media);
        } else if (media >= 7.5) {
            System.out.printf("%.2f. Conceito: B. Aprovado", media);
        } else if (media >= 6) {
            System.out.printf("%.2f. Conceito: C. Aprovado", media);
        } else if (media >= 4) {
            System.out.printf("%.2f. Conceito: D. Reprovado", media);
        } else {
            System.out.printf("%.2f. Conceito: E. Reprovado", media);
        }
    }

    public static void main(String[] args) {
        new Uni4Exe20();
    }
}
