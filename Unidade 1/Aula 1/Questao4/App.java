package Questao4;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Scanner scan = new Scanner(System.in);

        Pessoa array[] = new Pessoa[3];

        for(int i = 0; i < 3; i++){
            array[i] = new Pessoa();
        }

        for(int i = 0; i < 3; i++){
            System.out.print("Digite o nome da Pessoa "+(i+1)+": ");
            array[i].nome = scan.next();
            System.out.print("Digite o peso da Pessoa: "+(i+1)+": ");
            array[i].peso = scan.nextDouble();
            System.out.print("Digite a altura da Pessoa: "+(i+1)+": ");
            array[i].altura = scan.nextDouble();
        }

        for(int i = 3; i > 0; i--){
            System.out.println(" --Dados da pessoa: "+(i));
            System.out.printf("Nome: %s\n", array[i-1].nome );
            System.out.printf("Peso: %.2f\n", array[i-1].peso);
            System.out.printf("Altura: %.2f\n", array[i-1].altura );
            System.out.printf("IMC: %.2f\n", array[i-1].calcularImc());
        }

        
    }
}
