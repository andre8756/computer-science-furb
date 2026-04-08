package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe14 {
    Scanner scan = new Scanner(System.in);
    int dia, mes, ano;

    public Uni4Exe14() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Digite o dia: ");
        dia = scan.nextInt();
        System.out.print("Digite o mês: ");
        mes = scan.nextInt();
        System.out.print("Digite o ano: ");
        ano = scan.nextInt();
        validaData();
    }

    public void validaData() {
        if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 0) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                System.out.println("Válida");
            } else if (mes != 2 && dia < 31) {
                System.out.println("válida");
            } else if (mes == 2 && dia < 29) {
                System.out.println("Válida");
            } else if (dia == 29 && (ano % 4) == 0 && !(ano % 100 == 0 && ano % 400 != 0)) {
                System.out.println("Válida");
            } else {
                System.out.println("Não válida");
            }

        } else {
            System.out.println("Não válida");
        }
    }

    public static void main(String[] args) {
        new Uni4Exe14();
    }

}
