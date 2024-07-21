package telaagendamentocliente;

/**
 * FXMLTelaAgendamentoCliente Model Class
 * 
 * @author matheus teixeira pires
 */
public class AgendamentoCliente {
    private String nomeServico, data, horario, tempo, preco, servEndereco, servCidade, servEstado, descricao, nomeEmpresa, 
            cnpj, telefone, email, cep, empEndereco, empCidade, empEstado;
    
    public AgendamentoCliente(String nomeServico, String data, String horario, String tempo,String preco, String servEndereco,
            String servCidade, String servEstado, String descricao, String nomeEmpresa, String cnpj, String telefone, String email,
            String cep, String empEndereco,String empCidade, String empEstado) {
        this.nomeServico = nomeServico;
        this.data = data;
        this.horario = horario;
        this.tempo = tempo;
        this.preco = preco;
        this.servEndereco = servEndereco;
        this.servCidade = servCidade;
        this.servEstado = servEstado;
        this.descricao = descricao;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.empEndereco = empEndereco;
        this.empCidade = empCidade;
        this.empEstado = empEstado;
    }

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
    public String getServEndereco() {
        return servEndereco;
    }
    public void setServEndereco(String servEndereco) {
        this.servEndereco = servEndereco;
    }
    public String getServCidade() {
        return servCidade;
    }
    public void setServCidade(String servCidade) {
        this.servCidade = servCidade;
    }
    public String getServEstado() {
        return servEstado;
    }
    public void setServEstado(String servEstado) {
        this.servEstado = servEstado;
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
    public String getEmpEndereco() {
        return empEndereco;
    }
    public void setEmpEndereco(String empEndereco) {
        this.empEndereco = empEndereco;
    }
    public String getEmpCidade() {
        return empCidade;
    }
    public void setEmpCidade(String empCidade) {
        this.empCidade = empCidade;
    }
    public String getEmpEstado() {
        return empEstado;
    }
    public void setEmpEstado(String empEstado) {
        this.empEstado = empEstado;
    }
    
    @Override
    public String toString(){
        return (getNomeServico() + " - " + getNomeEmpresa());
    }
}
