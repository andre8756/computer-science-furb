package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe19 {
    Scanner scan = new Scanner(System.in);
    int x, y;

    public Uni4Exe19() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite o valor X: ");
        x = scan.nextInt();
        System.out.print("Digite o valor y: ");
        y = scan.nextInt();

        calcularQuadrante();
    }

    public void calcularQuadrante() {
        if (x == 0 && y == 0) {
            System.out.println("Quadrante 0");
        } else if (x > 0 && y > 0) {
            System.out.println("Quadrante 1");
        } else if (x > 0 && y < 0) {
            System.out.println("Quadrante 2");
        } else if (x < 0 && y < 0) {
            System.out.println("Quadrante 3");
        } else {
            System.out.println("Quadrante 4");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe19();
    }

}
