import java.util.Scanner;

public class Uni2Exe17{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome;
        float horasTrabalhadas, salarioTrabalho, salarioFamilia, salarioBruto, salarioLiquido;
        int numeroDependentes;
        double taxas = 0.085 + 0.05;

        System.out.print("Digite o nome do funcionário: ");
        nome = scan.nextLine();
        System.out.print("Digite o total de horas trabalhadas pelo funcionário: ");
        horasTrabalhadas = scan.nextFloat();
        System.out.print("Digite o número de dependentes do funcionário: ");
        numeroDependentes = scan.nextInt();

        salarioTrabalho = 10*horasTrabalhadas;
        salarioFamilia = 60*numeroDependentes;
        salarioBruto = salarioTrabalho+salarioFamilia;
        salarioLiquido = salarioBruto - (float) (salarioTrabalho*taxas);

        System.out.println("Dados do funcionário "+nome+": ");
        System.out.printf("Salário Bruto: R$%.2f%n", salarioBruto);
        System.out.printf("Salário Líquido: R$%.2f", salarioLiquido);
        

        scan.close();
    }
}