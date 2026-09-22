public class Veiculo {

    private int anoFabricacao;
    private String marca;
    private String modelo;
    private int valor;

    public Veiculo(int valor){
        this.valor = valor;
    }

    public Veiculo(){
        this.valor = 0;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getValor() {
        return valor;
    }

    public String toString(){
        return modelo+" - "+marca;
    }
}
