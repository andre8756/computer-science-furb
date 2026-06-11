package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe26 {
    Scanner scan = new Scanner(System.in);
    char opcao;
    float n1, n2;

    public Uni4Exe26(){
        iniciar();
    }

    public void iniciar() {
        System.out.println("Escolha uma opção");
        System.out.println("T: calcular a área de um triângulo de base b e a altura h");
        System.out.println("Q: calcular a área de um quadrado de lado l");
        System.out.println("R: calcular a área de um retângulo de base b e altura h");
        System.out.println("C: calcular a área de um círculo de raio r");
        System.out.println();
        System.out.print(">> ");
        opcao = scan.next().toUpperCase().charAt(0);

        comparacao();
    }

    public void comparacao(){
        switch (opcao) {
            case 'T':
                calcularAreaTriangulo();
                break;

            case 'Q':
                calcularAreaQuadrado();
                break;

            case 'R':
                calcularAreaRetangulo();
                break; 

            case 'C':
                calcularAreaCirculo();
                break;

            default:
                System.out.println("Opção inválida!");
                break;
                
        }
    }

    public void calcularAreaTriangulo(){
        System.out.print("Digite a base do triângulo: ");
        n1 = scan.nextFloat();
        System.out.print("Digite a altura do trinângulo: ");
        n2 = scan.nextFloat();

        System.out.println("A área do triângulo é "+(n1 * n2 / 2));
    }

    public void calcularAreaQuadrado(){
        System.out.print("Digite o lado: ");
        n1 = scan.nextFloat();

        System.out.println("Área do quadrado: "+(n1*n1));
    }

    public void calcularAreaRetangulo(){
        System.out.print("Digite a base do retângulo: ");
        n1 = scan.nextFloat();
        System.out.print("Digite a altura do retângulo: ");
        n2 = scan.nextFloat();

        System.out.println("Área do retângulo: "+(n1*n2));
    }

    public void calcularAreaCirculo(){
        System.out.print("Digite o raio: ");
        n1 = scan.nextFloat();

        System.out.println("Area do circulo: "+(Math.PI * Math.pow(n1, 2)));
    }

    public static void main(String[] args) {
        new Uni4Exe26();
    }

}
