

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public static final double TAXA_ENTREGA = 7.0;
    public static final double VALOR_FRETE_GRATIS = 100.0;
    private static int proximoNumero = 1;

    private int numero;
    private boolean finalizado;

    // Relacionamentos do diagrama.
    private Cliente cliente;
    private List<ItemCardapio> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        // TODO: inicializar os atributos.
    }

    public int getNumero() {
        // TODO
        return 0;
    }

    public Cliente getCliente() {
        // TODO
        return null;
    }

    public boolean isFinalizado() {
        // TODO
        return false;
    }

    public void adicionarItem(ItemCardapio item) {
        // TODO
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        // TODO
    }

    public int getQuantidadeItens() {
        // TODO
        return 0;
    }

    public double calcularSubtotal() {
        // TODO
        return 0.0;
    }

    public double calcularTaxaEntrega() {
        // TODO
        return 0.0;
    }

    public double calcularValorCobrar() {
        // TODO
        return 0.0;
    }

    public void finalizar() {
        // TODO
    }

    public static int getTotalPedidosCriados() {
        // TODO
        return 0;
    }
}
