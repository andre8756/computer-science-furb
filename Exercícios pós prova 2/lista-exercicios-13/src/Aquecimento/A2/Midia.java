package Aquecimento.A2;

public abstract class Midia {
    private String descricao;
    private double precoBase;

    Midia(String descricao, double precoBase){
        setDescricao(descricao);
        setPrecoBase(precoBase);
    }

    public abstract double calcularPreco();

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        if(descricao == null || descricao.isBlank()) { throw new IllegalArgumentException("Descrição obrigatória"); }

        this.descricao = descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    private void setPrecoBase(double precoBase) {
        if(precoBase <= 0) { throw new IllegalArgumentException("Preço base deve ser maior que zero"); }

        this.precoBase = precoBase;
    }   

    
}   
