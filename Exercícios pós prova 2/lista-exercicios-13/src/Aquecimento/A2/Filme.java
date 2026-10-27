package Aquecimento.A2;

public class Filme extends Midia {

    Filme(String descricao, double precoBase){
        super(descricao, precoBase);
    }

    @Override
    public double calcularPreco(){
        return getPrecoBase();
    }

}
