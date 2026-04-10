package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe21 {
    Scanner scan = new Scanner(System.in);
    double altura, massa, imc;

    public Uni4Exe21() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Altura: ");
        altura = scan.nextFloat();
        System.out.print("Massa: ");
        massa = scan.nextFloat();

        calcularIMC();
    }

    public void calcularIMC() {
        imc = massa / Math.pow(2, altura);

        if (imc < 18.5) {
            System.out.println("Magreza");
        } else if (imc < 25) {
            System.out.println("Saudável");
        } else if (imc < 35) {
            System.out.println("Obesidade Grau I");
        } else if (imc < 40) {
            System.out.println("Obesidade Grau II");
        } else {
            System.out.println("Obesidade Grau III");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe21();
    }
}
