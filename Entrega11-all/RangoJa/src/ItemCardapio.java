

public abstract class ItemCardapio {
    private String nome;
    private double precoBase;

    public ItemCardapio(String nome, double precoBase) {
        // TODO: inicializar os atributos.
    }

    public String getNome() {
        // TODO
        return null;
    }

    public double getPrecoBase() {
        // TODO
        return 0.0;
    }

    public void setPrecoBase(double precoBase) {
        // TODO
    }

    public static void validarPositivo(double valor) {
        // TODO
    }

    public abstract double calcularPreco();

    public final double calcularPrecoComDesconto(double percentual) {
        // TODO
        return 0.0;
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }
}
