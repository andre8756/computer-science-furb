package Unidade6.Atividade;

import java.util.Scanner;

public class Uni6Exe03 {
    public int tamanho = 12;
    public double[] valores = new double[tamanho];
    public Scanner scan = new Scanner(System.in);

    public Uni6Exe03() {

    }

    public void ler() {
        for (int i = 0; i < (tamanho); i++) {
            System.out.println("Digite o " + (i + 1) + " número: ");
            valores[i] = scan.nextFloat();
        }
    }

    public void alterarValores() {
        for (int i = 0; i < tamanho; i++) {
            if (i % 2 == 0) {
                valores[i] *= 1.02;
            } else {
                valores[i] *= 1.05;
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + " valor: " + valores[i]);
        }
    }

    public static void main(String[] args) {
        Uni6Exe03 exe03 = new Uni6Exe03();
        exe03.ler();
        exe03.alterarValores();
        exe03.imprimir();
    }

}
