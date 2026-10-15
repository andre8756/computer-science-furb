

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Cobravel {
    public static final double TAXA_ENTREGA = 7.0;
    public static final double VALOR_FRETE_GRATIS = 100.0;
    private static int proximoNumero = 1;

    private int numero;
    private boolean finalizado;
    private Cliente cliente;
    private List<ItemCardapio> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O pedido precisa ter um cliente.");
        }
        this.cliente = cliente;
        this.numero = proximoNumero++;
        this.finalizado = false;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void adicionarItem(ItemCardapio item) {
        if (finalizado) {
            throw new IllegalStateException("Não é possível alterar um pedido finalizado.");
        }
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        if (item instanceof Bebida && ((Bebida) item).isAlcoolica() && !cliente.isMaiorDeIdade()) {
            throw new IllegalArgumentException("Apenas clientes maiores de idade podem pedir bebidas alcoólicas.");
        }
        itens.add(item);
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        if (quantidade < 1) {
            throw new IllegalArgumentException("A quantidade deve ser pelo menos 1.");
        }
        for (int i = 0; i < quantidade; i++) {
            adicionarItem(item);
        }
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (ItemCardapio item : itens) {
            subtotal += item.calcularPreco();
        }
        return subtotal;
    }

    public double calcularTaxaEntrega() {
        return calcularSubtotal() >= VALOR_FRETE_GRATIS ? 0.0 : TAXA_ENTREGA;
    }

    @Override
    public double calcularValorCobrar() {
        return calcularSubtotal() + calcularTaxaEntrega();
    }

    public void finalizar() {
        if (finalizado) {
            throw new IllegalStateException("O pedido já foi finalizado.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Não é possível finalizar um pedido sem itens.");
        }
        cliente.creditarCashback(calcularSubtotal() * 0.05);
        finalizado = true;
    }

    public static int getTotalPedidosCriados() {
        return proximoNumero - 1;
    }
}
