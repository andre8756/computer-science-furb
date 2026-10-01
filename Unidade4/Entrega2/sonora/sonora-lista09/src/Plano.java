public abstract class Plano {
    private String nome;
    private int maxDispositivos;

    public Plano() {
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

    public abstract double calcularMensalidade();

    public abstract String resumo();

}
