public class PlanoGratuito {
    private String nome;
    private int maxDispositivos;

    public PlanoGratuito() {
        this.nome = "Gratuito";
        this.maxDispositivos = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

    public boolean temAnuncios() {
        return true;
    }

    public double calcularMensalidade() {
        return 0.0;
    }

    public String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}