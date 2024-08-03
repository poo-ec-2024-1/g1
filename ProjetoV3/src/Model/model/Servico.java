package Model.model;

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
    private String expediente;
    @DatabaseField
    private int empResponsavel;

    public Servico() {
    }

    public Servico(String nome, String descricao, float preco, String expediente, int empResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.empResponsavel = empResponsavel;
        this.expediente = expediente;
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

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}