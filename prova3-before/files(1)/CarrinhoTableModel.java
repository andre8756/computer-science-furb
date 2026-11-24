import javax.swing.table.AbstractTableModel;   // base pronta do Swing para criar o "cérebro" de uma tabela

/*
 * ============================================================
 *  CLASSE CarrinhoTableModel
 * ============================================================
 *  PROBLEMA: a tela (JTable) só sabe desenhar linhas e colunas.
 *            O carrinho só sabe guardar uma lista de itens.
 *            Um não conhece o outro!
 *
 *  SOLUÇÃO: esta classe é um TRADUTOR (um "intérprete") entre os dois.
 *  A JTable fica perguntando para ela coisas como:
 *      - "Quantas linhas eu desenho?"
 *      - "Quantas colunas?"
 *      - "O que escrevo na linha 2, coluna 1?"
 *  E esta classe responde olhando para o Carrinho.
 *
 *  "extends AbstractTableModel" = "herda" de uma classe pronta do Swing.
 *  Ela já faz muita coisa; nós só preenchemos o que é específico do nosso carrinho.
 *
 *  Sobre o JCheckBox:
 *  A coluna 0 é do tipo Boolean. Quando uma coluna é Boolean,
 *  a JTable desenha automaticamente um JCheckBox em cada linha dela.
 */
public class CarrinhoTableModel extends AbstractTableModel {

    // Os títulos que aparecem no topo de cada coluna.
    // A posição no array é o número da coluna: 0, 1, 2, 3, 4.
    private final String[] colunas = {"Comprado", "Item", "Preço (R$)", "Qtd", "Subtotal (R$)"};

    // O carrinho que esta tabela vai mostrar.
    private final Carrinho carrinho;

    // Construtor: quem criar o TableModel precisa dizer qual carrinho ele vai mostrar.
    public CarrinhoTableModel(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    // ------------------------------------------------------------
    //  MÉTODOS QUE A JTABLE EXIGE QUE A GENTE PREENCHA
    //  (o @Override avisa: "estou reescrevendo um método da classe pai")
    // ------------------------------------------------------------

    // PERGUNTA DA TABELA: "Quantas linhas eu desenho?"
    // RESPOSTA: uma linha para cada item que existe no carrinho.
    @Override
    public int getRowCount() {
        return carrinho.getItens().size();   // size() = quantos itens tem na lista
    }

    // PERGUNTA DA TABELA: "Quantas colunas eu desenho?"
    // RESPOSTA: o tamanho do array de títulos (5).
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    // PERGUNTA DA TABELA: "Qual o título da coluna número X?"
    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    // PERGUNTA DA TABELA: "Que TIPO de dado tem a coluna número X?"
    // Isso é o que faz o checkbox aparecer:
    //   - Coluna 0 -> Boolean -> a JTable desenha um JCheckBox
    //   - As outras -> String -> a JTable desenha texto normal
    //
    // Sobre a sintaxe:  condição ? valorSeVerdadeiro : valorSeFalso
    // É um "if" em uma linha só. Lê-se: "se coluna == 0, devolve Boolean, senão devolve String".
    @Override
    public Class<?> getColumnClass(int coluna) {
        return coluna == 0 ? Boolean.class : String.class;
    }

    // PERGUNTA DA TABELA: "O usuário pode editar a célula (linha, coluna) clicando nela?"
    // RESPOSTA: só a coluna 0 (o checkbox). As outras colunas são só para olhar.
    // (Para mudar nome/preço/quantidade, usamos os campos de texto e o botão Alterar.)
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna == 0;
    }

    // PERGUNTA DA TABELA: "O que eu escrevo na célula da linha X, coluna Y?"
    // É o método mais importante: ele entrega o conteúdo de cada quadradinho.
    @Override
    public Object getValueAt(int linha, int coluna) {

        // Pega o item que está na posição "linha" da lista.
        // Linha 0 da tabela = primeiro item da lista, e assim por diante.
        Item item = carrinho.getItens().get(linha);

        // "switch" é como vários "if" em sequência: olha o número da coluna
        // e escolhe o que devolver.
        switch (coluna) {
            case 0: return item.isComprado();                         // true/false -> vira o checkbox
            case 1: return item.getNome();                            // texto do nome
            case 2: return String.format("%.2f", item.getPreco());    // preço com 2 casas decimais
            case 3: return String.valueOf(item.getQuantidade());      // número convertido em texto
            case 4: return String.format("%.2f", item.getSubtotal()); // subtotal com 2 casas decimais
            default: return "";                                       // não deveria acontecer
        }
        // Sobre "%.2f": é uma "máscara". O "f" significa número com vírgula
        // e o ".2" significa duas casas depois da vírgula. Ex: 5.5 vira "5,50".
    }

    // AVISO DA TABELA: "O usuário mudou o valor da célula (linha, coluna) para 'valor'. Guarde isso!"
    // Só vai acontecer na coluna 0, quando o usuário clica no checkbox.
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        if (coluna == 0) {
            // (Boolean) valor  = "o valor que chegou é um Boolean, pode usar como tal".
            // Guardamos a escolha dentro do próprio Item.
            carrinho.getItens().get(linha).setComprado((Boolean) valor);

            // Avisamos a tabela: "a linha 'linha' mudou, redesenhe ela".
            // É isso que faz o risco aparecer/sumir na hora.
            fireTableRowsUpdated(linha, linha);
        }
    }

    // ------------------------------------------------------------
    //  MÉTODO NOSSO (não é exigência da JTable)
    // ------------------------------------------------------------

    // Chame este método sempre que a LISTA mudar (adicionou, alterou, excluiu, importou).
    // Ele avisa a tabela: "os dados mudaram, redesenhe tudo do zero".
    public void atualizar() {
        fireTableDataChanged();
    }
}
