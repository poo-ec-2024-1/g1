package telaagendamentocliente;

/**
 * FXMLTelaAgendamentoCliente Model Class
 * 
 * @author matheus teixeira pires
 */
public class AgendamentoCliente {
    private String nomeServico, data, horario, tempo, preco, localizacao, descricao, nomeEmpresa, 
            cnpj, telefone, email, cep, endereco;
    
    public AgendamentoCliente(String nomeServico, String data, String horario, String tempo,
            String preco, String localizacao, String descricao, String nomeEmpresa, String cnpj, 
            String telefone, String email, String cep, String endereco) {
        this.nomeServico = nomeServico;
        this.data = data;
        this.horario = horario;
        this.tempo = tempo;
        this.preco = preco;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
    }
    // Getters and Setters
    public String getNomeServico() {
        return nomeServico;
    }
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getTempo() {
        return tempo;
    }
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString(){
        return (getNomeServico() + " - " + getNomeEmpresa());
    }
}
