package Aula4.Exercicios;

import java.util.Scanner;

public class Uni2Exe10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int valor, horas, minutos, segundos, resto;

        System.out.print("Digite um valor em segundos: ");
        valor = scan.nextInt();

        horas = valor / 3600;
        resto = valor - horas * 3600;
        minutos = resto / 60;
        segundos = resto - minutos * 60;

        System.out.printf("Valor formatado em horas: %02d/%02d/%02d", horas, minutos, segundos);

        scan.close();
    }
}
