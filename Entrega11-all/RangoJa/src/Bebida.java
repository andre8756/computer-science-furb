

public class Bebida extends ItemCardapio {
    private int volumeMl;
    private boolean alcoolica;

    public Bebida(String nome, double precoBase, int volumeMl, boolean alcoolica) {
        super(nome, precoBase);
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("O volume da bebida deve ser maior que zero.");
        }
        this.volumeMl = volumeMl;
        this.alcoolica = alcoolica;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    @Override
    public double calcularPreco() {
        double preco;
        
        if(isAlcoolica()) {
            preco = getPrecoBase()+3.0;
        } else{
            preco = getPrecoBase();
        }

        return preco;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + volumeMl + " ml)" + (alcoolica ? " [alcoólica]" : "");
    }
}
