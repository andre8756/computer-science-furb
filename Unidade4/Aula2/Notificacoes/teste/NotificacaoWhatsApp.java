package teste;

public class NotificacaoWhatsApp extends NotificacaoTelefone {
    private String usuario;

    public NotificacaoWhatsApp(String titulo, String destinatario, String numeroTelefone){
        super(titulo, destinatario, numeroTelefone);
    }

    @Override
    public void disparaNotificacao(){
        System.out.println("Envio de notificação via WhatsApp");
    }
}
