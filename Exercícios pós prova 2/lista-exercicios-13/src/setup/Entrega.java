package setup;

public class Entrega {

    private String cidade;
    private int prazoDias;

    public Entrega(String cidade, int prazoDias) {

        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade é obrigatório");
        }
        if (prazoDias <= 0) {
            throw new IllegalArgumentException("O prazo precisa ser maior que zero");
        }
        this.cidade = cidade;
        this.prazoDias = prazoDias;
    }

    public String getCidade() {
        return cidade;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

}
