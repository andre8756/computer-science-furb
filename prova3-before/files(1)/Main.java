// ------------------------------------------------------------
//  IMPORTS (ferramentas que pedimos emprestadas ao Java)
// ------------------------------------------------------------

// ----- Componentes de tela (Swing) -----
import javax.swing.JButton;          // botão
import javax.swing.JFileChooser;     // janelinha para escolher arquivo no computador
import javax.swing.JFrame;           // a janela principal do programa
import javax.swing.JLabel;           // texto fixo na tela (rótulo)
import javax.swing.JOptionPane;      // caixinhas de mensagem (avisos, erros, perguntas)
import javax.swing.JPanel;           // painel: uma "gaveta" para organizar componentes
import javax.swing.JScrollPane;      // coloca barra de rolagem em volta de algo
import javax.swing.JTable;           // a tabela
import javax.swing.JTextField;       // campo onde o usuário digita
import javax.swing.ListSelectionModel;           // controla como a seleção de linhas funciona
import javax.swing.table.DefaultTableCellRenderer; // "pintor" de células da tabela

// ----- Parte visual (AWT: a base antiga do Swing) -----
import java.awt.BorderLayout;        // organiza em 5 regiões: norte, sul, leste, oeste, centro
import java.awt.Color;               // cores
import java.awt.Component;           // qualquer coisa que aparece na tela
import java.awt.FlowLayout;          // organiza um do lado do outro, como palavras em um texto
import java.awt.Font;                // fontes (tipo de letra)
import java.awt.GridLayout;          // organiza em linhas/colunas iguais (grade)
import java.awt.font.TextAttribute;  // atributos da letra: negrito, sublinhado, RISCADO...

// ----- Arquivo e coleções -----
import java.io.File;
import java.io.IOException;
import java.util.HashMap;            // um "dicionário" (chave -> valor)
import java.util.Map;                // o tipo geral de dicionário

/*
 * ============================================================
 *  CLASSE MAIN  (a janela do programa)
 * ============================================================
 *  "extends JFrame" = "esta classe É uma janela".
 *  Igual ao seu exemplo da Saudação.
 *
 *  Resumo do que acontece aqui:
 *    1) Monta a janela: campos, tabela, botões
 *    2) Liga cada botão a um método (quando clicar, executa tal método)
 *    3) Usa a classe Carrinho para guardar/ler os dados
 */
public class Main extends JFrame {

    // ============================================================
    //  VARIÁVEIS DA CLASSE (os "pedaços" da janela e os dados)
    // ============================================================

    // Nome do arquivo onde o botão "Salvar" grava.
    // "static final" = é uma constante: vale para o programa todo e nunca muda.
    // Esse arquivo também é lido sozinho quando você abre o programa.
    // Ele fica na pasta de onde você executou o programa.
    private static final File ARQUIVO_PADRAO = new File("carrinho.dat");

    // ----- Os dados -----
    private Carrinho carrinho = new Carrinho();                       // o carrinho (lista de itens)
    private CarrinhoTableModel modelo = new CarrinhoTableModel(carrinho); // o tradutor carrinho -> tabela
    private JTable tabela = new JTable(modelo);                       // a tabela, que usa o tradutor

    // ----- Campos de texto (o número é a largura aproximada, em caracteres) -----
    private JTextField txtNome = new JTextField(15);
    private JTextField txtPreco = new JTextField(6);
    private JTextField txtQtd = new JTextField(4);

    // ----- Botões (o texto dentro das aspas é o que aparece escrito no botão) -----
    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnAlterar = new JButton("Alterar selecionado");
    private JButton btnExcluir = new JButton("Excluir selecionado");
    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnImportar = new JButton("Importar lista...");
    private JButton btnExportar = new JButton("Exportar lista...");

    // ----- Texto que mostra o total (vamos trocando o texto dele depois) -----
    private JLabel lblTotal = new JLabel("Total: R$ 0,00");

