package Unidade5.Exercicios;

import java.util.Scanner;

public class Uni5Exe05 {
    public static void main(String[] args) {
        // 10x = 258
        Scanner scan = new Scanner(System.in);
        int n1;
        int resultado = 0;

        System.out.print("Digite o n: ");
        n1 = scan.nextInt();

        for (int i = 1; i <= n1; i++) {

            if (i == 1) {
                resultado = 8;
            }
            System.out.print(resultado + " ");

            if (i % 2 == 0) {
                resultado = (resultado - 2) * 2;
            } else {
                resultado = resultado + 2;
            }

        }
    }
}
