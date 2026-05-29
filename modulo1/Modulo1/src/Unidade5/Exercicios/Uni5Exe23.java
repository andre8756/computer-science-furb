import java.util.Scanner;

public class Uni5Exe23 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char continuar = 's';

        while (continuar != 'n') {

            System.out.print("Nome do vendedor: ");
            String nome = scan.nextLine();

            System.out.print("Quantidade de produtos vendidos: ");
            int n = scan.nextInt();

            int contador = 1;
            double totalVendas = 0;

            while (contador <= n) {

                System.out.print("Preço do produto: ");
                double preco = scan.nextDouble();

                System.out.print("Quantidade vendida: ");
                int quantidade = scan.nextInt();

                totalVendas = totalVendas + (preco * quantidade);

                contador++;
            }

            double salario = totalVendas * 0.30;

            System.out.println("Nome: " + nome);
            System.out.println("Total de vendas: R$ " + totalVendas);
            System.out.println("Salário: R$ " + salario);

            scan.nextLine();

            System.out.print("Deseja digitar os dados de mais um vendedor: s/n? ");
            continuar = scan.nextLine().toLowerCase().charAt(0);
        }

        scan.close();
    }
}