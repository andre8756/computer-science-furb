

public class Sobremesa extends ItemCardapio {
    private int pesoGramas;

    public Sobremesa(String nome, double precoPor100g, int pesoGramas) {
        super(nome, precoPor100g);
        if (pesoGramas <= 0) {
            throw new IllegalArgumentException("O peso da sobremesa deve ser maior que zero.");
        }
        this.pesoGramas = pesoGramas;
    }

    public int getPesoGramas() {
        return pesoGramas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * pesoGramas / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + pesoGramas + " g)";
    }
}
