/*
 * ============================================================
 *  CLASSE ITEM
 * ============================================================
 *  Pense numa classe como uma "FORMA DE BOLO".
 *  A forma (classe) é só o molde. Cada bolo que sai dela é um "objeto".
 *
 *  Aqui, a classe Item é o molde de UM produto do supermercado.
 *  Cada vez que fizermos  new Item(...)  nasce um item novo, por exemplo:
 *      - Arroz, R$ 25.00, 2 unidades
 *      - Leite, R$ 5.50, 6 unidades
 *
 *  Esta classe NÃO tem nada de tela (Swing) nem de arquivo.
 *  Ela só guarda os dados de um produto. Isso é POO:
 *  cada classe cuida de UMA coisa só.
 */
public class Item {

    // ------------------------------------------------------------
    //  ATRIBUTOS (são as "características" do item)
    // ------------------------------------------------------------
    //  "private" = só esta classe pode mexer direto nessas variáveis.
    //  Quem está de fora precisa pedir usando os métodos get/set
    //  (aparecem lá embaixo). Isso se chama ENCAPSULAMENTO:
    //  é como um cofre, você só abre pela porta oficial.

    private String nome;        // nome do produto, ex: "Arroz"
    private double preco;       // preço de UMA unidade, ex: 25.50
    private int quantidade;     // quantas unidades vamos comprar, ex: 2
    private boolean comprado;   // true = já coloquei no carrinho (vai aparecer riscado)
                                // false = ainda falta pegar

    // ------------------------------------------------------------
    //  CONSTRUTORES
    // ------------------------------------------------------------
    //  Construtor é um método especial que roda quando fazemos "new Item(...)".
    //  Ele tem o MESMO NOME da classe e não tem tipo de retorno.
    //  Serve para já criar o objeto com os valores preenchidos.

    // Construtor 1: usado quando o usuário adiciona um item novo na tela.
    // Um item novo ainda NÃO foi comprado, então "comprado" começa como false.
    public Item(String nome, double preco, int quantidade) {
        // "this(...)" chama o outro construtor (o de baixo), passando false no final.
        // Assim não precisamos repetir o código.
        this(nome, preco, quantidade, false);
    }

    // Construtor 2: usado quando lemos o item de um arquivo,
    // porque lá o item pode já estar marcado como comprado (true).
    public Item(String nome, double preco, int quantidade, boolean comprado) {
        // "this.nome" = o atributo da classe (lá em cima)
        // "nome"      = o parâmetro que chegou aqui dentro dos parênteses
        // Escrevemos "this.nome = nome" para dizer: "guarde o que chegou no atributo".
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.comprado = comprado;
    }

    // ------------------------------------------------------------
    //  MÉTODO DE CÁLCULO
    // ------------------------------------------------------------

    // Devolve quanto custa este item no total (preço x quantidade).
    // Exemplo: arroz a 25.00, 2 unidades -> 50.00
    public double getSubtotal() {
        return preco * quantidade;
    }

    // ------------------------------------------------------------
    //  GETTERS e SETTERS
    // ------------------------------------------------------------
    //  GET = "pegar"  -> devolve o valor do atributo (só para ler)
    //  SET = "definir" -> troca o valor do atributo (para alterar)
    //
    //  Como os atributos são "private", o resto do programa usa
    //  esses métodos para ler e mudar os valores.

    public String getNome() {
        return nome;            // devolve o nome guardado
    }

    public void setNome(String nome) {
        this.nome = nome;       // troca o nome por um novo
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

    // Para atributos boolean, o costume em Java é usar "is" em vez de "get".
    // Lê-se: "isComprado()?" -> "está comprado?" -> true ou false
    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
