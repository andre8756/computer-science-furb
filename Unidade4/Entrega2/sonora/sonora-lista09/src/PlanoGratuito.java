public class PlanoGratuito extends Plano {

    public PlanoGratuito() {
        super();
    }

    @Override
    public double calcularMensalidade() {
        return 0.0;
    }

    @Override
    public String resumo() {
        return super.getNome() + ": R$ " + calcularMensalidade()
                + " por mes, " + super.getMaxDispositivos() + " dispositivo(s)";
    }
}