package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float n1, n2, media;

        // 3.5
        System.out.print("Digite o primeiro número: ");
        n1 = scan.nextFloat();

        // 7.5
        System.out.print("Digite o segundo número: ");
        n2 = scan.nextFloat();
        media = ((n1 * 3.5f) + (n2 * 7.5f)) / 11;

        System.out.println(media);
        scan.close();
    }
}