    // ============================================================
    //  CONSTRUTOR: monta a janela inteira
    // ============================================================
    //  Roda UMA vez, quando fazemos "new Main()" lá no final do arquivo.
    public Main() {

        // super("...") chama o construtor do JFrame. O texto vira o TÍTULO da janela.
        super("Carrinho de Supermercado");

        // Define como os componentes serão organizados na janela: BorderLayout.
        // Ele divide a janela em 5 regiões:
        //
        //         +-----------------------+
        //         |        NORTH          |   <- topo
        //         +------+--------+-------+
        //         | WEST | CENTER |  EAST |
        //         +------+--------+-------+
        //         |        SOUTH          |   <- rodapé
        //         +-----------------------+
        //
        // Os números (10, 10) são o espaço entre as regiões.
        setLayout(new BorderLayout(10, 10));

        // ----------------------------------------------------------
        //  PARTE 1: TOPO  (onde digitamos o item)
        // ----------------------------------------------------------

        // Criamos um painel com FlowLayout (um componente do lado do outro).
        JPanel painelTopo = new JPanel(new FlowLayout());

        // Adicionamos no painel, NA ORDEM em que queremos que apareçam:
        painelTopo.add(new JLabel("Nome:"));    // texto "Nome:"
        painelTopo.add(txtNome);                // campo para digitar o nome
        painelTopo.add(new JLabel("Preço:"));
        painelTopo.add(txtPreco);
        painelTopo.add(new JLabel("Qtd:"));
        painelTopo.add(txtQtd);
        painelTopo.add(btnAdicionar);           // botão Adicionar

        // Colocamos o painel inteiro na região NORTE (topo) da janela.
        add(painelTopo, BorderLayout.NORTH);

        // ----------------------------------------------------------
        //  PARTE 2: CENTRO  (a tabela)
        // ----------------------------------------------------------

        // Só permite selecionar UMA linha por vez
        // (senão "Alterar" e "Excluir" não saberiam qual linha usar).
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Altura de cada linha, em pixels (deixa mais confortável de ler).
        tabela.setRowHeight(24);

        // Limita a largura da coluna 0 (a do checkbox), para ela não ficar enorme.
        tabela.getColumnModel().getColumn(0).setMaxWidth(90);

        // Criamos o nosso "pintor" especial, que risca o texto dos itens comprados.
        // (A classe RiscadoRenderer está lá no final deste arquivo.)
        RiscadoRenderer renderer = new RiscadoRenderer();

        // Aplicamos o pintor nas colunas 1, 2, 3 e 4 (todas, menos a 0, que é o checkbox).
        // getColumnCount() = quantas colunas a tabela tem (5).
        for (int i = 1; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        // Colocamos a tabela dentro de um JScrollPane.
        // Se tiver muitos itens, aparece uma barra de rolagem.
        // Sem o JScrollPane, os títulos das colunas nem apareceriam!
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // ----------------------------------------------------------
        //  PARTE 3: RODAPÉ  (botões e total)
        // ----------------------------------------------------------

        // Painel com os 5 botões, um ao lado do outro.
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnImportar);
        painelBotoes.add(btnExportar);

        // Painel só para o texto do total, alinhado à direita.
        JPanel painelTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelTotal.add(lblTotal);

        // Painel do rodapé: uma grade com 2 linhas e 1 coluna.
        // Na linha de cima ficam os botões, na de baixo fica o total.
        JPanel painelSul = new JPanel(new GridLayout(2, 1));
        painelSul.add(painelBotoes);
        painelSul.add(painelTotal);

        // Colocamos esse painel na região SUL (rodapé) da janela.
        add(painelSul, BorderLayout.SOUTH);

        // ----------------------------------------------------------
        //  PARTE 4: LIGAR OS BOTÕES AOS MÉTODOS
        // ----------------------------------------------------------
        //  addActionListener = "fique de olho: quando este botão for clicado, faça isso".
        //
        //  A setinha  e -> metodo()  é uma LAMBDA (igual ao seu exemplo).
        //  Lê-se: "quando acontecer o evento 'e', chame o método tal".
        //  O "e" é o evento do clique (não vamos precisar dele, mas tem que existir).

        btnAdicionar.addActionListener(e -> adicionar());
        btnAlterar.addActionListener(e -> alterar());
        btnExcluir.addActionListener(e -> excluir());
        btnSalvar.addActionListener(e -> salvar());
        btnImportar.addActionListener(e -> importar());
        btnExportar.addActionListener(e -> exportar());

        // Ao CLICAR em uma linha da tabela, os dados dela sobem para os campos de texto.
        // Assim o usuário edita ali e clica em "Alterar selecionado".
        //
        // getSelectionModel() = o "controle" de seleção da tabela.
        // addListSelectionListener = "avise-me quando a seleção mudar".
        tabela.getSelectionModel().addListSelectionListener(e -> {
            // Um clique gera vários avisos seguidos (um enquanto o clique está "em andamento"
            // e outro quando termina). getValueIsAdjusting() == true significa "ainda em andamento".
            // O "!" significa NÃO. Então: só agimos quando o aviso é o FINAL.
            if (!e.getValueIsAdjusting()) {
                preencherCamposComSelecionado();
            }
        });

        // Obs: não precisamos de código extra para o checkbox!
        // Quem cuida dele é o CarrinhoTableModel (método setValueAt) e o RiscadoRenderer.

        // Se já existir o arquivo carrinho.dat, carrega a lista que estava salva.
        carregarArquivoPadrao();

        // ----------------------------------------------------------
        //  PARTE 5: CONFIGURAÇÕES FINAIS DA JANELA
        // ----------------------------------------------------------

        // Ao clicar no X da janela, o programa inteiro termina.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tamanho da janela: 760 de largura e 460 de altura (em pixels).
        setSize(760, 460);

        // null = centraliza a janela no meio da tela.
        setLocationRelativeTo(null);

        // Por último, MOSTRA a janela. (Sem isso ela existiria, mas ficaria invisível.)
        setVisible(true);
    }

