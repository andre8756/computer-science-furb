
import java.util.Locale;

public interface Cobravel {
    double calcularValorCobrar();

    default String gerarComprovante() {
        return String.format(Locale.forLanguageTag("pt-BR"),
                "Valor a cobrar: R$ %.2f", calcularValorCobrar());
    }
}
