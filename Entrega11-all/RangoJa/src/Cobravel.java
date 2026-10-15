

public interface Cobravel {
    double calcularValorCobrar();

    default String gerarComprovante() {
        // TODO
        return null;
    }
}
