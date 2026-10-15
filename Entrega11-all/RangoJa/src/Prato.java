
public class Prato extends ItemCardapio {
    private char tamanho;

    public Prato(String nome, double precoBase, char tamanho) {
        super(nome, precoBase);
        if (tamanho != 'P' && tamanho != 'M' && tamanho != 'G') {
            throw new IllegalArgumentException("O tamanho deve ser P, M ou G.");
        }
        this.tamanho = tamanho;
    }

    public char getTamanho() {
        return tamanho;
    }

    @Override
    public double calcularPreco() {
        switch (tamanho) {
            case 'P': return getPrecoBase();
            case 'M': return getPrecoBase() * 1.30;
            case 'G': return getPrecoBase() * 1.60;
            default: throw new IllegalStateException("Tamanho de prato inválido.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (tamanho " + tamanho + ")";
    }
}
