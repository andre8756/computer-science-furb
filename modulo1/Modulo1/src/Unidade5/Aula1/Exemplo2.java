package Unidade5.Aula1;

import java.util.Scanner;

public class Exemplo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i <= 10; i++) {
            String nome = scan.next();
            int idade = scan.nextInt();
            System.out.println(nome + idade);
        }
    }
}
