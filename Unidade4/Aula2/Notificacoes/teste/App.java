package teste;

public class App {
    public static void main(String[] args){

        NotificacaoEmail notEmail = new NotificacaoEmail("Titulo", "dtete", "Destinatario", "assunto", "remetente");
        NotificacaoApp notApp = new NotificacaoApp("tituo", "destiotario");

        notEmail.disparaNotificacao();
        notApp.disparaNotificacao();

    }
}
