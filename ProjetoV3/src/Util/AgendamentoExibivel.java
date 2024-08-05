package Util;


public class AgendamentoExibivel {
    
    private int id;
    private String servico;
    private String entidade;
    private String preco;
    private String veiculo;
    private String data;
    private String hora;
    private String endereco;

    public AgendamentoExibivel() {
    }

    public AgendamentoExibivel(int id, String servico, String empresa, String preco, String veiculo, String data, String hora, String endereco) {
        this.id = id;
        this.servico = servico;
        this.entidade = empresa;
        this.preco = preco;
        this.veiculo = veiculo;
        this.data = data;
        this.hora = hora;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
