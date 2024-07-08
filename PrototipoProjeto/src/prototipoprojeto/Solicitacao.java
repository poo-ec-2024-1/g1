public class Solicitacao {
    private String descricao;
    private String cliente;

    public Solicitacao(String descricao, String cliente) {
        this.descricao = descricao;
        this.cliente = cliente;
    }

    // Getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