    // =====================================================
    //   AÇÕES DOS BOTÕES
    //   (cada botão chama um destes métodos)
    // =====================================================

    // ----- BOTÃO ADICIONAR -----
    private void adicionar() {
        // lerCampos() lê o que foi digitado e devolve um Item pronto.
        // Se algo estiver errado (nome vazio, preço inválido...), devolve null (= "nada").
        Item item = lerCampos();

        if (item == null) {
            return;   // "return" aqui encerra o método. Já foi mostrada a mensagem de erro.
        }

        carrinho.adicionar(item);   // coloca o item na lista
        atualizarTela();            // redesenha a tabela e recalcula o total
        limparCampos();             // esvazia os campos para o próximo item
    }

    // ----- BOTÃO ALTERAR SELECIONADO -----
    private void alterar() {
        // getSelectedRow() devolve o número da linha selecionada.
        // Se NENHUMA estiver selecionada, devolve -1.
        int linha = tabela.getSelectedRow();

        if (linha < 0) {   // menor que zero = nenhuma linha escolhida
            JOptionPane.showMessageDialog(this, "Selecione um item na tabela para alterar.");
            return;
        }

        // Lê os campos de texto (que têm os valores novos que o usuário digitou).
        Item novo = lerCampos();
        if (novo == null) {
            return;
        }

        // Pega o item ANTIGO que está na lista, na posição da linha selecionada.
        Item existente = carrinho.getItens().get(linha);

        // Copia os valores novos para dentro do item antigo.
        // Não mexemos no "comprado": se estava marcado, continua marcado.
        existente.setNome(novo.getNome());
        existente.setPreco(novo.getPreco());
        existente.setQuantidade(novo.getQuantidade());

        atualizarTela();
        limparCampos();
    }

    // ----- BOTÃO EXCLUIR SELECIONADO -----
    private void excluir() {
        int linha = tabela.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um item na tabela para excluir.");
            return;
        }

