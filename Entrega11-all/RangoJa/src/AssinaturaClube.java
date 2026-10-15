
public class AssinaturaClube implements Cobravel {
    private double valorMensal;
    private int meses;
    private Cliente cliente;

    public AssinaturaClube(Cliente cliente, double valorMensal, int meses) {
        if (cliente == null) {
            throw new IllegalArgumentException("A assinatura precisa ter um cliente.");
        }
        ItemCardapio.validarPositivo(valorMensal);
        if (meses < 1) {
            throw new IllegalArgumentException("A assinatura precisa ter pelo menos 1 mês.");
        }
        this.cliente = cliente;
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public int getMeses() {
        return meses;
    }

    @Override
    public double calcularValorCobrar() {
        double total = valorMensal * meses;
        return meses >= 12 ? total * 0.85 : total;
    }
}
