public class ContaBancaria {
    
    private String numero;
    private String titular;
    private double saldo;

    public String numero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public String getTitular(){
        return titular;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor){
        if(valor >= 0){
            saldo += valor;
            System.out.printf("Depósito na conta %s de R$ %.2f realizado com sucesso!\n", titular, valor);
            System.out.printf("Saldo atual da conta: %.2f\n", saldo);
        } else{
            System.out.println("O valor depositado não pode ser negativo!");
        }
    }

    public void sacar(double valor){
        if (valor <= saldo && valor >= 0){
            saldo -= valor;
            System.out.printf("Saque na conta %s de R$ %.2f realizado com sucesso!\n", titular, valor);
            System.out.printf("Saldo atual da conta: %.2f\n", saldo);
        } else{
            System.out.println("O valor de saque não pode ser negativo e nem maior que o saldo em conta!");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valor){
        if(valor <= saldo && valor >= 0){
            contaDestino.depositar(valor);
            saldo -= valor;
            System.out.printf("Transferência da conta %s para a conta %s de R$ %.2f realizada com sucesso!!", titular, contaDestino.titular, valor);
        } else{
            System.out.println("Falha na transferência!!");
            System.out.printf("Saldo atual da conta: %.2f\n", saldo);
        }

    }

}
