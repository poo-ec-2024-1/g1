package Model.model;

import com.j256.ormlite.field.DatabaseField;

/**
 *  POJO para o banco de dados dos clientes
 */
public class Cliente{
    // Atributos da classe dos clientes. Novos atributos podem ser adicionados, contanto que a adaptação seja feita no código
    // abaixo e que um novo banco de dados seja criado. Adicionei somente alguns para teste.
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String dataNascimento;
    @DatabaseField
    private String email;
    @DatabaseField
    private String telefone;
    @DatabaseField
    private String estado;
    @DatabaseField
    private String cpf;
    @DatabaseField
    private String cep;
    @DatabaseField
    private String cidade;
    @DatabaseField
    private String senha;

    public Cliente() {
    }

    public Cliente(String nome, String dataNascimento, String email, String telefone, String endereco, String cpf, String cep, String cidade, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.estado = endereco;
        this.cpf = cpf;
        this.cep = cep;
        this.cidade = cidade;
        this.senha = senha;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}