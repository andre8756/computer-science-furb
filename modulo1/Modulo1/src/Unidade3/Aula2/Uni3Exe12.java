package Unidade3.Aula2;

import java.util.Scanner;

public class Uni3Exe12 {
    private String nome;
    private float horasTrabalhadasMes;
    private int dependentes;

    private float valorHora = 10;
    private float valorDependente = 60;
    private float taxas = 0.05f + 0.085f;

    public Uni3Exe12() {
    }

    public Uni3Exe12(String nome, float horasTrabalhadasMes, int dependentes) {
        this.nome = nome;
        this.horasTrabalhadasMes = horasTrabalhadasMes;
        this.dependentes = dependentes;
    }

    public String getNome() {
        return nome;
    }

    public float salarioTrabalho() {
        return horasTrabalhadasMes * valorHora;
    }

    public float salarioFamilia() {
        return dependentes * valorDependente;
    }

    public float salarioBruto() {
        return salarioTrabalho() + salarioFamilia();
    }

    public float salarioLiquido() {
        return salarioBruto() - (salarioTrabalho() * taxas);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Quantidade de horas trabalhadas no mês: ");
        Float horasMes = scan.nextFloat();
        System.out.print("Nome: ");
        int dependentes = scan.nextInt();

        Uni3Exe12 empresa = new Uni3Exe12(nome, horasMes, dependentes);
        System.out.printf("O funcionário João possui um salário bruto de R$ %.2f e um salário líquido de R$ %.2f",
                empresa.salarioBruto(), empresa.salarioLiquido());
        scan.close();
    }

}
