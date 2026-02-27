package Aula3;

import java.util.Scanner;

public class MediaPonderada {
    public static void main(String[] args) {

        float prova1 = 0;
        float prova2 = 0;
        float trabalhoFinal = 0;

        float mediaDosTrabalhos = 0;

        float exercicioUnidade1 = 0;
        float exercicioUnidade2 = 0;
        float exercicioUnidade3 = 0;
        float exercicioUnidade4 = 0;
        float exercicioUnidade5 = 0;
        float exercicioUnidade6 = 0;
        float exercicioUnidade7 = 0;

        float mediaFinalPonderada = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a nota da prova 1: ");
        prova1 = scan.nextFloat();

        System.out.print("Digite a nota da prova 2: ");
        prova2 = scan.nextFloat();

        System.out.print("Digite a nota do trabalho final: ");
        trabalhoFinal = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 1: ");
        exercicioUnidade1 = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 2: ");
        exercicioUnidade2 = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 3: ");
        exercicioUnidade3 = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 4: ");
        exercicioUnidade4 = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 5: ");
        exercicioUnidade5 = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 6: ");
        exercicioUnidade6 = scan.nextFloat();

        System.out.print("Digite a nota do exercicio 7: ");
        exercicioUnidade7 = scan.nextFloat();

        mediaDosTrabalhos = (exercicioUnidade1 + exercicioUnidade2 + exercicioUnidade3 + exercicioUnidade4
                + exercicioUnidade5
                + exercicioUnidade6 + exercicioUnidade7) / 7;

        float mediaFinal = ((mediaDosTrabalhos * 0.2f) +
                (prova1 * 0.2f) +
                (prova2 * 0.3f) +
                (trabalhoFinal * 0.3f));

        System.out.println(mediaFinal);

        System.out.printf("Media final do Aluno é: %.2f%n", mediaFinal);

        if (mediaFinal < 6) {
            System.out.println("O Aluno(a) está reprovado(a)");
        } else {
            System.out.print("O Aluno(a) esta aprovado(a)");
        }

        scan.close();

    }

}
