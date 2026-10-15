
public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private double saldoCashback;

    private Cliente indicadoPor;

    public Cliente(String nome, String email, int idade) {
        // TODO: inicializar os atributos.
    }

    public Cliente(String nome, String email, int idade, Cliente indicadoPor) {
        // TODO: inicializar os atributos.
    }

    public String getNome() {
        // TODO
        return null;
    }

    public String getEmail() {
        // TODO
        return null;
    }

    public int getIdade() {
        // TODO
        return 0;
    }

    public void setIdade(int idade) {
        // TODO
    }

    public double getSaldoCashback() {
        // TODO
        return 0.0;
    }

    public Cliente getIndicadoPor() {
        // TODO
        return null;
    }

    public boolean isMaiorDeIdade() {
        // TODO
        return false;
    }

    public void creditarCashback(double valor) {
        // TODO
    }

    public boolean usarCashback(double valor) throws SaldoInsuficienteException {
        // TODO
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO
        return false;
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }
}
