package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe12 {
    Scanner scan = new Scanner(System.in);
    int lado1, lado2, lado3;

    Uni4Exe12() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite o primeiro lado: ");
        lado1 = scan.nextInt();
        System.out.print("Digite o segundo lado: ");
        lado2 = scan.nextInt();
        System.out.print("Digite o terceiro lado: ");
        lado3 = scan.nextInt();
        verificaTriangulo();
    }

    public void verificaTriangulo() {
        if (lado1 == lado2 && lado1 == lado3) {
            System.out.println("É equilátero.");
        } else if (lado2 == lado1 || lado2 == lado3 || lado1 == lado3) {
            System.out.println("É isóceles.");
        } else if ((lado3 + lado2) > lado1 && (lado1 + lado3) > lado2 && (lado1 + lado2) > lado3) {
            System.out.println("É escaleno.");
        } else {
            System.out.println("Não forma um triângulo.");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe12();
    }

}
