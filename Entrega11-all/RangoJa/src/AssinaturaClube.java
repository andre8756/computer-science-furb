

public class AssinaturaClube implements Cobravel {
    private double valorMensal;
    private int meses;

    // Relacionamento: cada assinatura pertence a um Cliente.
    private Cliente cliente;

    public AssinaturaClube(Cliente cliente, double valorMensal, int meses) {
        // TODO: inicializar os atributos.
    }

    public Cliente getCliente() {
        // TODO
        return null;
    }

    public double getValorMensal() {
        // TODO
        return 0.0;
    }

    public int getMeses() {
        // TODO
        return 0;
    }

    @Override
    public double calcularValorCobrar() {
        // TODO
        return 0.0;
    }
}
