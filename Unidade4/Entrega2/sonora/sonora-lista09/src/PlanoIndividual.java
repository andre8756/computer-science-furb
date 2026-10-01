public class PlanoIndividual {
    private String nome;
    private int maxDispositivos;
    private double precoMensal;

    public PlanoIndividual(double precoMensal) {
        this.nome = "Individual";
        this.maxDispositivos = 1;
        setPrecoMensal(precoMensal);
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

    public void setPrecoMensal(double precoMensal) {
        if (precoMensal <= 0) {
            throw new IllegalArgumentException("Preco deve ser positivo");
        }
        this.precoMensal = precoMensal;
    }

    public boolean temAnuncios() {
        return false;
    }

    public double calcularMensalidade() {
        return precoMensal;
    }

    public String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}