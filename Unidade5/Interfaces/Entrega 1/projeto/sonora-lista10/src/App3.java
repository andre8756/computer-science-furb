public class App3 {
    public static void main(String[] args){
        
        // Tipo estático = Conteudo  ---- Tipo dinâmico Podcast
        Conteudo c = new Podcast("titulo1", 45, "artista1", 1);

        // c.getApresentador 
        // Este comando não compila, pois a nossa variável estática
        // é o Conteudo, onde não possui um método getApresentador()

    }    
}
