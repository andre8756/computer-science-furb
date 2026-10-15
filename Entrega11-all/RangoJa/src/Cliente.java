
public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private double saldoCashback;
    private Cliente indicadoPor;

    public Cliente(String nome, String email, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("O e-mail precisa conter @.");
        }

        this.nome = nome.trim();
        this.email = email.trim();
        this.saldoCashback = 0.0;
        setIdade(idade);
    }

    public Cliente(String nome, String email, int idade, Cliente indicadoPor) {
        this(nome, email, idade);
        if (indicadoPor == null) {
            throw new IllegalArgumentException("O cliente indicador é obrigatório.");
        }
        this.indicadoPor = indicadoPor;
        indicadoPor.creditarCashback(10.0);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("A idade deve estar entre 0 e 120 anos.");
        }
        this.idade = idade;
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public Cliente getIndicadoPor() {
        return indicadoPor;
    }

    public boolean isMaiorDeIdade() {
        return idade >= 18;
    }

    public void creditarCashback(double valor) {
        if (valor <= 0.0) {
            throw new IllegalArgumentException("O valor do cashback deve ser maior que zero.");
        }
        saldoCashback += valor;
    }

    public boolean usarCashback(double valor) throws SaldoInsuficienteException {
        if (valor <= 0.0) {
            throw new IllegalArgumentException("O valor do cashback deve ser maior que zero.");
        }
        if (valor > saldoCashback) {
            throw new SaldoInsuficienteException(saldoCashback, valor);
        }
        saldoCashback -= valor;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente outro = (Cliente) obj;
        return email.equalsIgnoreCase(outro.email);
    }

    @Override
    public String toString() {
        return nome + " <" + email + ">";
    }
}
