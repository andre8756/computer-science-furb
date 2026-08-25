public class Playlist {
    private String nome;
    private Usuario dono;
    private int quantidadeMax = 100;
    private Musica musicas[] = new Musica[quantidadeMax];

    public Playlist(String nome, Usuario dono){
        this.nome = nome;
        this.dono = dono;
    }

    public String getNome(){
        return nome;
    }

    public Usuario getDono(){
        return dono;
    }

    public int getQuantidade(){
        int contador = 0;

        for(int i = 0; i < 99; i++){
            if(musicas[i] != null){
                contador++;
            }
        }

        return contador;
    }

    public boolean adicionar(Musica musica){
        
        for(int i = 0; i < 99; i++){
            if(musicas[i] == null && musica != null){
                musicas[i] = musica;
                return true;
            }
        }

        return false;
    }

    public Musica getNaPosicao(int indice){
        
        if(indice >= 0 && indice <= 100){
            return musicas[indice];
        }
        
        return null;
    }

    public boolean removerNaPosicao(int indice){
        if(indice >= 0 && indice <= 99){
            musicas[indice] = null;
            organizarPlaylist();
            return true;
        }
        return false;
    }

    public int getDuracaoTotalSegundos(){
        int duracaoTotalSeg = 0;

        for(int i = 0; i < quantidadeMax; i++){
            
            if(musicas[i] != null){
                duracaoTotalSeg += musicas[i].getDuracaoSegundos();
            }
        }

        return duracaoTotalSeg;
    }

    public void reproduzirTudo(){

        for(int i = 0; i < quantidadeMax; i++){
            
            if(musicas[i] != null){
                musicas[i].reproduzir();
            }
        }
    }


    // --------- Metodos Auxiliares

    public void organizarPlaylist(){
        boolean troca = true;
        Musica musicaTemp;

        while(troca){
            troca = false;

            for(int i = 0; i < (quantidadeMax - 1); i++){
                if(musicas[i] == null && musicas[i+1] != null){
                    troca = true;

                    musicaTemp = musicas[i];
                    musicas[i] = musicas[i+1];
                    musicas[i+1] = musicaTemp;
                }
            }
        }
    }


}