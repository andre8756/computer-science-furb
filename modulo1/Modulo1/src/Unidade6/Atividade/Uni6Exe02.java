package Unidade6.Atividade;

import java.util.Scanner;

public class Uni6Exe02 {
    Scanner scan = new Scanner(System.in);
    int tamanho;
    float[] array;
    float soma = 0;
    float media;

    public Uni6Exe02(int tamanho) {
        this.tamanho = tamanho;
        array = new float[tamanho];
    }

    public void ler() {
        for (int i = 0; i < (tamanho); i++) {
            System.out.println("Digite o " + (i + 1) + " número: ");
            array[i] = scan.nextFloat();
        }
    }

    public void media() {
        for (int i = 0; i < (tamanho); i++) {
            soma += array[i];
        }

        media = soma / tamanho;
    }

    public void escrever() {
        for (int i = 0; i < (tamanho); i++) {
            if (array[i] > media) {
                System.out.printf("%.2f é maior que a média", array[i]);
            }
        }
    }

    public static void main(String[] args) {
        Uni6Exe02 exe02 = new Uni6Exe02(12);
        exe02.ler();
        exe02.media();
        exe02.escrever();

    }

}
