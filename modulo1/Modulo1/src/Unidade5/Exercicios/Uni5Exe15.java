package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome = "";
        float n1, n2;

        while (!nome.equals("fim")) {
            System.out.print("Nome: ");
            nome = scan.next();
            System.out.print("Nota 1: ");
            n1 = scan.nextFloat();
            System.out.print("Nota 2: ");
            n2 = scan.nextFloat();

            System.out.printf("A média do(a) %s é %.2f \n", nome, ((n1 + n2) / 2));
        }
    }
}
