
public abstract class ItemCardapio {
    private String nome;
    private double precoBase;

    public ItemCardapio(String nome, double precoBase) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item é obrigatório.");
        }
        this.nome = nome.trim();
        setPrecoBase(precoBase);
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        validarPositivo(precoBase);
        this.precoBase = precoBase;
    }

    protected static void validarPositivo(double valor) {
        if (valor <= 0.0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
    }

    public abstract double calcularPreco();

    public final double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0.0 || percentual > 100.0) {
            throw new IllegalArgumentException("O desconto deve estar entre 0 e 100%.");
        }
        return calcularPreco() * (1.0 - percentual / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f", nome, calcularPreco());
    }
}
