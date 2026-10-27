package Aquecimento.A1;

public class App {

    public static void main(String[] args){

        System.out.println("Emitidas: "+Senha.getTotalEmitidas());

        Senha caixa = new Senha("Caixa");
        Senha gerente = new Senha("Gerência");
        Senha caixa2 = new Senha("Caixa");

        System.out.println("1 - "+caixa.getSetor());
        System.out.println("2 - "+gerente.getSetor());
        System.out.println("3 - "+caixa2.getSetor());

        try{
            Senha senhaInvalida = new Senha("");
        } catch (Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        
        Senha caixa3 = new Senha("Caixa");
        System.out.println("4 - "+caixa3.getSetor());

        System.out.println("Emitidas: "+Senha.getTotalEmitidas());


        // O método getTotalEmitidas e o atributo totalEmitidas precisam ser 
        // static para o código acima compilar, pois estamos chamando o método
        // antes mesmo de instanciar uma classe. Ao remover o static do contador
        // o VS Code acusa: Cannot make a static reference to the non-static field totalEmitidas
        // , pois a instancia de senha ainda não foi criada, e temos um método
        // estático chamando uma variável não estática.

        // O método getTotalEmitidas() precisa ser estático para conseguirmos 
        // chamar ele, sem uma instância da classe Senha criada. Se o método 
        // getTotalEmitidas() não for static, conseguiriamos chamá-lo apenas a partir
        // de uma instância de Senha.

        // A incrementação do contador ocorre após a validação do setor, isso foi
        // pensado propositalmente, pois assim evita que setores inválidos consumam
        // um número de senha, criando lacunas no contador. Assim, o contador é incrementado
        // apenas depois da validação de setor.
    }
    
}
