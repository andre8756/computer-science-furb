import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    // Arquivo padrão onde o botão "Salvar" grava (e que é lido ao abrir o programa)
    private static final File ARQUIVO_PADRAO = new File("carrinho.dat");

    private Carrinho carrinho = new Carrinho();
    private CarrinhoTableModel modelo = new CarrinhoTableModel(carrinho);
    private JTable tabela = new JTable(modelo);

    private JTextField txtNome = new JTextField(15);
    private JTextField txtPreco = new JTextField(6);
    private JTextField txtQtd = new JTextField(4);

    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnAlterar = new JButton("Alterar selecionado");
    private JButton btnExcluir = new JButton("Excluir selecionado");
    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnImportar = new JButton("Importar lista...");
    private JButton btnExportar = new JButton("Exportar lista...");

    private JLabel lblTotal = new JLabel("Total: R$ 0,00");

    public Main() {
        super("Carrinho de Supermercado");
        setLayout(new BorderLayout(10, 10));

        // ---------- Topo: campos para digitar o item ----------
        JPanel painelTopo = new JPanel(new FlowLayout());
        painelTopo.add(new JLabel("Nome:"));
        painelTopo.add(txtNome);
        painelTopo.add(new JLabel("Preço:"));
        painelTopo.add(txtPreco);
        painelTopo.add(new JLabel("Qtd:"));
        painelTopo.add(txtQtd);
        painelTopo.add(btnAdicionar);
        add(painelTopo, BorderLayout.NORTH);

        // ---------- Centro: tabela ----------
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setRowHeight(24);
        tabela.getColumnModel().getColumn(0).setMaxWidth(90);
        RiscadoRenderer renderer = new RiscadoRenderer();
        for (int i = 1; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // ---------- Rodapé: botões e total ----------
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnImportar);
        painelBotoes.add(btnExportar);

        JPanel painelTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelTotal.add(lblTotal);

        JPanel painelSul = new JPanel(new GridLayout(2, 1));
        painelSul.add(painelBotoes);
        painelSul.add(painelTotal);
        add(painelSul, BorderLayout.SOUTH);

        // ---------- Eventos ----------
        btnAdicionar.addActionListener(e -> adicionar());
        btnAlterar.addActionListener(e -> alterar());
        btnExcluir.addActionListener(e -> excluir());
        btnSalvar.addActionListener(e -> salvar());
        btnImportar.addActionListener(e -> importar());
        btnExportar.addActionListener(e -> exportar());

        // Ao clicar em uma linha, os dados vão para os campos de texto (para poder alterar)
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                preencherCamposComSelecionado();
            }
        });

        // Se marcar/desmarcar o checkbox, o total não muda, mas a tabela se redesenha sozinha

        carregarArquivoPadrao();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(760, 460);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // =====================================================
    //                    AÇÕES DOS BOTÕES
    // =====================================================

    private void adicionar() {
        Item item = lerCampos();
        if (item == null) {
            return; // dados inválidos; a mensagem já foi mostrada
        }
        carrinho.adicionar(item);
        atualizarTela();
        limparCampos();
    }

    private void alterar() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um item na tabela para alterar.");
            return;
        }
        Item novo = lerCampos();
        if (novo == null) {
            return;
        }
        Item existente = carrinho.getItens().get(linha);
        existente.setNome(novo.getNome());
        existente.setPreco(novo.getPreco());
        existente.setQuantidade(novo.getQuantidade());
        atualizarTela();
        limparCampos();
    }

    private void excluir() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um item na tabela para excluir.");
            return;
        }
        carrinho.remover(linha);
        atualizarTela();
        limparCampos();
    }

    /** Salva no arquivo padrão (carrinho.dat). */
    private void salvar() {
        try {
            carrinho.salvar(ARQUIVO_PADRAO);
            JOptionPane.showMessageDialog(this, "Lista salva em " + ARQUIVO_PADRAO.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Grava a lista atual em um arquivo escolhido pelo usuário. */
    private void exportar() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("minha_lista.dat"));
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File arquivo = chooser.getSelectedFile();
        if (!arquivo.getName().toLowerCase().endsWith(".dat")) {
            arquivo = new File(arquivo.getParentFile(), arquivo.getName() + ".dat");
        }
        if (arquivo.exists()) {
            int resp = JOptionPane.showConfirmDialog(this,
                    "O arquivo já existe. Deseja substituir?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (resp != JOptionPane.YES_OPTION) {
                return;
            }
        }
        try {
            carrinho.salvar(arquivo);
            JOptionPane.showMessageDialog(this, "Lista exportada para " + arquivo.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao exportar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Carrega uma lista de outro arquivo, substituindo a lista atual. */
    private void importar() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        int resp = JOptionPane.showConfirmDialog(this,
                "A lista atual será substituída pela lista importada.\n"
                        + "(Salve antes se quiser guardá-la.) Continuar?",
                "Importar", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            carrinho.carregar(chooser.getSelectedFile());
            atualizarTela();
            limparCampos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível ler o arquivo (formato inválido?): " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    //                   MÉTODOS AUXILIARES
    // =====================================================

    /** Lê os 3 campos e devolve um Item, ou null se algo estiver inválido. */
    private Item lerCampos() {
        String nome = txtNome.getText().trim();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do item.");
            return null;
        }
        try {
            // aceita "3,50" e "3.50"
            double preco = Double.parseDouble(txtPreco.getText().trim().replace(",", "."));
            int qtd = Integer.parseInt(txtQtd.getText().trim());
            if (preco < 0 || qtd <= 0) {
                JOptionPane.showMessageDialog(this, "Preço não pode ser negativo e a quantidade deve ser maior que zero.");
                return null;
            }
            return new Item(nome, preco, qtd);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço ou quantidade inválidos.");
            return null;
        }
    }

    private void preencherCamposComSelecionado() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) {
            return;
        }
        Item item = carrinho.getItens().get(linha);
        txtNome.setText(item.getNome());
        txtPreco.setText(String.valueOf(item.getPreco()));
        txtQtd.setText(String.valueOf(item.getQuantidade()));
    }

    private void limparCampos() {
        txtNome.setText("");
        txtPreco.setText("");
        txtQtd.setText("");
        tabela.clearSelection();
        txtNome.requestFocus();
    }

    private void atualizarTela() {
        modelo.atualizar();
        lblTotal.setText(String.format("Total: R$ %.2f", carrinho.getTotal()));
    }

    private void carregarArquivoPadrao() {
        if (ARQUIVO_PADRAO.exists()) {
            try {
                carrinho.carregar(ARQUIVO_PADRAO);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Não foi possível ler " + ARQUIVO_PADRAO.getName());
            }
        }
        atualizarTela();
    }

    // =====================================================
    //   Renderer que risca o texto dos itens já comprados
    // =====================================================
    private class RiscadoRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable t, Object valor,
                boolean selecionado, boolean foco, int linha, int coluna) {

            Component c = super.getTableCellRendererComponent(t, valor, selecionado, foco, linha, coluna);
            boolean comprado = carrinho.getItens().get(linha).isComprado();

            Map<TextAttribute, Object> atributos = new HashMap<>(t.getFont().getAttributes());
            atributos.put(TextAttribute.STRIKETHROUGH,
                    comprado ? TextAttribute.STRIKETHROUGH_ON : Boolean.FALSE);
            c.setFont(t.getFont().deriveFont(atributos));

            if (!selecionado) {
                c.setForeground(comprado ? Color.GRAY : t.getForeground());
            }
            setHorizontalAlignment(coluna >= 2 ? RIGHT : LEFT);
            return c;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
