package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe20 {
    Scanner scan = new Scanner(System.in);
    float n1, n2, n3, exercicios, media;

    public void iniciar() {
        System.out.println("Digite a primeira nota: ");
        n1 = scan.nextFloat();
        System.out.println("Digite a segunda nota: ");
        n2 = scan.nextFloat();
        System.out.println("Digite a terceira nota: ");
        n3 = scan.nextFloat();
        System.out.println("Digite a media dos exercicios: ");
        exercicios = scan.nextFloat();

    }

    public void calcularMedia() {
        media = (n1 + n2 * 2 + n3 * 3 + exercicios) / 7;
    }
}
