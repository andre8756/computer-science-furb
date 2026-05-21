package Unidade6.Aula1;

import java.util.ArrayList;
import java.util.Scanner;

public class ExemploLista {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Andre");
        nomes.add("Camille");
        nomes.add("Godofredo");
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um nome: ");
            nomes.add(scan.next());
        }

    }
}
