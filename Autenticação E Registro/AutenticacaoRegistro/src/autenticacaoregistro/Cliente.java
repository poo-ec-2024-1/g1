package autenticacaoregistro;

import com.j256.ormlite.field.DatabaseField;

/**
 *  POJO para o banco de dados dos clientes
 * 
 * @author Matheus TP
 */
public class Cliente{
    // Atributos da classe dos clientes. Novos atributos podem ser adicionados, contanto que a adaptação seja feita no código
    // abaixo e que um novo banco de dados seja criado. Adicionei somente alguns para teste.
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String cpf;
    @DatabaseField
    private String usuario;
    @DatabaseField
    private String senha;
    // Métodos Construtores
    public Cliente() {
    }
    public Cliente(String nome, String cpf, String usuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
    }
    // Getters e Setters
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}