        carrinho.remover(linha);   // tira da lista o item que está nessa posição
        atualizarTela();
        limparCampos();
    }

    // ----- BOTÃO SALVAR -----
    //  Grava a lista no arquivo padrão (carrinho.dat).
    private void salvar() {
        // try / catch = "tente fazer isto; se der erro, faça aquilo".
        // Gravar arquivo pode falhar (disco cheio, sem permissão...), por isso o try.
        try {
            carrinho.salvar(ARQUIVO_PADRAO);   // tenta gravar

            // Se chegou aqui, deu tudo certo. Mostra a mensagem com o caminho do arquivo.
            JOptionPane.showMessageDialog(this, "Lista salva em " + ARQUIVO_PADRAO.getAbsolutePath());

        } catch (IOException e) {
            // Se deu erro de arquivo, caímos aqui. Mostramos uma caixinha vermelha de erro.
            // e.getMessage() = a explicação técnica do erro.
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ----- BOTÃO EXPORTAR LISTA -----
    //  Grava a lista atual em um arquivo QUE O USUÁRIO ESCOLHE onde quiser.
    private void exportar() {

        // Cria a janelinha de "Salvar como...".
        JFileChooser chooser = new JFileChooser();

        // Já deixa um nome sugerido escrito no campo.
        chooser.setSelectedFile(new File("minha_lista.dat"));

        // Mostra a janelinha. Devolve qual botão o usuário apertou.
        // Se NÃO foi o "Salvar" (APPROVE_OPTION), ou seja, se ele cancelou, saímos do método.
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        // Pega o arquivo que o usuário escolheu.
        File arquivo = chooser.getSelectedFile();

        // Se o nome NÃO termina com ".dat", adicionamos ".dat" no final.
        // toLowerCase() deixa tudo minúsculo para comparar sem se preocupar com maiúsculas.
        // endsWith(".dat") pergunta: "termina com .dat?"
        if (!arquivo.getName().toLowerCase().endsWith(".dat")) {
            // Cria um File novo: mesma pasta + nome antigo + ".dat"
            arquivo = new File(arquivo.getParentFile(), arquivo.getName() + ".dat");
        }

        // Se já existe um arquivo com esse nome, perguntamos antes de sobrescrever.
        if (arquivo.exists()) {
            int resp = JOptionPane.showConfirmDialog(this,
                    "O arquivo já existe. Deseja substituir?", "Confirmar", JOptionPane.YES_NO_OPTION);

            // Se a resposta NÃO foi "Sim", desiste.
            if (resp != JOptionPane.YES_OPTION) {
                return;
            }
        }

        // Finalmente grava, do mesmo jeito do botão Salvar.
        try {
            carrinho.salvar(arquivo);
            JOptionPane.showMessageDialog(this, "Lista exportada para " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao exportar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ----- BOTÃO IMPORTAR LISTA -----
    //  Lê uma lista de outro arquivo e SUBSTITUI a lista atual.
    private void importar() {

        // Cria a janelinha de "Abrir arquivo...".
        JFileChooser chooser = new JFileChooser();

        // Se o usuário cancelou, saímos.
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        // Avisa que a lista atual vai ser substituída e pergunta se pode continuar.
        // O "\n" quebra a linha dentro da mensagem.
        int resp = JOptionPane.showConfirmDialog(this,
                "A lista atual será substituída pela lista importada.\n"
                        + "(Salve antes se quiser guardá-la.) Continuar?",
                "Importar", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Carrega o arquivo escolhido para dentro do carrinho.
            carrinho.carregar(chooser.getSelectedFile());

            // A lista mudou, então atualizamos a tabela e o total.
            atualizarTela();
            limparCampos();

        } catch (IOException e) {
            // Cai aqui se o arquivo estiver quebrado ou não for um arquivo de lista.
            JOptionPane.showMessageDialog(this,
                    "Não foi possível ler o arquivo (formato inválido?): " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    //   MÉTODOS AUXILIARES
    //   (ajudam os métodos de cima, para não repetir código)
    // =====================================================

    /*
     * Lê os 3 campos de texto e devolve um Item pronto.
     * Se algo estiver errado, mostra uma mensagem e devolve null (= "não deu").
     */
    private Item lerCampos() {

        // getText() pega o que está escrito no campo.
        // trim() tira espaços sobrando no começo e no fim ("  arroz " vira "arroz").
        String nome = txtNome.getText().trim();

        // Se o nome está vazio, avisa e para.
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do item.");
            return null;
        }

        // Converter texto em número pode dar erro (se o usuário digitar "abc").
        // Por isso usamos try/catch: tenta converter; se falhar, cai no catch.
        try {
            // O que o usuário digita é sempre TEXTO. Precisamos transformar em número.
            // replace(",", ".") troca vírgula por ponto, porque o Java só entende "3.50".
            // Assim o usuário pode digitar tanto "3,50" quanto "3.50".
            // Double.parseDouble = transforma texto em número com vírgula.
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));

            // Integer.parseInt = transforma texto em número inteiro.
            int qtd = Integer.parseInt(txtQtd.getText().trim());

            // Validação: preço não pode ser negativo e quantidade precisa ser pelo menos 1.
            // O "||" significa OU: basta UMA das condições ser verdadeira.
            if (preco < 0 || qtd <= 0) {
                JOptionPane.showMessageDialog(this, "Preço não pode ser negativo e a quantidade deve ser maior que zero.");
                return null;
            }

            // Tudo certo! Cria e devolve o Item.
            return new Item(nome, preco, qtd);

        } catch (NumberFormatException e) {
            // NumberFormatException = "o texto não é um número válido" (ex: "abc" ou campo vazio).
            JOptionPane.showMessageDialog(this, "Preço ou quantidade inválidos.");
            return null;
        }
    }

    // Pega o item da linha clicada e escreve os dados dele nos campos de texto.
    private void preencherCamposComSelecionado() {
        int linha = tabela.getSelectedRow();

        // Se não tem linha selecionada (-1), não há o que preencher.
        if (linha < 0) {
            return;
        }

        Item item = carrinho.getItens().get(linha);

        // setText() escreve dentro do campo.
        // String.valueOf() transforma número em texto (campo de texto só aceita texto).
        txtNome.setText(item.getNome());
        txtPreco.setText(String.valueOf(item.getPreco()));
        txtQtd.setText(String.valueOf(item.getQuantidade()));
    }

    // Esvazia os campos de texto e tira a seleção da tabela.
    private void limparCampos() {
        txtNome.setText("");
        txtPreco.setText("");
        txtQtd.setText("");
        tabela.clearSelection();   // nenhuma linha fica selecionada
        txtNome.requestFocus();    // o cursor volta a piscar no campo Nome
    }

    // Redesenha a tabela e recalcula o total.
    // Chamamos sempre que a lista de itens mudar.
    private void atualizarTela() {
        modelo.atualizar();   // manda a tabela redesenhar as linhas
        lblTotal.setText(String.format("Total: R$ %.2f", carrinho.getTotal()));   // novo total no texto
    }

    // Quando o programa abre, tenta carregar a lista salva da última vez.
    private void carregarArquivoPadrao() {
        if (ARQUIVO_PADRAO.exists()) {   // só tenta se o arquivo existir
            try {
                carrinho.carregar(ARQUIVO_PADRAO);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Não foi possível ler " + ARQUIVO_PADRAO.getName());
            }
        }
        atualizarTela();   // mostra na tela (mesmo se estiver vazio, para o total aparecer certinho)
    }

    // =====================================================
    //   CLASSE INTERNA: RiscadoRenderer
    //   Risca o texto dos itens já comprados
    // =====================================================
    //  Um "Renderer" é o PINTOR de cada célula da tabela.
    //  Toda vez que a tabela vai desenhar um quadradinho, ela pergunta ao pintor:
    //  "como eu pinto esta célula?". O nosso pintor responde:
    //  "se o item está comprado, pinte RISCADO e cinza; senão, pinte normal".
    //
    //  É uma classe "interna" (dentro da Main) para poder usar o "carrinho" da Main.
    //  "extends DefaultTableCellRenderer" = aproveita o pintor padrão e muda só o que queremos.
    private class RiscadoRenderer extends DefaultTableCellRenderer {

        // A tabela chama este método UMA VEZ PARA CADA CÉLULA que precisa desenhar.
        // Os parâmetros dizem qual célula é:
        //   t           = a tabela
        //   valor       = o texto que vai dentro da célula
        //   selecionado = a linha está selecionada (azulzinho)?
        //   foco        = a célula tem o foco do teclado?
        //   linha       = número da linha
        //   coluna      = número da coluna
        @Override
        public Component getTableCellRendererComponent(JTable t, Object valor,
                boolean selecionado, boolean foco, int linha, int coluna) {

            // Primeiro deixamos o pintor padrão fazer o trabalho normal.
            // "c" é o componente (o texto) que ele preparou.
            Component c = super.getTableCellRendererComponent(t, valor, selecionado, foco, linha, coluna);

            // Descobrimos: o item desta linha está comprado?
            boolean comprado = carrinho.getItens().get(linha).isComprado();

            // Uma fonte (tipo de letra) tem uma lista de "atributos": tamanho, negrito, riscado...
            // Pegamos os atributos da fonte atual da tabela e copiamos para um dicionário novo (Map),
            // para podermos modificar sem estragar a fonte original.
            Map<TextAttribute, Object> atributos = new HashMap<>(t.getFont().getAttributes());

            // Ligamos ou desligamos o RISCADO (STRIKETHROUGH em inglês):
            //   comprado == true  -> STRIKETHROUGH_ON (liga o risco)
            //   comprado == false -> Boolean.FALSE    (sem risco)
            atributos.put(TextAttribute.STRIKETHROUGH,
                    comprado ? TextAttribute.STRIKETHROUGH_ON : Boolean.FALSE);

            // Criamos uma fonte nova com esses atributos e aplicamos no texto da célula.
            c.setFont(t.getFont().deriveFont(atributos));

            // Cor do texto: cinza se comprado, cor normal se não.
            // Se a linha estiver SELECIONADA, deixamos a cor padrão da seleção
            // (para o texto não ficar ilegível em cima do azul).
            if (!selecionado) {
                c.setForeground(comprado ? Color.GRAY : t.getForeground());
            }

            // Alinhamento: colunas 2, 3 e 4 (preço, qtd, subtotal) ficam à DIREITA,
            // como números em uma conta. A coluna 1 (nome) fica à ESQUERDA.
            setHorizontalAlignment(coluna >= 2 ? RIGHT : LEFT);

            // Devolvemos a célula já pintada para a tabela desenhar.
            return c;
        }
    }

    // =====================================================
    //   MAIN: o ponto de partida do programa
    // =====================================================
    //  O Java sempre começa a executar por este método.
    //  Aqui só criamos a janela: o construtor lá em cima faz o resto.
    public static void main(String[] args) {
        new Main();
    }
}
