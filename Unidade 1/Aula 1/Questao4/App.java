package Questao4;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Scanner scan = new Scanner(System.in);

        Pessoa array[] = new Pessoa[3];

        for(int i = 0; i < array.length; i++){
            array[i] = new Pessoa();

            System.out.print(" -- Preencher informaçoes da pessoa "+(i+1)+": ");
            System.out.print("Digite o nome da Pessoa "+(i+1)+": ");
            array[i].nome = scan.next();
            System.out.print("Digite o peso da Pessoa: "+(i+1)+": ");
            array[i].peso = scan.nextDouble();
            System.out.print("Digite a altura da Pessoa: "+(i+1)+": ");
            array[i].altura = scan.nextDouble();
        }

        System.out.println();

        for(int i = 3; i > 0; i--){
            System.out.println(" -- Dados da pessoa: "+(i));
            array[i-1].exibirPessoa();
            System.out.println();
        }

        
    }
}
