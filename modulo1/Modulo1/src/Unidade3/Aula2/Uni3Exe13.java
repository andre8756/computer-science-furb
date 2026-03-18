package Unidade3.Aula2;

import java.nio.file.SecureDirectoryStream;
import java.util.Scanner;

public class Uni3Exe13 {

    private float altura;
    private float comprimento;

    private float valorUnidade = 12.5f;

    public Uni3Exe13() {
    }

    public Uni3Exe13(float altura, float comprimento) {
        this.altura = altura;
        this.comprimento = comprimento;
    }

    public float calcularPreco() {
        return ((altura * comprimento) * 9) * valorUnidade;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Altura: ");
        float altura = scan.nextFloat();
        System.out.print("Comprimento: ");
        float comprimento = scan.nextFloat();

        Uni3Exe13 loja = new Uni3Exe13(altura, comprimento);
        System.out.printf("O valor final é R$ %.2f", loja.calcularPreco());

        scan.close();
    }
}
