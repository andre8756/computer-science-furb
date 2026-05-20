package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float altura = 1;
        char genero;
        float alturaGrupoMulheres = 0;
        float alturaGeral = 0;
        int qntMulheres = 0;
        int qntGrupo = 0;

        try {
            while (altura > 0) {

                System.out.print("Atura: ");
                altura = scan.nextFloat();

                if (altura <= 0) {
                    break;
                }

                System.out.print("Gênero: ");
                genero = scan.next().toUpperCase().charAt(0);

                if (genero == 'F') {
                    alturaGrupoMulheres += altura;
                    qntMulheres++;
                }

                alturaGeral += altura;
                qntGrupo += altura;
            }

            System.out.printf("A média da altura das mulheres é: %.2f \n", (alturaGrupoMulheres / qntMulheres));
            System.out.printf("A média da altura do grupo é: %.2f \n", (alturaGeral / qntGrupo));

        } catch (Exception ex) {
            System.out.println("Algo deu errado :/");
        }

    }
}
