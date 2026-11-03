package setup;

public class Montagem extends ItemSetup{
    private int horas;

    public Montagem(String descricao, double precoBase, int horas) {
        super(descricao, precoBase);

        if (horas <= 0) {
            throw new IllegalArgumentException("Horas inválidas");
        }

        this.horas = horas;
    }

    @Override
    public double calcularPreco(){
        return 0;
    }

    public int getHoras() {
        return horas;
    }

    
}
