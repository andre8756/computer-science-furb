import javax.swing.table.AbstractTableModel;

/**
 * Faz a ligação entre o Carrinho (dados) e a JTable (tela).
 * A coluna 0 é Boolean, então a JTable a desenha como um JCheckBox.
 */
public class CarrinhoTableModel extends AbstractTableModel {

    private final String[] colunas = {"Comprado", "Item", "Preço (R$)", "Qtd", "Subtotal (R$)"};
    private final Carrinho carrinho;

    public CarrinhoTableModel(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public int getRowCount() {
        return carrinho.getItens().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        return coluna == 0 ? Boolean.class : String.class;
    }

    // Só o checkbox é editado direto na tabela
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna == 0;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Item item = carrinho.getItens().get(linha);
        switch (coluna) {
            case 0: return item.isComprado();
            case 1: return item.getNome();
            case 2: return String.format("%.2f", item.getPreco());
            case 3: return String.valueOf(item.getQuantidade());
            case 4: return String.format("%.2f", item.getSubtotal());
            default: return "";
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        if (coluna == 0) {
            carrinho.getItens().get(linha).setComprado((Boolean) valor);
            fireTableRowsUpdated(linha, linha);
        }
    }

    /** Chame depois de adicionar/alterar/remover/importar itens. */
    public void atualizar() {
        fireTableDataChanged();
    }
}
