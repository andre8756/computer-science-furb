package setup;

import java.util.ArrayList;

public class Orcamento {
    private Cliente solicitante;
    private Entrega entrega;
    private ArrayList<ItemSetup> itens = new ArrayList();
    public Orcamento(Cliente solicitante, String cidade, int prazoDias) {
        
        

        if(cidade == null || cidade.isBlank()){
            throw new IllegalArgumentException("Cidade é obrigatória");
        }

        if(prazoDias >= 0){
            throw new IllegalArgumentException("Prazo dias é obrigatória");
        }
        
        setSolicitante(solicitante);
        this.entrega = new Entrega(cidade, prazoDias);
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Cliente solicitante) {
        if(solicitante == null){
            throw new IllegalArgumentException("Solicitante obrigatório");
        }
        
        this.solicitante = solicitante;
    }

    public ArrayList<ItemSetup> getItens() {
        return itens;
    }

    

    
    
}
