public class Funcionario extends Pessoa {

    public Funcionario(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void verAgendamentos() {
        System.out.println("Funcionário visualizando agendamentos.");
    }

    @Override
    public void gerirAgendamentos() {
        System.out.println("Funcionário gerindo agendamentos.");
    }

    @Override
    public void verSolicitacoes() {
        System.out.println("Funcionário visualizando solicitações.");
    }

    @Override
    public void editarPerfil() {
        System.out.println("Funcionário editando perfil.");
    }

    public void gerarRelatorios() {
        System.out.println("Funcionário gerando relatórios.");
    }
}
