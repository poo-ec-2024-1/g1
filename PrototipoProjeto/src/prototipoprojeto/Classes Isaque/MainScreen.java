import java.util.Scanner;

public class MainScreen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Simulação de login
        System.out.println("Bem-vindo ao sistema de lavagem de carros!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        // Instanciando um funcionário para o exemplo
        Funcionario usuario = new Funcionario(nome, email);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Ver Agendamentos");
            System.out.println("2. Gerir Agendamentos");
            System.out.println("3. Ver Solicitações");
            System.out.println("4. Editar Perfil");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    usuario.verAgendamentos();
                    break;
                case 2:
                    usuario.gerirAgendamentos();
                    break;
                case 3:
                    usuario.verSolicitacoes();
                    break;
                case 4:
                    usuario.editarPerfil();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        
        scanner.close();
    }
}
