package autenticacaoregistro;

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
    private String usuario;
    @DatabaseField
    private String senha;

    public Empresa() {
    }
    public Empresa(String nome, String cnpj, String usuario, String senha) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.usuario = usuario;
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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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