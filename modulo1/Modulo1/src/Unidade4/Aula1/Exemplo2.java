package Unidade4.Aula1;

import java.util.Scanner;

public class Exemplo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean doador = false;
        boolean estudante = false;

        System.out.print("Informe a sua idade: ");
        int idade = scan.nextInt();
        System.out.print("Você é doador se sangue?(s/n) ");
        String respostaDoador = scan.next();
        System.out.print("Você é estudante?(s/n) ");
        String respostaEstudante = scan.next();

        if (respostaDoador.equalsIgnoreCase("s") || respostaDoador.equalsIgnoreCase("sim")) {
            doador = true;
        }
        if (respostaEstudante.equalsIgnoreCase("s") || respostaEstudante.equalsIgnoreCase("sim")) {
            estudante = true;
        }

        if (idade < 18 || idade >= 60 || doador || estudante) {
            System.out.println("Meia entrada!");
        } else {
            System.out.println("Entrada cheia!");
        }

    }
}
