package prova2;

import java.util.Scanner;

public class Questao1 {
    private Scanner scan = new Scanner(System.in);
    private int idade, frequenciaCardiaca;

    public Questao1() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite a idade do aluno: ");
        idade = scan.nextInt();
        System.out.print("Digite a frequência cardíaca: ");
        frequenciaCardiaca = scan.nextInt();

        medidorCardiaco();
    }

    public void medidorCardiaco() {
        if (idade >= 60 && frequenciaCardiaca >= 140) {
            System.out.println("Alerta máximo");
        } else if (frequenciaCardiaca >= 180) {
            System.out.println("Esforço crítico");
        } else if (frequenciaCardiaca >= 140) {
            System.out.println("Esforço alto");
        } else {
            System.out.println("Esforço normal");
        }
    }

    public static void main(String[] args) {
        new Questao1();
    }
}
