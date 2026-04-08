package Unidade4.Aula2.Exercicios;

import java.util.Scanner;

public class Uni4Exe18 {
    Scanner scan = new Scanner(System.in);
    int vencimento, pagamento;
    float prestacao, valor;

    public Uni4Exe18() {
        iniciar();
    }

    public void iniciar() {
        System.out.print("Dia do vencimento: ");
        vencimento = scan.nextInt();
        System.out.print("Dia do pagemto: ");
        pagamento = scan.nextInt();
        System.out.print("Valor da prestação: ");
        prestacao = scan.nextFloat();

        calculaValor();
    }

    public void calculaValor() {
        if (pagamento <= vencimento) {
            valor = prestacao - (prestacao * 0.1f);
            System.out.printf("O pagamento está em dia. O valor da prestação = R$ %.2f \n", valor);
        } else if (vencimento <= (pagamento + 5)) {
            valor = prestacao;
            System.out.printf("O pagamento está até 5 dias atrasado. O valor da prestação = R$ %.2f \n", valor);
        } else {
            valor = prestacao * ((pagamento - vencimento) * 0.2f);
            System.out.printf("O pagamento está atrasado. O valor da prestação = R$ %.2f \n", valor);
        }
    }

    public static void main(String[] args) {
        new Uni4Exe18();
    }

}
