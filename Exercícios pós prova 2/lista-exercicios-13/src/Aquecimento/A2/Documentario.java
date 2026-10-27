package Aquecimento.A2;

public class Documentario extends Midia implements Legendavel {

    Documentario(String descricao, double precoBase) {
        super(descricao, precoBase);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }

    @Override
    public double calcularCustoLegenda(){
        return calcularPreco() * 0.1f;
    }
}
