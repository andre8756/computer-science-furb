/**
 * Representa um item do carrinho de supermercado.
 */
public class Item {

    private String nome;
    private double preco;
    private int quantidade;
    private boolean comprado; // true = já pegou o item (aparece riscado)

    public Item(String nome, double preco, int quantidade) {
        this(nome, preco, quantidade, false);
    }

    public Item(String nome, double preco, int quantidade, boolean comprado) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.comprado = comprado;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
