package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe06 {
    Scanner scan = new Scanner(System.in);
    private char letra;

    public Uni4Exe06() {
        iniciar();
    }

    public void iniciar() {
        System.out.println("Digite o caracter desejado: \n" +
                "  m - Masculino\n" +
                "  f - Feminino\n" +
                "  i - Não informado");
        letra = scan.next().toUpperCase().charAt(0);
        identificar();
    }

    public void identificar() {
        if (letra == 'M') {
            System.out.println("Masculino");
        } else if (letra == 'F') {
            System.out.println("Feminino");
        } else if (letra == 'I') {
            System.out.println("Não informado");
        } else {
            System.out.println("Entrada Incorreta");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe06();
    }
}
