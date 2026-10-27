package Aquecimento.A2;

public class Serie extends Midia implements Legendavel{
    private int temporadas;

    Serie(String descricao, double precoBase, int temporadas){
        super(descricao, precoBase);

        setTemporadas(temporadas);
    }

    @Override
    public double calcularPreco(){
        return getPrecoBase() * temporadas;
    }

    @Override
    public double calcularCustoLegenda(){
        return calcularPreco() * 0.1f;
    }

    public int getTemporadas() {
        return temporadas;
    }

    private void setTemporadas(int temporadas) {
        
        if(temporadas <= 0){ throw new IllegalArgumentException("Temporada deve ser maior que zero"); }
        
        this.temporadas = temporadas;
    }

}
