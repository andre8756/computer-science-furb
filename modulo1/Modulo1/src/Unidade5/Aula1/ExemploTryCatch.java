package Unidade5.Aula1;

import java.util.Scanner;

public class ExemploTryCatch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numero = 0;
        try {
            System.out.println("Digite um númer");
            numero = scan.nextInt();
        } catch (Exception exception) {
            System.out.println("Número inválido");
            System.out.println(exception.getMessage());
        }

    }
}
