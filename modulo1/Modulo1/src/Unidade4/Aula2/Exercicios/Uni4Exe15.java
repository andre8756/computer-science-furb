package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe15 {
    Scanner scan = new Scanner(System.in);
    int meses;

    public Uni4Exe15() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Número de meses que o funcionário foi admitido: ");
        meses = scan.nextInt();
        calcularReajuste();
    }

    public void calcularReajuste() {
        if (meses > 48) {
            System.out.println("Reajuste não informado");
        } else if (meses > 12) {
            System.out.println("O funcionário irá receber 7% de reajuste");
        } else {
            System.out.println("O funcionário irá receber 5% de reajuste");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe15();
    }
}
