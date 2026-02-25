package outros;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Estudando sobre armazenamento de variáveis na memória
        System.out.println("Digite uma String: ");
        String tentativa = scan.next();

        String a = "aasdf";
        System.out.println("Digite o B: ");
        String b = scan.next();

        if (a == b) {
            System.out.println("a é igual a b");
        } else {
            System.out.println("o B está errado!!");
        }

        while (tentativa == "teste") {
            System.out.println("você errou!! Tente de novo.");
            tentativa = scan.next();
        }

        System.out.println("Você acertouu!!");

    }
}
