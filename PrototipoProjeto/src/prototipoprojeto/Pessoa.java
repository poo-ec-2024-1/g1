public abstract class Pessoa implements Usuario {
    protected String nome;
    protected String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Métodos comuns
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Implementações vazias dos métodos da interface
    @Override
    public void verAgendamentos() {}

    @Override
    public void gerirAgendamentos() {}

    @Override
    public void verSolicitacoes() {}

    @Override
    public void editarPerfil() {}
}
