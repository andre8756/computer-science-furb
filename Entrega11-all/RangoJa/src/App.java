
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Cardápio com ao menos um item de cada tipo.
        List<ItemCardapio> cardapio = new ArrayList<>();
        Prato xisSalada = new Prato("Xis Salada", 30.00, 'M');
        Bebida refri = new Bebida("Refri", 6.00, 350, false);
        Bebida chopp = new Bebida("Chopp", 12.00, 500, true);
        Sobremesa pudim = new Sobremesa("Pudim", 8.00, 150);
        cardapio.add(xisSalada);
        cardapio.add(refri);
        cardapio.add(chopp);
        cardapio.add(pudim);

        System.out.println("=== Cardápio RangoJá ===");
        for (ItemCardapio item : cardapio) {
            System.out.println(item);
        }

        // 2. Cadastro e indicação.
        Cliente ana = new Cliente("Ana Souza", "ana@furb.br", 20);
        Cliente beto = new Cliente("Beto Silva", "beto@furb.br", 17, ana);
        System.out.println(String.format(Locale.forLanguageTag("pt-BR"),
                "\nCashback inicial da Ana: R$ %.2f", ana.getSaldoCashback()));

        CentralCobranca central = new CentralCobranca();
        List<Pedido> pedidos = new ArrayList<>();

        // 3. Pedido do Beto e leitura com repetição até uma quantidade válida.
        Pedido pedidoBeto = new Pedido(beto);
        pedidos.add(pedidoBeto);
        int quantidade = lerQuantidadePositiva(scanner);
        try {
            pedidoBeto.adicionarItem(xisSalada, quantidade);
            System.out.println("Itens adicionados ao pedido do Beto.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível adicionar os itens ao pedido do Beto: " + e.getMessage());
        }

        // 4. O pedido de bebida alcoólica do Beto deve ser recusado.
        try {
            pedidoBeto.adicionarItem(chopp);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar o chopp ao pedido do Beto: " + e.getMessage());
        }

        // Finaliza o pedido do Beto para que ele possa ser registrado na central.
        try {
            pedidoBeto.finalizar();
            System.out.println("Pedido do Beto finalizado. Total: " + pedidoBeto.gerarComprovante());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Não foi possível finalizar o pedido do Beto: " + e.getMessage());
        }

        // 5. Adicionar os itens e finalizar o pedido da Ana no mesmo try (multi-catch).
        Pedido pedidoAna = new Pedido(ana);
        pedidos.add(pedidoAna);
        try {
            pedidoAna.adicionarItem(xisSalada);
            pedidoAna.adicionarItem(refri);
            pedidoAna.adicionarItem(pudim);
            pedidoAna.finalizar();
            System.out.println("Pedido da Ana finalizado. " + pedidoAna.gerarComprovante());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Não foi possível concluir o pedido da Ana: " + e.getMessage());
        }

        try {
            pedidoAna.finalizar();
        } catch (IllegalStateException e) {
            System.out.println("Nova tentativa de finalização: " + e.getMessage());
        }

        // 6. Tentar usar mais cashback do que a Ana possui; finally sempre mostra o saldo.
        try {
            ana.usarCashback(ana.getSaldoCashback() + 5.00);
            System.out.println("Cashback utilizado com sucesso.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não foi possível usar o cashback: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Valor de cashback inválido: " + e.getMessage());
        } finally {
            System.out.println(String.format(Locale.forLanguageTag("pt-BR"),
                    "Saldo atual de cashback da Ana: R$ %.2f", ana.getSaldoCashback()));
        }

        // Demonstração explícita de tratamento de exceção em setters definidos pelo diagrama.
        try {
            ana.setIdade(121);
        } catch (IllegalArgumentException e) {
            System.out.println("Idade não alterada: " + e.getMessage());
        }
        try {
            xisSalada.setPrecoBase(0.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Preço base não alterado: " + e.getMessage());
        }

        // 7. Assinatura e cobranças dos pedidos finalizados.
        AssinaturaClube assinatura = new AssinaturaClube(ana, 19.90, 12);
        central.registrar(assinatura);
        for (Pedido pedido : pedidos) {
            if (pedido.isFinalizado()) {
                central.registrar(pedido);
            }
        }

        System.out.println("\n=== Relatório de cobranças ===");
        System.out.println(central.gerarRelatorio());
        scanner.close();
    }

    private static int lerQuantidadePositiva(Scanner scanner) {
        while (true) {
            System.out.print("Digite a quantidade de Xis Salada para o pedido do Beto: ");
            String entrada = scanner.nextLine();
            try {
                int quantidade = Integer.parseInt(entrada.trim());
                if (quantidade < 1) {
                    System.out.println("A quantidade deve ser pelo menos 1. Tente novamente.");
                    continue;
                }
                return quantidade;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: digite um número inteiro. Tente novamente.");
            }
        }
    }
}
