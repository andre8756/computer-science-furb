

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();

        System.out.print("Digite o número da primeira conta bancária: ");
        conta1.setNumero(scan.next());
        System.out.print("Digite o titular da primeira conta bancária: ");
        conta1.setTitular(scan.next());

        System.out.println();

        System.out.print("Digite o número da segunda conta bancária: ");
        conta2.setNumero(scan.next());
        System.out.print("Digite o titular da segunda conta bancária: ");
        conta2.setTitular(scan.next());

        System.out.println();

        conta1.depositar(1000);
        conta1.depositar(700);
        conta2.depositar(5000);
        conta2.depositar(5000);
        conta2.sacar(3000);
        conta2.transferir(conta1, 1800);

        System.out.println();
        System.out.println(" -- Titular: "+conta1.getTitular());
        System.out.printf("Saldo atual: %.2f\n", conta1.getSaldo());

        System.out.println();
        System.out.println(" -- Titular: "+conta2.getTitular());
        System.out.printf("Saldo atual: %.2f", conta2.getSaldo());
    }
}
