package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe01 {
    private float horasTrabalhadas, valorHora, salario, salarioExtra;
    Scanner scan = new Scanner(System.in);

    public Uni4Exe01() {
        iniciar();
    }

    public void getSalario() {
        salario = horasTrabalhadas * valorHora;

        if (salario > 160) {
            salarioExtra = (horasTrabalhadas - 160) * (valorHora / 2);
            salario = salario + salarioExtra;
        }
    }

    public void iniciar() {
        System.out.print("Entre com as horas trabalhadas no mês: ");
        horasTrabalhadas = scan.nextFloat();
        System.out.print("Entre com o valor pago por hora: ");
        valorHora = scan.nextFloat();

        getSalario();

        System.out.printf("O salário total é: R$ %.2f", salario);
    }

    public static void main(String[] args) {
        new Uni4Exe01();
    }

}
