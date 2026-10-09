import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 // extends PlanoGratuito
// erro: The type App2 cannot subclass the final class PlanoGratuito
// O erro ocorre por a classe PlanoGratuito por ser final

{

    public static void main(String[] args) {

        PlanoGratuito pg = new PlanoGratuito();

        System.out.println(pg.getNome());

        // Plano plano = new Plano("TEste", 1);
        // PlanoPago planoPago = new PlanoPago("TEste", 1, 1);
        // Conteudo cont = new Conteudo("teste", 2);

        Plataforma plataforma = new Plataforma();
        Scanner scanner = new Scanner(System.in);

        // ====================================================================
        // 4. DEMONSTRAÇÃO INICIAL (Reprodução e contagem)
        // ====================================================================
        System.out.println("--- INICIANDO DEMONSTRAÇÃO ---");

        Musica musicaDemo = new Musica("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        Podcast podcastDemo = new Podcast("NerdCast", 5400, "Jovem Nerd", 850);

        plataforma.cadastrarMusica(musicaDemo);

        // Reproduzindo a música 3 vezes
        musicaDemo.reproduzir();
        musicaDemo.reproduzir();
        musicaDemo.reproduzir();

        // Reproduzindo o podcast 2 vezes
        podcastDemo.reproduzir();
        podcastDemo.reproduzir();

        // Exibindo o resultado final da contagem
        System.out.println("\n--- STATUS APÓS REPRODUÇÕES ---");
        System.out.println(musicaDemo.toString());
        System.out.println(podcastDemo.toString());

        // Criando um utilizador base para testarmos o menu
        Usuario usuarioDemo = new Usuario("Maria", "maria@email.com");
        plataforma.cadastrarUsuario(usuarioDemo);
        System.out.println("\nUsuário de teste cadastrado: " + usuarioDemo.getNome());
        System.out.println("====================================================\n");

        // ====================================================================
        // MENU DA APLICAÇÃO (Com tratamento de exceções)
        // ====================================================================
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Trocar de Plano do Usuário");
            System.out.println("2. Ver Resumo do Plano Atual");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do enter

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do usuário: ");
                        String nomeUsuario = scanner.nextLine();
                        Usuario usuario = plataforma.buscarUsuario(nomeUsuario);

                        if (usuario == null) {
                            // O método buscarUsuario já imprime que não foi encontrado
                            break;
                        }

                        System.out.println("Escolha o novo plano:");
                        System.out.println("1 - Gratuito");
                        System.out.println("2 - Pago Individual");
                        System.out.println("3 - Pago Família");
                        System.out.print("Opção de plano: ");

                        int opcaoPlano = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer

                        Plano novoPlano = null;

                        if (opcaoPlano == 1) {
                            novoPlano = new PlanoGratuito();

                        } else if (opcaoPlano == 2) {
                            System.out.print("Qual será o preço mensal do plano individual? R$ ");
                            double preco = scanner.nextDouble();
                            novoPlano = new PlanoIndividual(preco);

                        } else if (opcaoPlano == 3) {
                            System.out.print("Qual será o preço mensal base do plano família? R$ ");
                            double preco = scanner.nextDouble();
                            System.out.print("Quantos membros a família terá (1 a 6)? ");
                            int membros = scanner.nextInt();
                            novoPlano = new PlanoFamilia(preco, membros);

                        } else {
                            System.out.println("Opção de plano inválida!");
                            break;
                        }

                        // Se chegou até aqui, tenta realizar a assinatura
                        usuario.assinar(novoPlano);
                        System.out.println("✅ Plano alterado com sucesso para o usuário " + usuario.getNome() + "!");
                        break;

                    case 2:
                        System.out.print("Digite o nome do usuário: ");
                        String nomeResumo = scanner.nextLine();
                        Usuario usuarioResumo = plataforma.buscarUsuario(nomeResumo);

                        if (usuarioResumo != null) {
                            System.out.println("\n=== RESUMO DO PLANO ===");
                            System.out.println("Usuário: " + usuarioResumo.getNome());
                            System.out.println(usuarioResumo.getPlanoUsuario().resumo());
                            System.out.println("=======================");
                        }
                        break;

                    case 3:
                        executando = false;
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida. Escolha um número entre 1 e 3.");
                }

            } catch (InputMismatchException e) {
                // Captura letras digitadas onde se esperam números
                System.out.println("❌ Erro de Entrada: Você deve digitar um número válido.");
                scanner.nextLine(); // Limpa o input incorreto para evitar loop infinito

            } catch (IllegalArgumentException e) {
                // Captura regras de negócio quebradas (ex: preço negativo, membros fora do
                // limite)
                System.out.println("❌ Erro de Validação: " + e.getMessage());

            } catch (Exception e) {
                // Captura qualquer outro erro imprevisto, garantindo que o programa nunca
                // quebre
                System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
