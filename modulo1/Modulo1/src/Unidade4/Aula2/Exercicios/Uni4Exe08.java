package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe08 {
    Scanner scan = new Scanner(System.in);
    private char letra;

    public Uni4Exe08() {
        iniciar();
    }

    public void iniciar() {
        System.out.println("Informe a letra:");
        letra = scan.next().toLowerCase().charAt(0);
        if (isVogal()) {
            System.out.println("É vogal");
        } else {
            System.out.println("Não é vogal");
        }
    }

    public boolean isVogal() {
        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Uni4Exe08();
    }
}
