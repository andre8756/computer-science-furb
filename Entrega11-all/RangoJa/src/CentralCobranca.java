

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CentralCobranca {
    private List<Cobravel> cobrancas = new ArrayList<>();

    public void registrar(Cobravel cobravel) {
        if (cobravel == null) {
            throw new IllegalArgumentException("A cobrança não pode ser nula.");
        }
        cobrancas.add(cobravel);
    }

    public double calcularTotalAReceber() {
        double total = 0.0;
        for (Cobravel cobravel : cobrancas) {
            total += cobravel.calcularValorCobrar();
        }
        return total;
    }

    public int getQuantidadeCobrancas() {
        return cobrancas.size();
    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        for (Cobravel cobravel : cobrancas) {
            if (relatorio.length() > 0) {
                relatorio.append(System.lineSeparator());
            }
            relatorio.append(cobravel.gerarComprovante());
        }
        if (relatorio.length() > 0) {
            relatorio.append(System.lineSeparator());
        }
        relatorio.append(String.format(Locale.forLanguageTag("pt-BR"),
                "Total a receber: R$ %.2f", calcularTotalAReceber()));
        return relatorio.toString();
    }
}
