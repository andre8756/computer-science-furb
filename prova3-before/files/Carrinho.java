import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Guarda a lista de itens e sabe salvar/carregar essa lista em arquivo binário.
 *
 * Formato do arquivo:
 *   int  -> quantidade de itens
 *   para cada item: UTF nome, double preço, int quantidade, boolean comprado
 */
public class Carrinho {

    private final List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
    }

    public void remover(int indice) {
        itens.remove(indice);
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    // ---------------- ARQUIVO ----------------

    public void salvar(File arquivo) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(arquivo))) {
            out.writeInt(itens.size());
            for (Item item : itens) {
                out.writeUTF(item.getNome());
                out.writeDouble(item.getPreco());
                out.writeInt(item.getQuantidade());
                out.writeBoolean(item.isComprado());
            }
        }
    }

    /**
     * Lê o arquivo e SUBSTITUI o conteúdo atual do carrinho.
     * Se der erro no meio da leitura, o carrinho atual não é alterado.
     */
    public void carregar(File arquivo) throws IOException {
        List<Item> lidos = new ArrayList<>();

        try (DataInputStream in = new DataInputStream(new FileInputStream(arquivo))) {
            int quantidade = in.readInt();
            for (int i = 0; i < quantidade; i++) {
                String nome = in.readUTF();
                double preco = in.readDouble();
                int qtd = in.readInt();
                boolean comprado = in.readBoolean();
                lidos.add(new Item(nome, preco, qtd, comprado));
            }
        }

        itens.clear();
        itens.addAll(lidos);
    }
}
