

public class Prato extends ItemCardapio {
    private char tamanho;

    public Prato(String nome, double precoBase, char tamanho) {
        super(nome, precoBase);
        // TODO: inicializar os atributos específicos de Prato.
    }

    public char getTamanho() {
        // TODO
        return '\0';
    }

    @Override
    public double calcularPreco() {
        // TODO
        return 0.0;
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }
}
