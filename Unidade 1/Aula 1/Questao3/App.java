package Questao3;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            System.out.print("Digite o peso: ");
            pessoa1.peso = scan.nextDouble();
            System.out.print("Digite a altura: ");
            pessoa1.altura = scan.nextDouble();

            System.out.printf("IMC da pessoa: %.2f",pessoa1.calcularImc());
            System.out.println();
        }

        
    }
}
