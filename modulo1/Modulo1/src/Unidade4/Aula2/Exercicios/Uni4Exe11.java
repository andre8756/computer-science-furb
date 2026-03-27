package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe11 {
    Scanner scan = new Scanner(System.in);
    int idade1, idade2, idade3;

    public Uni4Exe11() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite a primeira idade: ");
        idade1 = scan.nextInt();
        System.out.print("Digite a segunda idade: ");
        idade2 = scan.nextInt();
        System.out.print("Digite a terceira idade: ");
        idade3 = scan.nextInt();

        compararIdades();
    }

    public void compararIdades() {
        if (idade1 == idade2 && idade1 == idade3) {
            System.out.println("TRIGÊMEOS");
        } else if (idade1 == idade2 || idade2 == idade3 || idade1 == idade3) {
            System.out.println("GÊMEOS");
        } else {
            System.out.println("APENAS IRMÃOS");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe11();
    }
}
