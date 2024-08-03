package Model;

import com.j256.ormlite.field.DatabaseField;

/**
 *  POJO para o banco de dados dos serviços
 * @author Matheus TP
 */
public class Servico{
    
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String descricao;
    @DatabaseField
    private float preco;
    @DatabaseField
    private int empResponsavel;

    public Servico() {
    }

    public Servico(String nome, String descricao, float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEmpResponsavel() {
        return empResponsavel;
    }

    public void setEmpResponsavel(int empResponsavel) {
        this.empResponsavel = empResponsavel;
    }
    
}