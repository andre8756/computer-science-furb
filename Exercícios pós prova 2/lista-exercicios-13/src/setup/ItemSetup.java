package setup;

public abstract class ItemSetup {
    private static int totalItens = 0;
    private int codigo;
    private String descricao;
    private double precoBase;

    ItemSetup(String descricao, double precoBase) {
        
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Cidade é obrigatório");
        }
        if (precoBase <= 0) {
            throw new IllegalArgumentException("Preço base inválido");
        }
        
        this.descricao = descricao;
        this.precoBase = precoBase;
        totalItens++;
        codigo += totalItens;
    }

    public static int getTotalItens() {
        return totalItens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();
    
    @Override
    public String toString(){
        return "";
    }
}
