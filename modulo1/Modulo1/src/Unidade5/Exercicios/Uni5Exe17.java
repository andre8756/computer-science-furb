package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inscricao = 1;
        float altura = 0;
        float alturaMaior = (float) Double.MIN_VALUE;
        float alturaMenor = (float) Double.MAX_VALUE;
        float mediaAltura = 0;
        int inscricaoMaior = 0;
        int inscricaoMenor = 0;
        int qntInscricao = 0;

        try {
            while (inscricao != 0) {
                System.out.print("N° de inscrição: ");
                inscricao = scan.nextInt();

                if (inscricao == 0) {
                    break;
                }

                System.out.print("Altura: ");
                altura = scan.nextFloat();

                if (altura > alturaMaior) {
                    alturaMaior = altura;
                    inscricaoMaior = inscricao;
                }

                if (altura < alturaMenor) {
                    alturaMenor = altura;
                    inscricaoMenor = inscricao;
                }

                mediaAltura += altura;
                qntInscricao++;

            }

            System.out.printf("O atleta mais baixo tem %.2fm e o seu número de inscrição é %d \n", alturaMenor,
                    inscricaoMenor);
            System.out.printf("O atleta mais alto tem %.2f e o seu número de inscrição é %d \n", alturaMaior,
                    inscricaoMaior);
            System.out.printf("A altura média do grupo de atletas é: %.2f \n", (mediaAltura / qntInscricao));

        } catch (Exception ex) {
            System.out.println("deu errado");
        }

    }
}
