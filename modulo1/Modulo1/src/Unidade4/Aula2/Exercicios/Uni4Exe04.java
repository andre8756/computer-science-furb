package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe04 {
    Scanner scan = new Scanner(System.in);

    private float n1;

    public Uni4Exe04() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite um número: ");
        n1 = scan.nextFloat();
        if (isFloat()) {
            System.out.println("Casas decimais foram digitadas.");
        } else {
            System.out.println("Casas decimais não foram digitadas.");
        }
    }

    public boolean isFloat() {
        if ((int) n1 == n1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Uni4Exe04();
    }
}
