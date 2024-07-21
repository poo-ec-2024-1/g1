public class Cliente extends Pessoa {

    public Cliente(String nome, String email) {
        super(nome, email);
    }

    @Override
    public void verAgendamentos() {
        System.out.println("Cliente visualizando seus agendamentos.");
    }

    @Override
    public void gerirAgendamentos() {
        System.out.println("Cliente gerindo seus agendamentos.");
    }

    @Override
    public void verSolicitacoes() {
        System.out.println("Cliente visualizando solicitações.");
    }

    @Override
    public void editarPerfil() {
        System.out.println("Cliente editando perfil.");
    }

    public void fazerSolicitacao() {
        System.out.println("Cliente fazendo uma solicitação.");
    }
}
