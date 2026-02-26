package outros;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Estudando sobre armazenamento de variáveis na memória

        // Estudo básico com uma letra
        String a = "abc";
        System.out.println("Digite o B: ");
        String b = scan.next();
        String x = "abc";

        if (a == b) {
            System.out.println("a é igual a b");
        } else if (a == x) {
            System.out.println("X é a A");
        } else {
            System.out.println("A, B e X são diferentes");
        }

        // Dois espaços na memório diferentes
        String c = new String("outro");
        String d = new String("outro");

        if (c == d) {
            System.out.println("a é igual a b");
        } else {
            System.out.println("o B está errado!!");
        }

        // While com comparacao de memoria
        System.out.println("Digite uma String: ");
        String tentativa = scan.next();

        while (tentativa.equals("teste")) {
            System.out.println("você errou!! Tente de novo.");
            tentativa = scan.next();
        }

        System.out.println("Você acertouu!!");

    }
}
