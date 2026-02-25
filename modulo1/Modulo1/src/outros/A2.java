package outros;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma String: ");
        String tentativa = scan.next();

        while (!tentativa.equals("teste")) {
            System.out.println("você errou!! Tente de novo.");
            tentativa = scan.next();
        }

        System.out.println("Você acertouu!!");

    }
}
