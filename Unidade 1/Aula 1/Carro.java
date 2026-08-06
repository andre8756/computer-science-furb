public class Carro{

    String marca;
    String modelo;
    int ano;
    String cor;
    int velocidadeAtual;
    boolean situacaoAtual;

    public void acelerar(){
        velocidadeAtual += 10;
    }

    public void freiar(){
        velocidadeAtual = 0;
        situacaoAtual = false;
    }

    public void alterarSituacao(boolean situacao){
        situacaoAtual = situacao;
    }

    public boolean situacaoAtual(){
        return situacaoAtual;
    }


}