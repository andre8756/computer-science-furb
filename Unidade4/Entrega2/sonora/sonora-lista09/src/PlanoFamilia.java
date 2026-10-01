public class PlanoFamilia {
    private String nome;
    private int maxDispositivos;
    private double precoMensal;
    private int quantidadeMembros;

    public PlanoFamilia(double precoMensal, int quantidadeMembros) {
        this.nome = "Familia";
        this.maxDispositivos = 6;
        setPrecoMensal(precoMensal);
        setQuantidadeMembros(quantidadeMembros);
    }

    public String getNome() {
        return nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public int getQuantidadeMembros() {
        return quantidadeMembros;
    }

    public void setPrecoMensal(double precoMensal) {
        if (precoMensal <= 0) {
            throw new IllegalArgumentException("Preco deve ser positivo");
        }
        this.precoMensal = precoMensal;
    }

    public void setQuantidadeMembros(int quantidadeMembros) {
        if (quantidadeMembros < 1 || quantidadeMembros > 6) {
            throw new IllegalArgumentException("Membros deve ser de 1 a 6");
        }
        this.quantidadeMembros = quantidadeMembros;
    }

    public boolean temAnuncios() {
        return false;
    }

    public double calcularMensalidade() {
        return precoMensal + 4.90 * (quantidadeMembros - 1);
    }

    public String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}
