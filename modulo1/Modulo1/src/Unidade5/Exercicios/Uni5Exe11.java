package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = 1;

        for (int i = 1; i <= 16; i++) {
            System.out.println("hora: " + i);
            System.out.println("biscoitos: " + n1);

            n1 *= 3;

        }

    }
}
