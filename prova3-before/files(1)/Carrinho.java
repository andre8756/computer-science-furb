// ------------------------------------------------------------
//  IMPORTS
// ------------------------------------------------------------
//  "import" é como pedir ferramentas emprestadas do Java.
//  Se a gente não importar, o Java não sabe o que é "File", "List", etc.

import java.io.DataInputStream;    // LÊ dados de um arquivo (texto, números, true/false)
import java.io.DataOutputStream;   // ESCREVE dados em um arquivo
import java.io.File;               // representa um arquivo no computador (o caminho dele)
import java.io.FileInputStream;    // abre um arquivo para LEITURA (bytes)
import java.io.FileOutputStream;   // abre um arquivo para ESCRITA (bytes)
import java.io.IOException;        // erro que acontece quando mexemos com arquivos
import java.util.ArrayList;        // um tipo de lista que cresce sozinha
import java.util.List;             // o "tipo" lista (a forma geral de uma lista)

/*
 * ============================================================
 *  CLASSE CARRINHO
 * ============================================================
 *  É o carrinho de compras de verdade.
 *  Ela tem duas responsabilidades:
 *     1) Guardar a LISTA de itens (adicionar, remover, somar total)
 *     2) Saber SALVAR e CARREGAR essa lista em um arquivo
 *
 *  Repare: aqui também não tem nada de tela. Quem mostra
 *  as coisas na tela é a classe Main.
 *
 *  COMO O ARQUIVO É GRAVADO (formato):
 *  Imagine que o arquivo é uma fita de bytes. Gravamos nesta ordem:
 *
 *      [ quantos itens existem ]            <- um número inteiro
 *      Para cada item, na ordem:
 *          [ nome ]                          <- texto
 *          [ preço ]                         <- número com vírgula
 *          [ quantidade ]                    <- número inteiro
 *          [ comprado? ]                     <- verdadeiro ou falso
 *
 *  Para LER, precisamos ler EXATAMENTE na mesma ordem em que gravamos.
 *  Se errar a ordem, os dados vêm embaralhados!
 */
public class Carrinho {

    // A lista onde ficam todos os itens.
    //  - List<Item>      = "uma lista que só aceita objetos do tipo Item"
    //  - new ArrayList<>() = cria a lista de verdade, vazia no começo
    //  - "final" = a variável sempre aponta para ESTA lista (não vai trocar de lista).
    //              Mas podemos adicionar e remover itens de dentro dela normalmente.
    private final List<Item> itens = new ArrayList<>();

    // ------------------------------------------------------------
    //  MÉTODOS DA LISTA
    // ------------------------------------------------------------

    // Coloca um item novo no fim da lista.
    public void adicionar(Item item) {
        itens.add(item);
    }

    // Remove o item que está na posição "indice".
    // ATENÇÃO: a contagem começa no ZERO.
    //   posição 0 = primeiro item, posição 1 = segundo item, e assim por diante.
    public void remover(int indice) {
        itens.remove(indice);
    }

    // Devolve a lista inteira (a tabela da tela usa isso para desenhar as linhas).
    public List<Item> getItens() {
        return itens;
    }

    // Soma o subtotal de todos os itens e devolve o total do carrinho.
    public double getTotal() {
        double total = 0;                    // começa com zero reais
        for (Item item : itens) {            // "para cada item dentro da lista de itens..."
            total += item.getSubtotal();     // ...some o subtotal dele no total
        }                                    // (total += x  é o mesmo que  total = total + x)
        return total;
    }

    // ------------------------------------------------------------
    //  SALVAR EM ARQUIVO
    // ------------------------------------------------------------

    // "throws IOException" significa: "este método pode dar erro de arquivo,
    // e quem me chamar é que decide o que fazer com esse erro".
    // (Lá na classe Main, mostramos uma mensagem de erro na tela.)
    public void salvar(File arquivo) throws IOException {

        // try ( ... ) { ... }  chama-se "try-with-resources".
        // O que abrimos dentro dos parênteses é FECHADO AUTOMATICAMENTE no fim do bloco.
        // Isso é importante: arquivo aberto e esquecido pode dar problema.
        // (No seu exemplo você usava fos.close() na mão. Aqui o Java fecha por nós.)
        //
        // Montamos duas "camadas":
        //   FileOutputStream  -> sabe escrever BYTES no arquivo (como no seu exemplo)
        //   DataOutputStream  -> fica por cima e sabe escrever texto, números e boolean
        //                        (ele converte tudo em bytes para o FileOutputStream)
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(arquivo))) {

            // 1) Primeiro gravamos QUANTOS itens existem.
            //    Assim, na hora de ler, sabemos quantas vezes repetir a leitura.
            out.writeInt(itens.size());

            // 2) Agora gravamos os dados de cada item, um por um.
            for (Item item : itens) {
                out.writeUTF(item.getNome());          // texto (nome)
                out.writeDouble(item.getPreco());      // número com vírgula (preço)
                out.writeInt(item.getQuantidade());    // número inteiro (quantidade)
                out.writeBoolean(item.isComprado());   // true ou false (comprado)
            }
        }
        // Chegou aqui = o arquivo já foi fechado automaticamente.
    }

    // ------------------------------------------------------------
    //  CARREGAR DE ARQUIVO
    // ------------------------------------------------------------

    /*
     * Lê o arquivo e SUBSTITUI tudo que está no carrinho agora.
     *
     * Truque de segurança: primeiro lemos tudo para uma lista TEMPORÁRIA
     * ("lidos"). Só se a leitura inteira der certo é que trocamos a lista
     * de verdade. Assim, se o arquivo estiver quebrado ou for o arquivo errado,
     * o carrinho atual continua intacto e você não perde nada.
     */
    public void carregar(File arquivo) throws IOException {

        // Lista temporária, vazia, só para guardar o que formos lendo.
        List<Item> lidos = new ArrayList<>();

        // Mesma ideia do salvar, mas agora no sentido contrário (LER):
        //   FileInputStream -> lê BYTES do arquivo
        //   DataInputStream -> transforma os bytes de volta em texto, números e boolean
        try (DataInputStream in = new DataInputStream(new FileInputStream(arquivo))) {

            // 1) Lemos quantos itens existem (foi a primeira coisa que gravamos).
            int quantidade = in.readInt();

            // 2) Repetimos a leitura dessa quantidade de vezes.
            //    "for (int i = 0; i < quantidade; i++)" significa:
            //    começa com i = 0, repete enquanto i for menor que "quantidade",
            //    e a cada volta soma 1 em i.
            for (int i = 0; i < quantidade; i++) {

                // ORDEM IMPORTANTÍSSIMA: tem que ser a mesma ordem do salvar():
                // nome -> preço -> quantidade -> comprado
                String nome = in.readUTF();
                double preco = in.readDouble();
                int qtd = in.readInt();
                boolean comprado = in.readBoolean();

                // Criamos um Item novo com o que foi lido e guardamos na lista temporária.
                lidos.add(new Item(nome, preco, qtd, comprado));
            }
        }
        // Se chegou até aqui, a leitura inteira deu certo!
        // (Se tivesse dado erro, o Java teria pulado direto para fora do método.)

        // Agora sim: esvaziamos o carrinho de verdade e colocamos os itens lidos.
        // Usamos clear() + addAll() em vez de criar uma lista nova, porque a tabela
        // da tela está "olhando" para ESTA lista. Se trocássemos a lista por outra,
        // a tabela continuaria olhando para a antiga.
        itens.clear();
        itens.addAll(lidos);
    }
}
