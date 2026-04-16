package prova2;

import java.util.Scanner;

public class Questao4 {
    Scanner scan = new Scanner(System.in);
    float nota1, nota2, media;

    public Questao4() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite a nota 1: ");
        nota1 = scan.nextFloat();
        System.out.print("Digite a nota 2: ");
        nota2 = scan.nextFloat();

        calcularMedia();
    }

    public void calcularMedia() {
        media = (nota1 + nota2) / 2;

        if (nota1 >= 9 || nota2 >= 9) {
            media += 0.5f;
        }

        if (media > 10) {
            media = 10;
        }

        System.out.print("Situação final do aluno: ");

        if (media >= 7) {
            System.out.println("Aprovado");
        } else if (media >= 5) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }

    public static void main(String[] args) {
        new Questao4();
    }
}
