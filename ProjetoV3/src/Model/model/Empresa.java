package Model.model;

import com.j256.ormlite.field.DatabaseField;

/**
 *  POJO para o banco de dados da empresa
 * 
 * @author Matheus TP
 */
public class Empresa{
    // Atributos da classe das empresas. Novos atributos podem ser adicionados, contanto que a adaptação seja feita no código
    // abaixo e que um novo banco de dados seja criado. Adicionei somente alguns para teste.
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String cnpj;
    @DatabaseField
    private String cep;
    @DatabaseField
    private String telefone;
    @DatabaseField
    private String descricao;
    @DatabaseField
    private String email;
    @DatabaseField
    private String cidade;
    @DatabaseField
    private String estado;
    @DatabaseField
    private String endereco;

    public Empresa() {
    }

    public Empresa(String nome, String cnpj, String cep, String telefone, String descricao, String email, String cidade, String estado, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.telefone = telefone;
        this.descricao = descricao;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}