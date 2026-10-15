

public class Bebida extends ItemCardapio {
    private int volumeMl;
    private boolean alcoolica;

    public Bebida(String nome, double precoBase, int volumeMl, boolean alcoolica) {
        super(nome, precoBase);
        // TODO: inicializar os atributos específicos de Bebida.
    }

    public int getVolumeMl() {
        // TODO
        return 0;
    }

    public boolean isAlcoolica() {
        // TODO
        return false;
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
